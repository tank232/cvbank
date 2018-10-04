package tel.ran.group.cvbank.model.entity;


import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.Id;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder

@Document(collection = "residence_dict")
public class ResidenceDict {
    private String  ResidenceName;
}
