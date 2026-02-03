package com.example.class_management.controller;


import java.util.List;
import org.springframework.web.bind.annotation.PathVariable;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.class_management.entity.Student;
import com.example.class_management.repository.StudentRepository;


//@Controller
//public class StudentController {
//	
//	@Autowired
//	private StudentRepository studrepo;
//	
//	@GetMapping("/record")
//	public String studentRecords(Model model) {
//		List<Student> students = studrepo.findAll();
//		model.addAttribute("students", students);
//		return "records";
//}
////	public List<Student> studentRecords(){
////		return studrepo.findAll();
////		
////	}
//	
//	@GetMapping("/add-student")
//    public String addStudentForm() {
//        return "student-form";
//    }
//
//    @PostMapping("/save-student")
//    public String saveStudent(Student student) {
//        studrepo.save(student);
//        return "redirect:/record";
//    }
//
////    @GetMapping("/delete-student")
////    	public String deleteStudent(int studentId ) {
////    studrepo.deleteById(studentId);
////    return "redirect:/record";
////    		
////    	
////    }
//    @GetMapping("/delete-student/{studentId}")
//    public String deleteStudent(@PathVariable int studentId) {
//        studrepo.deleteById(studentId);
//        return "redirect:/record";
//    }
//
//    
////    @GetMapping("/edit-student")
////    public String editStudent(@RequestParam int studentId, Model model) {
////        Student student = studrepo.findById(studentId).get();
////        model.addAttribute("student", student);
////        return "student-form";
////    }
//    @GetMapping("/edit-student/{studentId}")
//    public String editStudent(@PathVariable("studentId") int studentId, Model model) {
//
//        Student student = studrepo.findById(studentId).orElse(null);
//
//        if (student == null) {
//            return "redirect:/record";
//        }
//
//
//        model.addAttribute("student", student);
//        return "edit-student";   // edit-student.html
//    }
//
//
//}
@Controller
public class StudentController {

    @Autowired
    private StudentRepository studrepo;

    @GetMapping("/record")
    public String studentRecords(Model model) {
        List<Student> students = studrepo.findAll();
        model.addAttribute("students", students);
        return "records";
    }

    @GetMapping("/add-student")
    public String addStudentForm() {
        return "student-form";
    }

    @PostMapping("/save-student")
    public String saveStudent(Student student) {
        studrepo.save(student);
        return "redirect:/record";
    }

    @GetMapping("/edit-student/{studentId}")
    public String editStudent(@PathVariable int studentId, Model model) {

        Student student = studrepo.findById(studentId).orElse(null);

        if (student == null) {
            return "redirect:/record";
        }

        model.addAttribute("student", student);
        return "edit-student";
    }

    @GetMapping("/delete-student/{studentId}")
    public String deleteStudent(@PathVariable int studentId) {
        studrepo.deleteById(studentId);
        return "redirect:/record";
    }
    @PostMapping("/update-student")
    public String updateStudent(Student student) {

        studrepo.save(student);   // save() updates if ID exists
        return "redirect:/record";
    }

}

