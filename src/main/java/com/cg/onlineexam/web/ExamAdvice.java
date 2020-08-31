package com.cg.onlineexam.web;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.cg.onlineexam.dto.ExamErrorResponse;
import com.cg.onlineexam.exceptions.ExamAddException;
import com.cg.onlineexam.exceptions.ExamAssignException;

@RestControllerAdvice
public class ExamAdvice {
	
	@ExceptionHandler(ExamAssignException.class)
	@ResponseStatus(code = HttpStatus.CONFLICT)
	public ExamErrorResponse handleExamassignException(ExamAssignException ex) {
		return new ExamErrorResponse(HttpStatus.CONFLICT.toString(), ex.getMessage(), LocalDateTime.now().toString());
	}
	
	
	@ExceptionHandler(ExamAddException.class)
	@ResponseStatus(code = HttpStatus.CONFLICT)
	public ExamErrorResponse handleExamAddException(ExamAddException ex1) {
		return new ExamErrorResponse(HttpStatus.CONFLICT.toString(), ex1.getMessage(), LocalDateTime.now().toString());
	}

}
