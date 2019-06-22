package com.hzit.hystrixDashboard.api.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true) //支持链式写法
@Data
public class Dept implements Serializable {
    private Integer deptno;
    private String dname;
    private String loc;
    //private String db_source;
}