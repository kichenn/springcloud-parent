package com.hzit.hystrixDashboard.api.factory;

import com.hzit.hystrixDashboard.api.entity.Dept;
import com.hzit.hystrixDashboard.api.feign.FeignService;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DeptClientServiceFallbackFactoy implements FallbackFactory<FeignService> {
    @Override
    public FeignService create(Throwable throwable) {
        return new FeignService() {
            @Override
            public Dept getDeptById(Integer deptno) {
                System.out.println("deptno...出现故障");
                return new Dept().setDeptno(500).setDname("没有找到部门ID:"+deptno+"相关的信息").setLoc("no loc");
            }

            @Override
            public List<Dept> getDeptList() {
                return null;
            }
        };
    }
}
