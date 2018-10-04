package tel.ran.group.cvbank.model.web;

import lombok.Builder;
import lombok.Getter;

import java.util.Set;

@Builder
@Getter
public class JobSeekerWeb {
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private Set<CvWeb> cvWebList;
}
