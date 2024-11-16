package com.flower.practical_02.ServiceImplementation;

import com.flower.practical_02.Model.Student;
import com.flower.practical_02.Repository.StudentRepositoty;
import com.flower.practical_02.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImplementation implements StudentService {
    @Autowired
    private StudentRepositoty studentRepositoty;

    @Override
    public Student saveStudent(Student student){
        return studentRepositoty.save(student);
    }



    @Override
    public List<Student>getAllStudents(){
        return studentRepositoty.findAll();
    }
    @Override
    public Optional<Student>getStudentById(Long id){
        return studentRepositoty.findById(id);
    }
    @Override
    public void deleteStudentById(Long id){
        studentRepositoty.deleteById(id);
    }

    @Override
    public Student updateStudent(Student student, Long id) {
        Student existingStudent = studentRepositoty.findById(id).orElseThrow(() -> new RuntimeException("Student not found"));
        existingStudent.setFirstName(student.getFirstName());
        existingStudent.setLastName(student.getLastName());
        existingStudent.setEmail(student.getEmail());
        existingStudent.setYearOfEnrollment(student.getYearOfEnrollment());
        existingStudent.setDepartment(student.getDepartment());
        return studentRepositoty.save(existingStudent);
    }



}
