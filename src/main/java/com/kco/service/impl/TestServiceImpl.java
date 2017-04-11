package com.kco.service.impl;

import com.kco.dao.TestDao;
import com.kco.service.TestService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by pc on 2017/4/11.
 */
@Service
public class TestServiceImpl implements TestService {
    @Resource
    private TestDao testDao;
    public String test() {
        return testDao.test();
    }
}
