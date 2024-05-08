
package com.springboot.StudentManagementSystem.controller;

        import com.springboot.StudentManagementSystem.model.Student;
        import com.springboot.StudentManagementSystem.service.StudentService;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.web.bind.annotation.*;

        import java.util.List;

@RestController
@RequestMapping("/student")
@CrossOrigin
public class StudentController {
    @Autowired
    private StudentService studentService;

    @PostMapping("/addStudent")
    public String add(@RequestBody Student student){
        studentService.saveStudent(student);
        return "New student is added";
    }
    @GetMapping("/students")
    public List<Student> findAllStudents() {
        return studentService.getAllStudents();
    }

    @PostMapping("/addStudents")
    public List<Student> addProducts(@RequestBody List<Student> students) {
        return studentService.saveStudents(students);
    }

    @GetMapping("/studentById/{id}")
    public Student findProductById(@PathVariable int id) {
        return studentService.getStudentById(id);
    }

    @GetMapping("/student/{name}")
    public Student findStudentByName(@PathVariable String name) {
        return studentService.getStudentByName(name);
    }

    @PutMapping("/update/{id}")
    public Student updateStudent(@RequestBody Student student) {
        return studentService.updateStudent(student);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteStudent(@PathVariable int id) {
        return studentService.deleteStudent(id);
    }

}
