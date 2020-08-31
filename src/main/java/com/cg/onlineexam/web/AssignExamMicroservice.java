package com.cg.onlineexam.web;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.onlineexam.dto.ExamAssignDto;
import com.cg.onlineexam.dto.ExamSuccessMessage;
import com.cg.onlineexam.exceptions.ExamAssignException;
import com.cg.onlineexam.service.AssignExamService;
import com.cg.onlineexam.util.ExamConstants;

@RestController
@CrossOrigin(origins="http://localhost:4200")
public class AssignExamMicroservice {

	@Autowired
	private AssignExamService examAssignService;
	
	@PostMapping(ExamConstants.ASSIGN_EXAM_URL)
	public ExamSuccessMessage assignExamtoUser(@RequestBody ExamAssignDto examAssignDto) throws ExamAssignException {
		String msg = examAssignService.assignExamToUser(examAssignDto);
		return new ExamSuccessMessage(msg);
		
	}
}
