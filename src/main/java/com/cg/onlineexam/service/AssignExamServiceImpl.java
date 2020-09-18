package com.cg.onlineexam.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.onlineexam.dao.IExamAssignDao;
import com.cg.onlineexam.dao.IExamAssignDtoDao;
import com.cg.onlineexam.dao.IExamDao;
import com.cg.onlineexam.dao.IUserDao;
import com.cg.onlineexam.dto.ExamAssignDto;
import com.cg.onlineexam.entity.Exam;
import com.cg.onlineexam.entity.ExamUserAssign;
import com.cg.onlineexam.entity.User;
import com.cg.onlineexam.exceptions.ExamAssignException;
import com.cg.onlineexam.util.ExamConstants;
@Service
public class AssignExamServiceImpl implements AssignExamService{
    Logger logger = LoggerFactory.getLogger(AssignExamServiceImpl.class);
	@Autowired
	private IExamAssignDao assignExamDao;
	
	@Autowired
	private IExamAssignDtoDao assignExamDtoDao;
	
	@Autowired
	private IExamDao examDao;
	
	@Autowired
	private IUserDao userDao;
	
	//Assign Exam to User
	@Override
	@Transactional
	public String assignExamToUser(ExamAssignDto examAssignDto) throws ExamAssignException {
		Optional<Exam> optexam = examDao.findById(examAssignDto.getExamId());
		if(!optexam.isPresent())
			throw new ExamAssignException(ExamConstants.EXAM_NOT_AVAILABLE);
		Optional<User> optuser = userDao.findById(examAssignDto.getUserId());
		if(!optuser.isPresent())
			throw new ExamAssignException(ExamConstants.USER_NOT_AVAILABLE);
		ExamUserAssign examUser = new ExamUserAssign();
		int id = generateExamUserId(examAssignDto.getExamId(), examAssignDto.getUserId(), examAssignDto.getDoe());
		examUser.setExamUserAssignId(id);
		examUser.setDateOfExam(examAssignDto.getDoe());
		examUser.setExam(optexam.get());
		examUser.setUser(optuser.get());
		examUser.setStatus(ExamConstants.ACTIVE);
		assignExamDao.save(examUser);
		return ExamConstants.ASSIGNED_EXAM_TO_USER;
	}
    
	//Generate Exam User Id
	public int generateExamUserId(int examId, int userId, LocalDate doe) {
		String strId = examId + ""+ userId+""+ (assignExamDao.getCountOfUserByExam(userId, examId) +  ExamConstants.ONE);
		return Integer.parseInt(strId);
	}

	@Override
	public String assignExamToUser(List<ExamAssignDto> assignList) throws ExamAssignException {
		assignList.forEach(ea->{
			try {
				assignExamToUser(ea);
			} catch (ExamAssignException e) {
			    logger.error(e.getMessage());
			}
		});
		return ExamConstants.ASSIGNED_EXAM_TO_USER;
	}
    
	
	//View all Assigned Exams
	@Override
	public List<ExamUserAssign> viewAllAssignExam() {
		return assignExamDtoDao.findAll();
	}
}










