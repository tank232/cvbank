package tel.ran.group.cvbank.model.entity;


import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder

@Document(collection = "company")
public class Company {
    private String Login;
    private String companyName;
    private String webSite;
    private String country;
    private String cityTown;
    private String street;
    private String houseBuilding;
    private String aplicantFirstName;
    private String aplicantLastName;
    private String aplicantPosition;
    private String aplicantEmail;
    private String aplicantPhone;
    private Date auditDate;
    private Date auditCDate;
}
