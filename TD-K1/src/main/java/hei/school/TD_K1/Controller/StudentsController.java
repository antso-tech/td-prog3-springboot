package hei.school.TD_K1.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.UnsupportedMediaTypeStatusException;

import hei.school.TD_K1.Entity.StudentEntity;
import hei.school.TD_K1.Exception.StudentException;
import hei.school.TD_K1.Services.StudentServices;
import hei.school.TD_K1.Validate.GetStudentValidate;
import hei.school.TD_K1.Validate.Validate;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;



@RequestMapping
@RestController
public class StudentsController {
    @Autowired
    private Validate validStudent;

    @Autowired
    private StudentServices studentServices;

    @Autowired 
    private GetStudentValidate getStudentvalidate;

    @GetMapping("/welcome")
    public ResponseEntity<String> welcomeUser(@RequestParam String name) {

        if(name != null && !name.trim().isEmpty()){
            return ResponseEntity.status(HttpStatusCode.valueOf(200)).body("Welcome " + name);

        }else{
            return ResponseEntity.status(HttpStatusCode.valueOf(400)).body("Vous devez fournir un nom");
        }
    }

    @PostMapping("/student")
    public ResponseEntity<?> createNewStudents(@RequestBody List<StudentEntity> student) throws Exception {
        try {
 
            validStudent.validate(student);
            
            String studentList = studentServices.createStudentServices(student);

            return ResponseEntity.status(HttpStatus.CREATED).body(studentList);
        } catch (StudentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @GetMapping("/student")
    public ResponseEntity<?> getAllStudents(@RequestHeader(value = "Accept", required = false) String acceptHeader) {
        try {
            getStudentvalidate.getStudentHeaderValidate(acceptHeader);

            String studentList = studentServices.getAllStudentsServices();

            return ResponseEntity.status(HttpStatusCode.valueOf(200)).body(studentList);
        } catch(UnsupportedMediaTypeStatusException e){
            return ResponseEntity.status(HttpStatusCode.valueOf(501)).body(e.getMessage());
        }
        catch (StudentException e) {

            return ResponseEntity.status(HttpStatusCode.valueOf(400)).body(e.getMessage());
        }catch(Exception e){
            return ResponseEntity.status(HttpStatusCode.valueOf(500)).body(e.getMessage());

        }
    }
    
}

