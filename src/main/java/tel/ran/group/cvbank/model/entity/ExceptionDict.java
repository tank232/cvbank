package tel.ran.group.cvbank.model.entity;


import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder

@Document(collection = "exception_dict")
public class ExceptionDict {
    private String exceptionName;
    private String exceptionText;
}
