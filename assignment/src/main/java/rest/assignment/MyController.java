package rest.assignment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List; 


@Controller
public class MyController {
    @Autowired
    private StudentRepository studentRepository;
    private StructureApiService structureApiService;

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/add")
    public String addStudentForm(Model model) {
        model.addAttribute("student", new Student());
        return "add";
    }

    @PostMapping("/save")
    public String saveStudent(@ModelAttribute Student student) {
            studentRepository.save(student);
        return "index";
    }

    @GetMapping("/view")
    public String getDetails(Model model){
        model.addAttribute("students",structureApiService.getAllDetails());
        return "view";
    }

    @GetMapping("/edit")
    public String edit()
    {
        return "edit";
    }

    @PostMapping("/edit")
    public String editStudent(@ModelAttribute Student student) {
            studentRepository.save(student);
        return "index";
    }

    @GetMapping("/delete")
    public String delete(Model model){
        Student student = new Student();
        model.addAttribute("student",student);
        return "delete";
    }
    @PostMapping("/delete")
    public String deleteDetails(@ModelAttribute("student")Student student){
        structureApiService.deleteStructureDetails(student.getid());
        return "index";
    }

    @ExceptionHandler(Exception.class)
    public String handleError(Model model, Exception e) {
        model.addAttribute("error", e.getMessage());
        return "error";
    }

}