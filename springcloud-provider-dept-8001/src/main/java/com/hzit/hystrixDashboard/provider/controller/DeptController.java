package com.hzit.hystrixDashboard.provider.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hzit.hystrixDashboard.api.entity.Dept;
import com.hzit.hystrixDashboard.provider.service.IDeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class DeptController {
    @Autowired
    private IDeptService iDeptService;

    @RequestMapping("/dept/get/{deptno}")
    @ResponseBody
    public Dept getDeptById(@PathVariable Integer deptno){
        if(deptno>3){
            throw new RuntimeException("没有部门meiyoubumeng");
        }
        QueryWrapper<Dept> deptQueryWrapper = new QueryWrapper<>();
        deptQueryWrapper.eq("deptno",deptno);
        Dept dept = iDeptService.getOne(deptQueryWrapper);
        return dept;
    }

    @RequestMapping("/dept/list")
    @ResponseBody
    public List<Dept> getDeptList(){
        List<Dept> list = iDeptService.list();
        System.out.println(list);
        return list;
    }
}
