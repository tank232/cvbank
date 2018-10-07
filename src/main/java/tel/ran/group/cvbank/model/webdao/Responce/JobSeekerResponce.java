package tel.ran.group.cvbank.model.web.Responce;

import lombok.Builder;
import lombok.Getter;
import tel.ran.group.cvbank.model.web.JobSeekerWeb;


@Getter
@Builder
public class JobSeekerResponce  {
    private String  token;
    JobSeekerWeb jobSeekerWeb;
}
