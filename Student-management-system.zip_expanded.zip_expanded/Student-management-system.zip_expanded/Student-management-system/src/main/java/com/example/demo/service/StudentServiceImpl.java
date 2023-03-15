package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Student;
import com.example.demo.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {
 @Autowired
 public StudentRepository studentRepo;

	@Override
	public List<Student> getAllStudent() {
		
		return studentRepo.findAll();
	}

	@Override
	public Student saveStudent(Student student) {
		
		return studentRepo.save(student);
	}

	@Override
	public Student getStudentById(int id) {
		
		return studentRepo.findById(id).get();
	}

	@Override
	public Student updateStudent(Student student) {
		
		return studentRepo.save(student);
	}

	@Override
	public void deleteStuentById(int id) {
		studentRepo.deleteById(id);
		
	}
	public Student student(int seatNo,String dob) {
		Student student=studentRepo.findBySeatNoAndDob(seatNo, dob);
		return student;
	}

	@Override
	public Student getBySeatNo(int seatNo) {
		Student student=studentRepo.getBySeatNo(seatNo);
		return student;
	}

}
