package com.cg.onlineexam.web;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.cg.onlineexam.dto.ExamAssignDto;
import com.cg.onlineexam.dto.ExamDto;
import com.cg.onlineexam.dto.ExamSuccessMessage;
import com.cg.onlineexam.entity.Exam;
import com.cg.onlineexam.entity.ExamUserAssign;
import com.cg.onlineexam.exceptions.ExamAssignException;
import com.cg.onlineexam.service.AssignExamService;
import com.cg.onlineexam.service.ExamService;
import com.cg.onlineexam.util.ExamConstants;

@RestController
@CrossOrigin(value="http://localhost:4200")
public class AssignExamMicroservice {

	@Autowired
	private AssignExamService examAssignService;
	@GetMapping("/viewassign")
	public List<ExamUserAssign> allViewAssignExam(){
		return examAssignService.viewAllAssignExam();
	}
	
	@PostMapping(ExamConstants.ASSIGN_EXAM_URL)
	public ExamSuccessMessage assignExamtoUser(@RequestBody ExamAssignDto examAssignDto) throws ExamAssignException {
		String msg = examAssignService.assignExamToUser(examAssignDto);
		return new ExamSuccessMessage(msg);
		
	}
	
	@PostMapping("/upload")
	public String mapReadExcelDatatoDB(@RequestParam("efile") MultipartFile readExcelDataFile) throws IOException, ExamAssignException {
		DateTimeFormatter df=DateTimeFormatter.ofPattern("yyyy-M-d");
	   List<ExamAssignDto> elist = new ArrayList<ExamAssignDto>();
	XSSFWorkbook workbook = new XSSFWorkbook(readExcelDataFile.getInputStream());
	XSSFSheet worksheet = workbook.getSheetAt(0);
        ExamAssignDto exam = null;
	for(int i=1;i<worksheet.getPhysicalNumberOfRows() ;i++) {
		exam = new ExamAssignDto();
		XSSFRow row = worksheet.getRow(i);
	exam.setExamId((int)row.getCell(0).getNumericCellValue());
	exam.setUserId((int)row.getCell(1).getNumericCellValue());
	LocalDate ldt=LocalDate.parse(row.getCell(2).getStringCellValue(),df);
	exam.setDoe(ldt);
	elist.add(exam);
	
	    }
	
	examAssignService.assignExamToUser(elist);
	return"File Uploaded Successfully";
	}
}
