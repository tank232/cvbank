package tel.ran.group.cvbank.model.entity;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.Date;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder

@Document(collection = "cv")
public class CV {
    @DBRef
    JobSeeker jobSeeker;
    @JsonProperty("_id")
    private Integer cvId;
    private String cvName;
    private Integer viewCount;
    private String firstName;
    private Boolean isFirstnameVisible;
    private String lastName;
    private Boolean isLastNameVisible;
    private Boolean isTitleVisible;
    private Integer totalExperience;
    private Boolean isResidenceVisible;
    private Date birthday;
    private Boolean isBirthdayVisible;
    private String phone;
    private Boolean isPhoneVisible;
    private String email;
    private Boolean isEmailVisible;
    private String linkedIn;
    private Boolean isLinkedInVisible;
    private Boolean isContactInfoVisible;
    private String position;
    private Integer salaryFrom;
    private Integer salaryTo;
    private Boolean isFooterLinkVisible;
    private Boolean isActive;
    private String cvStyle;
    private Integer backEndFrontEndRatio;
    private Date auditDate;
    private Date auditCDate;
    private Set<String> skills;
    private Set<String> residences;
    private Set<String> languages;
    private Set<String> footerLinks;
    private Set<Experience> experiences;
    private Set<Education> educations;
    private Set<ProjectJob> projectJobs;
    private Set<String> certifications;
    private Set<String> achivements;
}
