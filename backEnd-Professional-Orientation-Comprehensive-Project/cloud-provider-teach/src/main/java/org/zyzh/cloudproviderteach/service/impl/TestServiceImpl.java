package org.zyzh.cloudproviderteach.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zyzh.cloudproviderteach.service.TestService;

import java.util.List;

@Service
public class TestServiceImpl implements TestService {

    @Override
    public String getHello() {
        return "hello world2";
    }



}