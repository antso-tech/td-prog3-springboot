package hei.school.TD_K1.Validate;


import java.util.List;

import org.springframework.stereotype.Component;

import hei.school.TD_K1.Entity.StudentEntity;
import hei.school.TD_K1.Exception.StudentException;

@Component
public class Validate {
    public void validate(List<StudentEntity> student) throws Exception{
    
        for (StudentEntity std : student) {
            if(std == null){
                throw new StudentException("Student cannot be null");
            }
            if(std.getFirstName() == null || std.getFirstName().isBlank()){
                throw new StudentException("Données incompletes ");
            }else if(std.getLastName() == null || std.getLastName().isBlank()){
                throw new StudentException("Données incompletes");
            }else if(std.getReference() == null || std.getReference().isBlank()){
                throw new StudentException("Données incompletes");
                
            }
            
        }

    }
    
}
