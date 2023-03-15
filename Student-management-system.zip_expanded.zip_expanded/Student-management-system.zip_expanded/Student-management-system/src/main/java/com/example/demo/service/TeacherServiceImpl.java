package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Teacher;
import com.example.demo.repository.TeacherRepository;

@Service
public class TeacherServiceImpl implements TeacherService {

	@Autowired
	public TeacherRepository teacherRepo;
	
	
	@Override
	public List<Teacher> getAllTeacher() {
		
		return teacherRepo.findAll();
	}
	@Override
	public Teacher saveTeacher(Teacher teacher) {
		
		return teacherRepo.save(teacher);
	}

	@Override
	public void deleteTeacher(int id) {
		teacherRepo.deleteById(id);
		
	}


	@Override
	public Teacher getTeacherById(int id) {
		
		return teacherRepo.findById(id).get();
	}

	@Override
	public Teacher updateTeacher(Teacher teacher) {
		
		return teacherRepo.save(teacher);
	}

	

}
