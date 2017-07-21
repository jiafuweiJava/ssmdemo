package com.ssm.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;    
import java.util.Map;

import javax.annotation.Resource;    
import javax.servlet.http.HttpServletRequest;    
    
import org.springframework.stereotype.Controller;    
import org.springframework.ui.Model;    
import org.springframework.web.bind.annotation.RequestMapping;    
import org.springframework.web.bind.annotation.ResponseBody;
    
import com.ssm.dto.User;    
import com.ssm.service.IUserService;    
    
@Controller    
@RequestMapping("/user")    
public class UserController {    
    @Resource    
    private IUserService userService;    
       
    @ResponseBody
    @RequestMapping("/userList")    
    public List<User> userList(HttpServletRequest request,Model model){    
        List<User> uList = userService.getAllUser();    
        model.addAttribute("uList", uList);    
        return uList;    
    }    
      
    @ResponseBody
    @RequestMapping("/showUser")    
    public User showUser(HttpServletRequest request,Model model){    
        int userId = Integer.parseInt(request.getParameter("id"));    
        User user = userService.getUserById(userId);    
        model.addAttribute("user", user);    
        return user;    
    }    
        
    @RequestMapping("/addUserUI")    
    public String addUserUI(){    
        return "addUser";    
    }    
       
    @ResponseBody
    @RequestMapping("/addUser")    
    public User addUser(HttpServletRequest request,Model model){    
        User user = new User();    
        user.setName(String.valueOf(request.getParameter("name")));    
        user.setPassword(String.valueOf(request.getParameter("password")));    
        user.setAge(Integer.parseInt(String.valueOf(request.getParameter("age"))));    
        userService.addUser(user);    
        return user;    
    }  
    
    /**
     * 更新用户
     * @return
     */
    @ResponseBody
    @RequestMapping("/updateByPrimaryKey")
    public User updateByPrimaryKey() {
        User user=new User();
        user.setId(1);
        user.setAge(10);
        user.setName("小明");
        user.setPassword("123456");
        userService.updateByPrimaryKey(user);
        
        return user;
    }
    
    /**
     * 批量查询
     * @param request
     * @param model
     * @return
     */
    @ResponseBody
    @RequestMapping("/queryUserByBatch")    
    public List<User> queryUserByBatch(HttpServletRequest request,Model model){   
    	Map<String,Object> params = new HashMap<String,Object>();
    	List<Integer> idList = new ArrayList<Integer>();
    	idList.add(1);
    	idList.add(2);
    	params.put("idList", idList);
        List<User> uList = userService.queryUserByBatch(params);    
        model.addAttribute("uList", uList);    
        return uList;    
    } 
    
    /**
     * 查询count 得到int类型
     * @return
     */
    @ResponseBody
    @RequestMapping("/getUserCount")
    public Integer getUserCount() {
        
    	Integer count = userService.getUserCount("xiao");
        
        return count;
    }
} 