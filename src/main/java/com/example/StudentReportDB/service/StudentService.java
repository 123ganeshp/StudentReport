package com.example.StudentReportDB.service;

import com.example.StudentReportDB.controller.StudentController;
import com.example.StudentReportDB.entity.Student;
import com.example.StudentReportDB.repository.StudentRepository;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class StudentService {



    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private StudentController studentController;

    public String exportReport(String reportFormat) throws JRException, FileNotFoundException {
        List<Student> studentList = studentRepository.findAll();

        // Load file and Compile

        File file = ResourceUtils.getFile("classpath:Report.jrxml");

        JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());

        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(studentList);

        Map<String, Object> parameters = new HashMap<>();
        parameters.put("studentName", "Ganesh Pawar");
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters ,dataSource);

        if (reportFormat.equalsIgnoreCase("html")) {
            JasperExportManager.exportReportToHtmlFile(jasperPrint,"D:\\Hoonartek\\Hoonartek_POC\\Reporting Tools\\JasperReport\\GeneratedReport\\Report.html");
        }

        if (reportFormat.equalsIgnoreCase("pdf")) {
            JasperExportManager.exportReportToPdfFile(jasperPrint,"D:\\Hoonartek\\Hoonartek_POC\\Reporting Tools\\JasperReport\\GenratedReport\\Report.pdf");
        }




        return "report generated Successfully";
    }
}
