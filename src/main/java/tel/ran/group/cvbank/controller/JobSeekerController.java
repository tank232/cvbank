package tel.ran.group.cvbank.controller;

import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import tel.ran.group.cvbank.exception.InputValidationException;
import tel.ran.group.cvbank.model.entity.CV;
import tel.ran.group.cvbank.model.entity.JobSeeker;
import tel.ran.group.cvbank.model.entity.User;
import tel.ran.group.cvbank.model.entity.UserSession;
import tel.ran.group.cvbank.model.web.CvWeb;
import tel.ran.group.cvbank.model.web.JobSeekerWeb;
import tel.ran.group.cvbank.model.web.Request.JobSeekerRegistrationRequest;
import tel.ran.group.cvbank.model.web.Request.LoginRequest;
import tel.ran.group.cvbank.model.web.Responce.JobSeekerResponce;
import tel.ran.group.cvbank.repository.CVRepository;
import tel.ran.group.cvbank.repository.JobSeekerRepository;
import tel.ran.group.cvbank.repository.UserRepository;
import tel.ran.group.cvbank.repository.UserSessionRepository;

import javax.validation.Valid;
import java.security.Principal;
import java.util.*;

@RestController
@RequestMapping("/jobSeeker")
public class JobSeekerController {
    @Autowired
    CVRepository cvRepository;
    @Autowired
    JobSeekerRepository jobSeekerRepository;
    @Autowired
    UserRepository userRepository;

    @Autowired
    private UserSessionRepository userSessionRepository;

    @PostMapping("/registration")
    @SneakyThrows
    public JobSeekerResponce create(@RequestBody @Valid JobSeekerRegistrationRequest jobSeekerRequest,BindingResult result) {
        if (result.hasErrors()) {
            throw new InputValidationException(result);
        }
        userRepository.insert(
                User.builder().
               login(jobSeekerRequest.getLogin()).
                        password(jobSeekerRequest.getPassword()).
                        email(jobSeekerRequest.getEmail()).
                        phone(jobSeekerRequest.getPhone()).
                        roles( Arrays.asList("USER")).
                        build());

        jobSeekerRepository.insert(JobSeeker.builder().
                login(jobSeekerRequest.getLogin()).
                firstName(jobSeekerRequest.getFirstName()).
                lastName(jobSeekerRequest.getLastName()).build());

        userSessionRepository.create(
                UUID.randomUUID().toString(),
                userRepository.findUserByLogin(jobSeekerRequest.getLogin()));

        return getJobSeekerResponceByLogin(jobSeekerRequest.getLogin());
    }

    @PostMapping("/login")
    public JobSeekerResponce login(@RequestBody @Valid LoginRequest jobSeeker,BindingResult result) {
        if (result.hasErrors()) {
            throw new InputValidationException(result);
        }
        User user = userRepository.findUserByLoginAndAndPassword(jobSeeker.getLogin(), jobSeeker.getPassword());

        if (user == null) {
            throw new UsernameNotFoundException("Login is incorrect");
        }
      userSessionRepository.create(UUID.randomUUID().toString(),user);

        return getJobSeekerResponceByLogin(jobSeeker.getLogin());
    }

    @PutMapping("/logout")
    public void logout(@RequestHeader("Authorization")
                                   String sessionId) {
        userSessionRepository.invalidateSession(sessionId);
    }
    @GetMapping("/profile")
    public Set<CvWeb> getProfile(Principal currentUser) {
        JobSeeker jobSeeker=jobSeekerRepository.findAllByLogin(currentUser.getName());
        Set<CV> cvSet=cvRepository.findByJobSeeker(jobSeeker);
         return getSetCvWebResponce(cvSet);

    }


    Set<CvWeb> getSetCvWebResponce(Set<CV> cvSet) {
        Set<CvWeb> cvWebSet= new HashSet<>();
        for (CV cv : cvSet) {
            cvWebSet.add(CvWeb.builder().cvId(cv.getCvId()).cvName(cv.getCvName()).viewCount(cv.getViewCount()).
                    firstName(cv.getFirstName()).
                    isFirstnameVisible(cv.getIsFirstnameVisible()).
                    lastName(cv.getLastName()).
                    isLastNameVisible(cv.getIsLastNameVisible()).
                    isTitleVisible(cv.getIsTitleVisible()).
                    totalExperience(cv.getTotalExperience()).
                    isResidenceVisible(cv.getIsResidenceVisible()).
                    birthday(cv.getBirthday()).
                    isBirthdayVisible(cv.getIsBirthdayVisible()).
                    phone(cv.getPhone()).
                    isPhoneVisible(cv.getIsPhoneVisible()).
                    email(cv.getEmail()).
                    isEmailVisible(cv.getIsEmailVisible()).
                    linkedIn(cv.getLinkedIn()).
                    isLinkedInVisible(cv.getIsLinkedInVisible()).
                    isContactInfoVisible(cv.getIsContactInfoVisible()).
                    position(cv.getPosition()).
                    salaryFrom(cv.getSalaryFrom()).
                    salaryTo(cv.getSalaryTo()).
                    isFooterLinkVisible(cv.getIsFooterLinkVisible()).
                    isActive(cv.getIsActive()).
                    cvStyle(cv.getCvStyle()).
                    backEndFrontEndRatio(cv.getBackEndFrontEndRatio()).
                    auditDate(cv.getAuditDate()).
                    auditCDate(cv.getAuditCDate()).
                    skills(cv.getSkills()).
                    residences(cv.getResidences()).
                    languages(cv.getLanguages()).
                    footerLinks(cv.getFooterLinks()).
                    experiences(cv.getExperiences()).
                    educations(cv.getEducations()).
                    projectJobs(cv.getProjectJobs()).
                    certifications(cv.getCertifications()).
                    achivements(cv.getAchivements()).build());
        }
        return cvWebSet;
    }


    public  JobSeekerResponce getJobSeekerResponceByLogin(String login)
    {
        JobSeeker jobSeeker=jobSeekerRepository.findAllByLogin(login);
        Set<CV> CVSet=cvRepository.findByJobSeeker(jobSeeker);
        User user=userRepository.findUserByLogin(login);
        JobSeekerWeb jobSeekerWeb = JobSeekerWeb.builder().cvWebList(getSetCvWebResponce(CVSet)).
                email(user.getEmail()).firstName(jobSeeker.getFirstName()).lastName(jobSeeker.getLastName()).phone(user.getPhone()).build();
        String token=userSessionRepository.getToken(login);
        JobSeekerResponce jobSeekerResponce =JobSeekerResponce.builder().jobSeekerWeb(jobSeekerWeb).token(token).build();
        return jobSeekerResponce;
    }

}