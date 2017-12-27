package com.service.impl;

import com.dao.StuDao;
import com.entity.StudentEntity;
import com.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/10/15.
 */
@Service
public class BaseServiceImpl implements BaseService {
    @Autowired
    StuDao stuDao;

    public int add(String name, String Password) {
        int a= stuDao.add(name,Password);
        return a;
    }

    public  List<Map<String,Object>> login(String name, String Password) {
        List<Map<String,Object>> map=   stuDao.login(name,Password);
        return map;
    }

    public int update(int id, StudentEntity stu) {
        int a= stuDao.update(id,stu);
        return a;
    }

    public int delete(int id) {
        int a= stuDao.delete(id);
        return a;
    }
}
