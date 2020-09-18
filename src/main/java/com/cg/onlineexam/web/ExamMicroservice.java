package com.cg.onlineexam.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.cg.onlineexam.dto.AddExamSuccessMessage;
import com.cg.onlineexam.dto.ExamDto;
import com.cg.onlineexam.entity.Exam;
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
	
	@GetMapping("/viewexam")
	public List<Exam> allViewExam(){
		return examService.viewAllExam();
	}
}

