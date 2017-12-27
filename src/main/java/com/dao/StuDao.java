package com.dao;



import com.entity.StudentEntity;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/10/12.
 */
public interface StuDao {

    public  List<Map<String,Object>> login(String name, String Password);

    public int add(String name,String Password);

    public int update(int id, StudentEntity stu);

    public int delete(int id);
}
