package com.hzit.hystrixDashboard.provider.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hzit.hystrixDashboard.api.entity.Dept;
import com.hzit.hystrixDashboard.provider.mapper.DeptMapper;
import com.hzit.hystrixDashboard.provider.service.IDeptService;
import org.springframework.stereotype.Service;

@Service
public class DeptServiceImpl extends ServiceImpl<DeptMapper, Dept> implements IDeptService {
}
