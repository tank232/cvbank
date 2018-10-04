package tel.ran.group.cvbank.model.entity;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder

@Document(collection = "job_seeker")
public class JobSeeker  {
    @Id
    private String login;
    private String firstName;
    private String lastName;
    @DateTimeFormat(style = "M-")
    @CreatedDate
    private Date auditDate;
    @DateTimeFormat(style = "M-")
    @LastModifiedBy
    private Date auditCDate;
}
