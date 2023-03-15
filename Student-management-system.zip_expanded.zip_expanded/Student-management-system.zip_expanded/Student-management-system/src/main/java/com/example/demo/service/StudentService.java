package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Student;

public interface StudentService {
    List<Student> getAllStudent();
    
    Student saveStudent(Student student);
    
    Student getStudentById(int id);
    
    Student updateStudent(Student student);
	 
    void deleteStuentById(int id);
    
    Student getBySeatNo(int seatNo); 
 
}
