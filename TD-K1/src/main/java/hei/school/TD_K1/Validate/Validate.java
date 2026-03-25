package hei.school.TD_K1.Validate;

import java.util.List;

import hei.school.TD_K1.Entity.StudentEntity;

public class Validate {
    public void validate(List<StudentEntity> student) throws Exception{
        for (StudentEntity std : student) {
            if(std == null || std.getFirstName().isBlank()){
                throw new Exception("Données incompletes ");
            }else if(std == null || std.getLastName().isBlank()){
                throw new Exception("Données incompletes");
            }else{
                throw new Exception("Données incompletes");
                
            }
            
        }

    }
    
}
