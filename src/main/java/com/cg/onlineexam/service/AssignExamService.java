package com.cg.onlineexam.service;

import java.time.LocalDate;

import com.cg.onlineexam.dto.ExamAssignDto;
import com.cg.onlineexam.exceptions.ExamAssignException;

public interface AssignExamService {

	public String assignExamToUser(ExamAssignDto examAssignDto)throws ExamAssignException;
}
