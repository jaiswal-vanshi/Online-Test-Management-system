package com.cg.onlineexam.dto;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;

public class ExamAssignDto {

	private int examId;
	private int userId;
	@DateTimeFormat(pattern = "yyyy-MM-dd") 
	private LocalDate doe;
	public int getExamId() {
		return examId;
	}
	public void setExamId(int examId) {
		this.examId = examId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public LocalDate getDoe() {
		return doe;
	}
	public void setDoe(LocalDate doe) {
		this.doe = doe;
	}
	
	
}
