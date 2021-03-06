package tel.ran.group.cvbank.model.web;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ErrorResponse {
    private Map<String, List<String>> errors;
}
