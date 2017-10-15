package com.javamb.mb.service;

import java.util.List;

import com.javamb.mb.annotation.TargetDataSource;
import com.javamb.mb.vo.UserVO;

public interface UserService {
    
    /** 
     * @Description 我们在调用这个方法之前就需要对我们的数据源进行动态切换 
     * @param @return 参数 
     * @return List<UserVO> 返回类型  
     * @throws 
     */
//    @TargetDataSource("read")
    @TargetDataSource("write")
    public List<UserVO> findUser();
    
    /** 
     * @Description 我们在调用这个方法之前就需要对我们的数据源进行动态切换 
     * @param @return 参数 
     * @return List<UserVO> 返回类型  
     * @throws 
     */
//    @TargetDataSource("write")
    @TargetDataSource("read")
    public void addUser(UserVO userVO);
}
