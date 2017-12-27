package com.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by Administrator on 2017/10/15 0015.
 */
@Entity(name="operation")
public class OperationEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    public Integer oid;
    public String account;
    public String odate;
    public String opertion;

    public Integer getOid() {
        return oid;
    }

    public String getAccount() {
        return account;
    }

    public String getOdate() {
        return odate;
    }

    public String getOpertion() {
        return opertion;
    }

    public void setOid(Integer oid) {
        this.oid = oid;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public void setOdate(String odate) {
        this.odate = odate;
    }

    public void setOpertion(String opertion) {
        this.opertion = opertion;
    }
}
