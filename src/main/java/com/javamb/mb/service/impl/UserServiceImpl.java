package com.javamb.mb.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.javamb.mb.dao.UserDAO;
import com.javamb.mb.service.UserService;
import com.javamb.mb.vo.UserVO;

@Service
public class UserServiceImpl implements UserService {
    
    @Autowired
    private UserDAO userDAO;
    
    public List<UserVO> findUser() {
        List<UserVO> list = userDAO.findUsers();
        System.out.println(list.size());
        return list;
    }
    
    @Transactional
    public void addUser(UserVO userVO) {
        userDAO.addUser(userVO);
        System.out.println("insert success");
    }
    
}
