package hei.school.TD_K1.Entity;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class StudentEntity {
    private String references;
    private String firsName;
    private String lastName;
    private int age;
    
}