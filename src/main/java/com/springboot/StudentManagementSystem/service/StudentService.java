
package com.springboot.StudentManagementSystem.service;

        import com.springboot.StudentManagementSystem.model.Student;
        import com.springboot.StudentManagementSystem.model.User;
        import com.springboot.StudentManagementSystem.repository.StudentRepository;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.stereotype.Service;

        import java.util.List;
        import java.util.Optional;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    public List<Student> saveStudents(List<Student> students) {
        return studentRepository.saveAll(students);
    }
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public List<Student> getStudents() {
        return studentRepository.findAll();
    }

    public Student getStudentById(int id) {
        return studentRepository.findById(id).orElse(null);
    }

    public Student getStudentByName(String name) {
        return studentRepository.findByName(name);
    }

    public String deleteStudent(int id) {
        studentRepository.deleteById(id);
        return "student removed !! " + id;
    }



//    public Student updateStudent(Student student) {
//        // Find the existing student record by ID
//        Optional<Student> optionalExistingStudent = studentRepository.findById(student.getId());
//
//        // Check if the student record exists
//        if (optionalExistingStudent.isPresent()) {
//            // Retrieve the existing student object
//            Student existingStudent = optionalExistingStudent.get();
//
//            // Update the student's properties
//            existingStudent.setName(student.getName());
//            existingStudent.setStudentClass(student.getStudentClass());
//            // Update other properties as needed
//
//            // Save the updated student record
//            return studentRepository.save(existingStudent);
//        } else {
//            // Handle the case where no student record with the provided ID was found
//            throw new RuntimeException("Student not found with ID: " + student.getId());
//        }
//    }

    public Student updateStudent(Student student) {
        // Find the existing student record by ID
        Student existingStudent = studentRepository.findById(student.getId()).orElse(null);
        existingStudent.setName(student.getName());
        existingStudent.setStudentClass(student.getStudentClass());


        return studentRepository.save(existingStudent);
    }

}
