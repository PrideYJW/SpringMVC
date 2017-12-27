package com.web;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.context.ServletContextAware;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;

/**
 * Created by Administrator on 2017/10/14.
 */
@Controller
public class UploadController  implements ServletContextAware{
//使用Spring 文件的上传必须在jsp 页面中， <input id="music" type="file" name="music"/> name 属性必须存在要不然将会失败

    ServletContext servletContext;
    @Autowired
    @Qualifier(value = "multipartResolver")
    CommonsMultipartResolver commonsMultipartResolver;

    @RequestMapping("/multiupload.xhtml")
    public void upload(HttpServletRequest request){

        String rootDirectory  = servletContext.getRealPath("/upload");

        if(commonsMultipartResolver.isMultipart(request)) {
            MultipartRequest multipartRequest = (MultipartRequest) request;
            Iterator<String> iterator = multipartRequest.getFileNames();
            while (iterator.hasNext()) {
                MultipartFile oldFile=  multipartRequest.getFile(iterator.next());
                String origin=  oldFile.getOriginalFilename();
                File file=new File(rootDirectory+"/"+origin);
                try {
                    oldFile.transferTo(file);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }



    }


    public void setServletContext(ServletContext servletContext) {
        this.servletContext = servletContext;
    }
}
