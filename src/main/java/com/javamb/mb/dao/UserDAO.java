package com.javamb.mb.dao;

import java.util.List;

import com.javamb.mb.vo.UserVO;

public interface UserDAO {
    
    public List<UserVO> findUsers();
    
    public Integer addUser(UserVO userVO);
}
