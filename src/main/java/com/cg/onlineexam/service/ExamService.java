package com.cg.onlineexam.service;

import java.util.List;

import com.cg.onlineexam.dto.ExamDto;
import com.cg.onlineexam.entity.Exam;
import com.cg.onlineexam.entity.ExamUserAssign;
import com.cg.onlineexam.exceptions.ExamAddException;

public interface ExamService {
	public String addExam(ExamDto examdto)throws ExamAddException;
	public  List<Exam> viewAllExam();

}
