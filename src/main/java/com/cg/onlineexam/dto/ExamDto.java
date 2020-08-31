package com.cg.onlineexam.dto;

public class ExamDto {
	
	private int examId;
	private String examName;
	private int minutes;

	public ExamDto() {
	}

	public ExamDto(int examId, String examName, int minutes) {
		super();
		this.examId = examId;
		this.examName = examName;
		this.minutes = minutes;
	}
	
	public int getExamId() {
		return examId;
	}
	public void setExamId(int examId) {
		this.examId = examId;
	}
	public String getExamName() {
		return examName;
	}
	public void setExamName(String examName) {
		this.examName = examName;
	}
	public int getMinutes() {
		return minutes;
	}
	public void setMinutes(int minutes) {
		this.minutes = minutes;
	}
	
	
	
	
}
