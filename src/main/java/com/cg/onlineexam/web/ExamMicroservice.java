package com.cg.onlineexam.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.onlineexam.dto.AddExamSuccessMessage;
import com.cg.onlineexam.dto.ExamDto;
import com.cg.onlineexam.exceptions.ExamAddException;
import com.cg.onlineexam.service.ExamService;
import com.cg.onlineexam.util.ExamConstants;

@RestController
@CrossOrigin(origins="http://localhost:4200")
public class ExamMicroservice {
	
	@Autowired
	private ExamService examService ;
	
	@PostMapping(ExamConstants.ADD_EXAM_URL)
	public AddExamSuccessMessage addExam (@RequestBody ExamDto examDto)throws ExamAddException{
		String msg=examService.addExam(examDto);
		return new AddExamSuccessMessage(msg);
	}

}
