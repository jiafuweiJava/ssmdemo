package com.ssm.service;

import java.util.HashMap;
import java.util.List;    
import java.util.Map;

import javax.annotation.Resource;    
    
import org.springframework.stereotype.Service;    
    
import com.ssm.dao.IUserDao;    
import com.ssm.dto.PageBean;
import com.ssm.dto.User;    
import com.ssm.service.IUserService;    
    
@Service("userService")    
public class UserServiceImpl implements IUserService {    
    @Resource    
    private IUserDao userDao;    
        
    public User getUserById(int userId) {    
        return userDao.queryByPrimaryKey(userId);    
    }    
    
    public void insertUser(User user) {    
        userDao.insertUser(user);    
    }    
    
    public void addUser(User user) {    
        userDao.insertUser(user);    
    }    
    
    public List<User> getAllUser() {    
        return userDao.getAllUser();    
    }

	public List<User> queryUserByBatch(Map<String, Object> params) {
		// TODO Auto-generated method stub
		return userDao.queryUserByBatch(params);
	}

	public void updateByPrimaryKey(User user) {
		// TODO Auto-generated method stub
		userDao.updateByPrimaryKey(user);
	}

	public Integer getUserCount(String name) {
		// TODO Auto-generated method stub
		return userDao.getUserCount(name);
	}

	@Override
	public void insertUserByBatch(List<User> list) {
		// TODO Auto-generated method stub
		userDao.insertUserByBatch(list);
	}

	@Override
	public PageBean<User> findByPage(int currentPage) {
		// TODO Auto-generated method stub
		HashMap<String,Object> map = new HashMap<String,Object>();
        PageBean<User> pageBean = new PageBean<User>();

        //封装当前页数
        pageBean.setCurrPage(currentPage);

        //每页显示的数据
        int pageSize=2;
        pageBean.setPageSize(pageSize);

        //封装总记录数
        int totalCount = userDao.selectCount();
        pageBean.setTotalCount(totalCount);

        //封装总页数
        double tc = totalCount;
        Double num =Math.ceil(tc/pageSize);//向上取整
        pageBean.setTotalPage(num.intValue());

        map.put("start",(currentPage-1)*pageSize);
        map.put("size", pageBean.getPageSize());
        //封装每页显示的数据
        List<User> lists = userDao.findByPage(map);
        pageBean.setLists(lists);

        return pageBean;
	}    
    
} 
