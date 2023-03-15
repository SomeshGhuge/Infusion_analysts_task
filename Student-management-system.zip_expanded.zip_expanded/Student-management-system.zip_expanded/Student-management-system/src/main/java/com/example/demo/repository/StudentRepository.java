package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Student;
@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
 Student findBySeatNoAndDob(int seatNo,String dob);
 
 @Query(value="select * from student where seatNo=?1",nativeQuery = true)
  Student getBySeatNo(int seatNo);
}

