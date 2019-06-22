package com.hzit.hystrixDashboard.consumer.controller;

import com.hzit.hystrixDashboard.api.entity.Dept;
import com.hzit.hystrixDashboard.api.feign.FeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DeptControllerConsumer {
    //版本一
    /*//定义统一前缀
    private static final String REST_URL_PREFIX = "http://SPRINGCLOUD-DEPT/provider";

    @Autowired
    private RestTemplate restTemplate;

   @RequestMapping("/dept/get/{deptno}")
    public Dept getDeptById(@PathVariable Integer deptno){
       Dept dept = restTemplate.getForObject(REST_URL_PREFIX + "/dept/get/" + deptno, Dept.class);
       return dept;
   }

    @RequestMapping("/dept/list")
    public List<Dept> getDeptList(){
        List<Dept> list = restTemplate.getForObject(REST_URL_PREFIX + "/dept/list", List.class);
        return list;
    }*/

    //版本二
    @Autowired
    private FeignService feignService;

    @RequestMapping("/dept/get/{deptno}")
    public Dept getDeptById(@PathVariable Integer deptno){
       return feignService.getDeptById(deptno);
    }

    @RequestMapping("/dept/list")
    public List<Dept> getDeptList(){
        return feignService.getDeptList();
    }
}