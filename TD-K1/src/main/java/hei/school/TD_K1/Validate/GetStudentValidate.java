package hei.school.TD_K1.Validate;

import org.springframework.stereotype.Component;

import hei.school.TD_K1.Exception.StudentException;

@Component
public class GetStudentValidate {
    public void getStudentHeaderValidate(String acceptRequest){
   
       
        if (acceptRequest == null || acceptRequest.trim().isEmpty() || acceptRequest.contains("*/*")) {
            throw new StudentException("Le header Accept doit être requis");
            
        }else{
            boolean jsonVerified = acceptRequest.contains("text/plain") || acceptRequest.contains("application/json" ) ;

            if (!jsonVerified) {
            throw new StudentException("Format non supporté");
            
        }
        }


    }



}
