package com.cg.onlineexam.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.onlineexam.dao.IExamDao;
import com.cg.onlineexam.dto.ExamDto;
import com.cg.onlineexam.entity.Exam;
import com.cg.onlineexam.exceptions.ExamAddException;
import com.cg.onlineexam.util.ExamConstants;
@Service
public class ExamServiceImpl implements ExamService{
	
	@Autowired
	private IExamDao examDao;

	//Add Exam
	@Override
	@Transactional
	public String addExam(ExamDto examDto)throws ExamAddException {
		Optional<Exam> optexam = examDao.findById(examDto.getExamId());
		if(optexam.isPresent())
			throw new ExamAddException(ExamConstants.EXAM_ALREADY_EXIST);
		Exam exam=new Exam();
		exam.setExamId(examDto.getExamId());
		exam.setExamName(examDto.getExamName());
		exam.setMinutes(examDto.getMinutes());
		examDao.save(exam);
		return ExamConstants.ADD_EXAM;
	}

	//View All Exams
	@Override
	public List<Exam> viewAllExam() {
		return examDao.findAll();
	}

	
	

}
