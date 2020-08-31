package com.cg.onlineexam.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.onlineexam.entity.User;

@Repository
public interface IUserDao extends JpaRepository<User, Integer> {

}
