package rest.assignment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Service
@RestController
@RequestMapping("/student")
public class StructureApiService {
    @Autowired
    private StudentRepository studentRepository;
    HashMap<String,Student> map = new HashMap<>();


    @GetMapping("/{id}") //expected value
    public ResponseEntity<Optional<Student>> getStructureDetails(@PathVariable String id){

        return ResponseEntity.ok(studentRepository.findById(id));
    }
    @GetMapping
    public List<Student> getAllDetails(){
        return (studentRepository.findAll());
    }
    @PostMapping
    public ResponseEntity<Student> createStructureDetails(@RequestBody Student s){
        map.put(s.getid(),s);
        Student save = this.studentRepository.save(s);
        return ResponseEntity.ok(save);
    }
    @PutMapping
    public ResponseEntity<Student> updateStructureDetails(@RequestBody Student s){
        if (map.containsKey(s.getid())){
        Student k=map.get(s.getid());
        studentRepository.deleteById(s.getid());
                Student save = this.studentRepository.save(k);
        return ResponseEntity.ok(save);}

            return createStructureDetails(s);
        }
        
        @DeleteMapping("/delete/{id}")
    public String deleteStructureDetails(@PathVariable String id){
        map.remove(id);
        studentRepository.deleteById(id);
        return "Deleted";
    }
    }



