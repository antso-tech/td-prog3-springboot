package hei.school.TD_K1.Validate;

import org.springframework.stereotype.Component;

import hei.school.TD_K1.Exception.StudentException;

@Component
public class GetWelcomeValidate {
    public void getWelcomeValidate(String name){
        System.out.println(name);
        
        if(name == null || name.trim().isEmpty()){
            throw new StudentException("Vous devez fournir un nom");

        }
    }    
}
