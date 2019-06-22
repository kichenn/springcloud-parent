package com.hzit.hystrixDashboard.provider.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hzit.hystrixDashboard.api.entity.Dept;
import com.hzit.hystrixDashboard.provider.service.IDeptService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class DeptController {
    @Autowired
    private IDeptService iDeptService;

    @RequestMapping("/dept/get/{deptno}")
    @ResponseBody
    @HystrixCommand(fallbackMethod = "nullDeptFallBack")
    public Dept getDeptById(@PathVariable(value = "deptno") Integer deptno){
        if(deptno>3){
            throw new RuntimeException("部门没有大于3d");
        }
        QueryWrapper<Dept> deptQueryWrapper = new QueryWrapper<>();
        deptQueryWrapper.eq("deptno",deptno);
        Dept dept = iDeptService.getOne(deptQueryWrapper);
        return dept;
    }
    public Dept nullDeptFallBack(@PathVariable(value = "deptno") Integer deptno) {
        System.out.println("deptno...出现故障");
        return new Dept().setDeptno(500).setDname("没有找到部门ID:"+deptno+"相关的信息").setLoc("no loc");
    }

    @RequestMapping("/dept/list")
    @ResponseBody
    @HystrixCommand(fallbackMethod = "nullDeptFallBack2")
    public List<Dept> getDeptList(){
        int i = 10/0;
        List<Dept> list = iDeptService.list();
        System.out.println(list);
        return list;
    }
    public List<Dept> nullDeptFallBack2() {
        System.out.println("deptno...出现故障");
        ArrayList<Dept> depts = new ArrayList<>();
        depts.add(new Dept().setDeptno(500).setDname("没有找到部门相关的信息").setLoc("no loc"));
        return depts;
    }
}
