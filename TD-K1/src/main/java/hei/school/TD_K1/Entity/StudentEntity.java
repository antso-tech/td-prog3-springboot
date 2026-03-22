package hei.school.TD_K1.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class StudentEntity {
    private String reference;
    private String firstName;
    private String lastName;
    private int age;
    
}