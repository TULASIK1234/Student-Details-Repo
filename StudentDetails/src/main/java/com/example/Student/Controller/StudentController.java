
package com.example.Student.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Student.DTO.StudentDTO;
import com.example.Student.DTO.StudentRequest;
import com.example.Student.DTO.StudentResponse;
import com.example.Student.Service.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController 
{
@Autowired
StudentService studentService;
	   
@PostMapping("/add")
public StudentResponse saveStudent(@RequestBody StudentRequest studentRequest)
{
	StudentDTO dto = studentService.saveStudent(studentRequest);
		
	StudentResponse response = new StudentResponse();	
	if(dto!=null)
		{	
			response.setStudentId(dto.getStudentId());
			response.setStudentName(dto.getStudentName());
			response.setStudentEmail(dto.getStudentEmail());
			response.setStudentCourse(dto.getStudentCourse());
		
			return response;
		}
	else {
		return null;
	}
}

@GetMapping("/liststudentdetails")
public List<StudentResponse> listOfAllStudentDetails(StudentRequest studentRequest)
{	
	List<StudentDTO> dtoList = studentService.listOfAllStudentDetails(studentRequest);
			
	List<StudentResponse> responseList = new ArrayList<>();

	if (dtoList!=null)
	{
		for (StudentDTO dto : dtoList) {
	    StudentResponse response = new StudentResponse();
	    response.setStudentId(dto.getStudentId());
	    response.setStudentName(dto.getStudentName());
	    response.setStudentEmail(dto.getStudentEmail());

	    responseList.add(response);  // adding each response object to the list
	}
	
	return responseList;
}
	else
	{
		return null;
	}
}

@PutMapping("/updatestudentdetails")
public StudentResponse updateStudentDetails(@RequestBody StudentRequest studentRequest)
{
	StudentDTO dto = studentService.updateStudentDetails(studentRequest);
	
	StudentResponse response = new StudentResponse();
	if (dto!=null)
	{
		response.setStudentId(dto.getStudentId());
		response.setStudentName(dto.getStudentName());
		response.setStudentEmail(dto.getStudentEmail());
		response.setStudentCourse(dto.getStudentCourse());
	
		return response;
	}
else {
	return null;
}
}

@DeleteMapping("/deletestudentdetails")
public StudentResponse deleteAStudentById (@RequestBody StudentRequest studentRequest)
{
	StudentDTO dto = studentService.deleteAStudentById (studentRequest);
	
	StudentResponse response = new StudentResponse();
	if (dto!=null)
	{
		response.setStudentId(dto.getStudentId());
		response.setStudentName(dto.getStudentName());
		response.setStudentEmail(dto.getStudentEmail());
	
		return response;
	}
else {
	return null;
}
}

}