package com.service.impl;

import com.service.OperationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2017/10/15 0015.
 */
@Service("operationService")
public class OperationServiceImpl implements OperationService{
    @Autowired
    OperationService operationService;
    public void addOperation(String account, String odate, String operation) {
        operationService.addOperation(account,odate,operation);
    }
}
