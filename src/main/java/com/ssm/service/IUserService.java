package com.ssm.service;

import java.util.List;    
import java.util.Map;

import com.ssm.dto.PageBean;
import com.ssm.dto.User;    
    
public interface IUserService {    
        
    public User getUserById(int userId);    
    
    public void insertUser(User user);    
    
    public void addUser(User user);    
    
    public List<User> getAllUser();  
    
    public List<User> queryUserByBatch(Map<String,Object> params); 
    
    public void updateByPrimaryKey(User user); 
    
    public Integer getUserCount(String name);
    
    public void insertUserByBatch(List<User> list); 
    
    PageBean<User> findByPage(int currentPage);
} 
