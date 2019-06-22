package com.hzit.hystrixDashboard.api.feign;

import com.hzit.hystrixDashboard.api.entity.Dept;
import com.hzit.hystrixDashboard.api.factory.DeptClientServiceFallbackFactoy;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@FeignClient(value = "SPRINGCLOUD-DEPT",fallbackFactory = DeptClientServiceFallbackFactoy.class)
@RequestMapping("/provider")
public interface FeignService {

    @RequestMapping("/dept/get/{deptno}")
    public Dept getDeptById(@PathVariable("deptno") Integer deptno);

    @RequestMapping("/dept/list")
    public List<Dept> getDeptList();
}
