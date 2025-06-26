package com.example.Student.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.Student.Entity.StudentEntity;

public interface StudentRepository extends JpaRepository<StudentEntity,Long> {

	@Query("select s from StudentEntity s where s.studentId=:studentId AND studentName=:studentName")
	StudentEntity findByStudentIdAndStudentName(@Param("studentId") long studentId, @Param("studentName") String studentName);
	List<StudentEntity> findAll();
	void deleteById(long id);
}
