package com.web;

import com.entity.StudentEntity;
import com.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/10/14.
 */
@Controller
public class BasaController {

    @Autowired
   BaseService baseService;

    @RequestMapping("/upload.xhtml")
    public String upload(){

        return "upload";
    }


    @RequestMapping("/delete.xhtml")
    public String delete(HttpServletRequest request){
    int id=Integer.parseInt(request.getParameter("id"));
      int a= baseService.delete(id);
       if(a>0){
           return "index";
       }
       return "";
    }


    @RequestMapping("/update.xhtml")
    public String update(HttpServletRequest request){
        int id=Integer.parseInt(request.getParameter("id"));
        String name=request.getParameter("name");
        String Password=request.getParameter("password");
        StudentEntity studentEntity=new StudentEntity();
        studentEntity.setName(name);
        studentEntity.setPassword(Password);

        int a=  baseService.update(id,studentEntity);
        if(a>0){
            return "index";
        }
        return "";
    }

    @RequestMapping("/add.xhtml")
    public String add(HttpServletRequest request){
        String name=request.getParameter("name");
        String Password=request.getParameter("password");

        int a= baseService.add(name,Password);

        if(a>0){

        }


        return "";
    }



    @RequestMapping("/login.xhtml")
    public String login(HttpServletRequest request) {

        String name = request.getParameter("name");
        String Password = request.getParameter("password");
        List<Map<String,Object>> map= baseService.login(name, Password);
        if(map!=null){
            StudentEntity stu=new StudentEntity();
            stu.setName(name);
            request.getSession().setAttribute("Student",stu);

            return "index";
        }
        return "upload";
    }


    @RequestMapping("json.xhtml")
    public String json(HttpServletRequest request){


        List<StudentEntity> list=new ArrayList<StudentEntity>();


        return "";
    }



}
