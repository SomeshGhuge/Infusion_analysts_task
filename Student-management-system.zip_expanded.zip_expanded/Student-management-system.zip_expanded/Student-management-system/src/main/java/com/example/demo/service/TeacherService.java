package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Teacher;

public interface TeacherService {
	public List<Teacher> getAllTeacher();
     public Teacher saveTeacher(Teacher teacher);
     public void deleteTeacher(int id);
     public Teacher getTeacherById(int id);
     public Teacher updateTeacher(Teacher teacher);
}
