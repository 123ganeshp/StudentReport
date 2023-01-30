package com.example.StudentReportDB.controller;

import com.example.StudentReportDB.entity.Student;
import com.example.StudentReportDB.repository.StudentRepository;
import com.example.StudentReportDB.service.StudentService;
import net.sf.jasperreports.engine.JRException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileNotFoundException;
import java.util.List;

//@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private StudentService studentService;


    @GetMapping("/getStudent")
    public List<Student> getStudentDetails( ) {
        return studentRepository.findAll();
    }

    @GetMapping("/report/{format}")
    public String genrateReport (@PathVariable String format) throws FileNotFoundException, JRException {
        return studentService.exportReport(format);
    }


}
