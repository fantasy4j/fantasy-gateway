package com.fantasy4j.gateway.domain;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by lihui23 on 2019/11/25
 */
@Data
public class BaseDomain implements Serializable {

    private Integer id;
    private Date createTime;
    private String createUser;
    private Date updateTime;
    private String updateUser;
    private Integer status; //状态,0新增 1删除
}
