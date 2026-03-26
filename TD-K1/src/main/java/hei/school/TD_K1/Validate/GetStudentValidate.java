package hei.school.TD_K1.Validate;

import org.springframework.stereotype.Component;

import hei.school.TD_K1.Exception.StudentException;
import hei.school.TD_K1.Exception.UnsupportedMediaTypeException;

@Component
public class GetStudentValidate {
    public void getStudentHeaderValidate(String AcceptRequest){
        if (AcceptRequest == null || AcceptRequest.isBlank()) {
            throw new StudentException("Le header Accept doit être requis");
            
        }

        boolean jsonVerified = AcceptRequest.contains("text/plain") || AcceptRequest.contains("application/json");

        if (!jsonVerified) {
            throw new UnsupportedMediaTypeException("Format non supporté");
            
        }
    }



}
