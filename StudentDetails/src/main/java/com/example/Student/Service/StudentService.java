package com.example.Student.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Student.DTO.StudentDTO;
import com.example.Student.DTO.StudentRequest;
import com.example.Student.Entity.StudentEntity;
import com.example.Student.Repo.StudentRepository;

@Service
public class StudentService {

@Autowired
StudentRepository studentRepository;

public StudentDTO saveStudent(StudentRequest studentRequest)
{
StudentEntity studentEntity = studentRepository.findByStudentIdAndStudentName(studentRequest.getStudentId(),studentRequest.getStudentName());
if (studentEntity == null) {
StudentEntity entity = new StudentEntity();

entity.setStudentId(studentRequest.getStudentId());
entity.setStudentName(studentRequest.getStudentName());
entity.setStudentEmail(studentRequest.getStudentEmail());
entity.setStudentCourse(studentRequest.getStudentCourse());

studentRepository.save(entity);

StudentDTO dto = new StudentDTO();
dto.setStudentId(entity.getStudentId());
dto.setStudentName(entity.getStudentName());
dto.setStudentEmail(entity.getStudentEmail());
dto.setStudentCourse(entity.getStudentCourse());

return dto;
}
return null;
}

public List<StudentDTO> listOfAllStudentDetails(StudentRequest studentRequest)
{
	List<StudentEntity> studentEntity = studentRepository.findAll();
	
	List<StudentDTO> dtoList = new ArrayList<>();
	
	
	if (studentEntity!=null)
	{
		for (StudentEntity entity : studentEntity) {
			StudentDTO dto = new StudentDTO();
		dto.setStudentId(entity.getStudentId());
		dto.setStudentName(entity.getStudentName());
		dto.setStudentEmail(entity.getStudentEmail());
		
		 dtoList.add(dto);
		}
		
		return dtoList ;
		} 
	return null;
	}


	
public StudentDTO updateStudentDetails(StudentRequest studentRequest)
{
	StudentEntity entity = studentRepository.findByStudentIdAndStudentName(studentRequest.getStudentId(),studentRequest.getStudentName());
	
	StudentDTO dto = new StudentDTO();

	if (entity != null) {
		if (studentRequest.getStudentName() != null) {
			dto.setStudentName(entity.getStudentName());
		}
		if (studentRequest.getStudentEmail() != null) {
			dto.setStudentEmail(entity.getStudentEmail());
		}
		if (studentRequest.getStudentCourse() != null) {
			dto.setStudentCourse(entity.getStudentCourse());
		}

		return dto;
	}

	return null;
}

public StudentDTO deleteAStudentById (StudentRequest studentRequest)
{
	StudentEntity entity = studentRepository.findByStudentIdAndStudentName(studentRequest.getStudentId(),studentRequest.getStudentName());
	
	StudentDTO dto = new StudentDTO();
	
	if (entity != null) {
		if (studentRequest.getStudentName() != null) {
			entity.setStudentName(studentRequest.getStudentName());
		}
		if (studentRequest.getStudentEmail() != null) {
			entity.setStudentEmail(studentRequest.getStudentEmail());
		}
		
		studentRepository.delete(entity);
		return dto;
	}
	else {
	return null;
}
}
}