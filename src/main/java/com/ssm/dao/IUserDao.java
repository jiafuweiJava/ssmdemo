package com.ssm.dao;

import java.util.HashMap;
import java.util.List;    
import java.util.Map;    
    
import com.ssm.dto.User;    
    
public interface IUserDao {    
    /**
     * 根据id查询user    
     * @param id
     * @return
     */
    public User queryByPrimaryKey(Integer id);    
    /**
     * 批量查询user    
     * @param params
     * @return
     */
    public List<User> queryUserByBatch(Map<String,Object> params);    
    /**
     * 保存user   
     * @param user
     */
    public void insertUser(User user);    
    /**
     * 批量插入user    
     * @param list
     */
    public void insertUserByBatch(List<User> list);    
    /**
     * 根据id删除user    
     * @param id
     */
    public void deleteByPrimaryKey(Integer id);    
    /**
     * 批量删除user    
     * @param params
     */
    public void delteUserByBatch(Map<String,Object> params);    
    /**
     * 根据user修改更新   
     * @param id
     */
    public void updateByPrimaryKey(User user);    
    /**
     * 获取user集合
     * @return
     */
    public List<User> getAllUser(); 
    /**
     * 模糊查询name数量的user
     * @param name
     * @return
     */
    public Integer getUserCount(String name);    
    
    /**
     * 分页操作，调用findByPage limit分页方法
     * @param map
     * @return
     */
    List<User> findByPage(HashMap<String,Object> map);
    
    int selectCount();
} 
