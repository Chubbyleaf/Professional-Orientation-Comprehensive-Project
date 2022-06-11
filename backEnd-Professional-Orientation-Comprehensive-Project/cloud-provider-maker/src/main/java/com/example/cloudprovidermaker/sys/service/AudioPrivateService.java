package com.example.cloudprovidermaker.sys.service;

import com.example.cloudprovidermaker.sys.vo.AudioGetAll;
import com.example.cloudprovidermaker.sys.vo.TxtGetAll;

import java.util.List;

public interface AudioPrivateService {
    List<TxtGetAll> getalltxt(String userId);
    void newTxt(String name, String user_id,String url,Integer warehouse_id);
    void newMp4(String name, String user_id,String url,Integer warehouse_id);
    void newMp3(String name, String user_id,String url,Integer warehouse_id);
    List<AudioGetAll> getallMp3(String userId);
    List<AudioGetAll> getallpMp3(String userId);
    AudioGetAll findMp3Byid(String bgm_value);
}
