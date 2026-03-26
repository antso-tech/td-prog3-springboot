package hei.school.TD_K1.Validate;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestHeader;

@Component
public class GetStudentValidate {
    public void getStudentHeaderValidate(@RequestHeader String AcceptRequest) throws Exception{
        if (AcceptRequest == null) {
            throw new Exception("Le header n'est va valable");
            
        }
        if(!AcceptRequest.contains("text/plain")){
            throw new Exception("Format non supporté !");
            
        }else if(!AcceptRequest.contains("application/JSON")){
            throw new Exception("Format non supporté !");

        }
    }
    
}
