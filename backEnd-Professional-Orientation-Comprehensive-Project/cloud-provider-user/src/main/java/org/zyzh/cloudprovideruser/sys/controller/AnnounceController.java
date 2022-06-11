package org.zyzh.cloudprovideruser.sys.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.zyzh.cloudprovideruser.framework.vo.Result;
import org.zyzh.cloudprovideruser.sys.mapper.AnnounceMapper;
import org.zyzh.cloudprovideruser.sys.service.AnnounceService;
import org.zyzh.cloudprovideruser.sys.service.MessageService;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import java.util.List;


@RestController
@RequestMapping("/announce")
public class AnnounceController {
    @Autowired
    AnnounceService announceService;

    @GetMapping("/getAnnList")
    public List findUserFollow() {
        return announceService.getAnnList();
    }

}
