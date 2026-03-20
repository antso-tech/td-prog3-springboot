package hei.school.TD_K1.Contoller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RequestMapping
@RestController
public class studentsController {
    @GetMapping("/welcome")
    public ResponseEntity<String> welcomeUser(@RequestParam String name) {
        if(name != null){
            return ResponseEntity.status(200).body("Welcome " + name);

        }else{
            return ResponseEntity.status(400).body("Vous devez fournir un nom");
        }
    }
    


    
}
