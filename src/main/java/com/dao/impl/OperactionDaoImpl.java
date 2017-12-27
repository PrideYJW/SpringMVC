package com.dao.impl;

import com.dao.OperationDao;
import com.entity.OperationEntity;

import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import javax.sql.DataSource;

/**
 * Created by Administrator on 2017/10/15 0015.
 */
@Repository
public class OperactionDaoImpl implements OperationDao{
    NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    @Resource
    public void setNamedParameterJdbcTemplate(DataSource dataSource){
        namedParameterJdbcTemplate=new NamedParameterJdbcTemplate(dataSource);
    }
    public void addOperation(String account, String odate, String operation) {
        OperationEntity operationEntity=new OperationEntity();
        operationEntity.setAccount(account);
        operationEntity.setOdate(odate);
        operationEntity.setOpertion(operation);
        String sql="insert into operation(account,odate,operation) values(:account,:odate,:operation)";
        SqlParameterSource sqlParameterSource = new BeanPropertySqlParameterSource(operationEntity);
        namedParameterJdbcTemplate.update(sql,sqlParameterSource);
    }
}
