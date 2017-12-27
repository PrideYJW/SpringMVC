package com.utli;

import com.entity.StudentEntity;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Administrator on 2017/10/15.
 */
@Component
@org.aspectj.lang.annotation.Aspect
public class Aspect {

    @Pointcut("execution(public * com.web.*.login(..))")
    public  void init(){

    }



    @Pointcut("@annotation(org.springframework.web.bind.annotation.RequestMapping)")
    public  void pointCut(){

    }


     @After("pointCut()")
    public void After(JoinPoint joinp) {
         HttpServletRequest request = (HttpServletRequest) joinp.getArgs()[0];
         StudentEntity studentEntity = (StudentEntity) request.getSession().getAttribute("Student");

         long startTime = System.currentTimeMillis();
         SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
         Date date = new Date(startTime);

         if (joinp.getSignature().getName() == "login") {
             System.out.println(sdf.format(date) + "   " + studentEntity.getName() + "登陆成功");
         } else if (joinp.getSignature().getName() == "add") {

             System.out.println(sdf.format(date) + "   " + studentEntity.getName() + "增加用户成功");

         } else if (joinp.getSignature().getName() == "delete") {

             System.out.println(sdf.format(date) + "   " + studentEntity.getName() + "删除用户成功");

         } else if (joinp.getSignature().getName() == "upload") {

             System.out.println(sdf.format(date) + "   " + studentEntity.getName() + "上传成功");

         }else if (joinp.getSignature().getName() == "update") {

             System.out.println(sdf.format(date) + "   " + studentEntity.getName() + "修改成功");

         }


    }
}
