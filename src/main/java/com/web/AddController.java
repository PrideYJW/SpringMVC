package com.web;

import com.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Administrator on 2017/10/15.
 */
@Controller
public class AddController {
    @Autowired
    BaseService baseService;

//    @RequestMapping("/add.xhtml")
//    public String add(HttpServletRequest request){
//    String name=request.getParameter("name");
//    String Password=request.getParameter("password");
//
//        int a= baseService.add(name,Password);
//
//        if(a>0){
//
//        }
//
//
//        return "";
//    }



}
