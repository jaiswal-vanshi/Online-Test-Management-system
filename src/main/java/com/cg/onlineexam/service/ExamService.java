package com.cg.onlineexam.service;

import com.cg.onlineexam.dto.ExamDto;
import com.cg.onlineexam.exceptions.ExamAddException;

public interface ExamService {
	public String addExam(ExamDto examdto)throws ExamAddException;

}
