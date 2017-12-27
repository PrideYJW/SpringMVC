package com.dao.impl;

import com.dao.StuDao;
import com.entity.StudentEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/10/12.
 */
@Repository
public class StuDaoImpl implements StuDao{

     NamedParameterJdbcTemplate namedParameterJdbcTemplate;

     @Resource
     public void setNamedParameterJdbcTemplate(DataSource dataSource) {
        namedParameterJdbcTemplate=new NamedParameterJdbcTemplate(dataSource);
    }

    public List<Map<String,Object>> login(String name, String Password) {
         StudentEntity studentEntity=new StudentEntity();
         studentEntity.setName(name);
         studentEntity.setPassword(Password);
         String sql="select * from stu where name=:name and Password=:Password";
         SqlParameterSource parameterSource=new BeanPropertySqlParameterSource(studentEntity);
         List<Map<String,Object>> map= namedParameterJdbcTemplate.queryForList(sql,parameterSource);

        return map;
    }

    public int add(String name, String Password) {
         StudentEntity studentEntity=new StudentEntity();
         studentEntity.setName(name);
         studentEntity.setPassword(Password);
         String sql="insert into stu(name,Password)values(:name,:Password)";
         SqlParameterSource parameterSource=new BeanPropertySqlParameterSource(studentEntity);
         int a= namedParameterJdbcTemplate.update(sql,parameterSource);
         return a;
    }

    public int update(int id,StudentEntity stu) {
          String sql="update stu set name=:name,Password=:password where id="+id;
          SqlParameterSource parameterSource=new BeanPropertySqlParameterSource(stu);
          int a= namedParameterJdbcTemplate.update(sql,parameterSource);
        return a;
    }

    public int delete(int id) {
         StudentEntity studentEntity=new StudentEntity();
         studentEntity.setId(id);
         String sql="delete from  stu  where id=:id ";
         SqlParameterSource parameterSource=new BeanPropertySqlParameterSource(studentEntity);
         int a=namedParameterJdbcTemplate.update(sql,parameterSource);

        return a;
    }


}
