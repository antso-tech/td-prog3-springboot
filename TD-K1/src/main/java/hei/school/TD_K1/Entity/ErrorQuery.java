package hei.school.TD_K1.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class ErrorQuery {
    private final String message;
    private final int status;
    
}
