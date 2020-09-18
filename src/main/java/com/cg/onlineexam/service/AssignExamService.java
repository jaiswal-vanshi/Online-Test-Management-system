package com.cg.onlineexam.service;

import java.time.LocalDate;
import java.util.List;

import com.cg.onlineexam.dto.ExamAssignDto;
import com.cg.onlineexam.entity.ExamUserAssign;
import com.cg.onlineexam.exceptions.ExamAssignException;

public interface AssignExamService {

	public String assignExamToUser(ExamAssignDto examAssignDto)throws ExamAssignException;
	public String assignExamToUser(List<ExamAssignDto> assignList)throws ExamAssignException;
	public  List<ExamUserAssign> viewAllAssignExam();
}
