package com.web;

import com.entity.StudentEntity;
import com.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/10/15.
 */
@Controller
public class LoginController {

    @Autowired
    BaseService baseService;
//
//    @RequestMapping("/login.xhtml")
//    public String login(HttpServletRequest request) {
//
//        String name = request.getParameter("name");
//        String Password = request.getParameter("password");
//        List<Map<String,Object>> map= baseService.login(name, Password);
//          if(map!=null){
//              StudentEntity stu=new StudentEntity();
//              stu.setName(name);
//              request.getSession().setAttribute("Student",stu);
//
//              return "index";
//          }
//        return "upload";
//    }






}
