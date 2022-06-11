package com.example.cloudprovidermaker.sys.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.cloudprovidermaker.sys.entity.AudioPrivateSchema;
import com.example.cloudprovidermaker.sys.entity.AudioWareHouseSchema;
import com.example.cloudprovidermaker.sys.mapper.AudioPrivateMapper;
import com.example.cloudprovidermaker.sys.mapper.AudioWareHouseMapper;
import com.example.cloudprovidermaker.sys.mapper.WareHouseMapper;
import com.example.cloudprovidermaker.sys.service.AudioPrivateService;
import com.example.cloudprovidermaker.sys.vo.AudioGetAll;
import com.example.cloudprovidermaker.sys.vo.TxtGetAll;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.crypto.Data;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

@Service
public class AudioPrivateServiceImpl extends ServiceImpl<AudioPrivateMapper, AudioPrivateSchema> implements AudioPrivateService{

    @Autowired
    AudioPrivateMapper audioPrivateMapper;

    @Autowired
    AudioWareHouseMapper audioWareHouseMapper;

    @Override
    public List<TxtGetAll> getalltxt(String userId) {
        List<TxtGetAll> ret = new ArrayList<>();
        List<AudioPrivateSchema> txt = audioPrivateMapper.getalltxt(userId);
        for (int i = 0; i < txt.size(); i++) {
            TxtGetAll tmp = new TxtGetAll();
            tmp.setAudio_id( txt.get(i).getAudio_id() );
            tmp.setAudio_name( txt.get(i).getAudio_name() );
            tmp.setTxt_url( txt.get(i).getTxt_url() );
            tmp.setCreate_time(txt.get(i).getCreate_time().toString());
            tmp.setUser_id( txt.get(i).getUser_id() );
            ret.add(tmp);
        }
        return ret;
    }
    @Override
    public void newTxt(String name, String user_id,String url,Integer warehouse_id)
    {
        AudioPrivateSchema tmp = new  AudioPrivateSchema();
        if (audioPrivateMapper.findByName( name ) != null) {
            AudioPrivateSchema ret = audioPrivateMapper.findByName( name );
            Date d = new Date();
            ret.setTime( d );
            ret.setName( name );
            ret.setUser_id( user_id );
            ret.setTxt_url( url );
            audioPrivateMapper.save( ret );

            AudioWareHouseSchema rr=new AudioWareHouseSchema();
            rr.setAw_warehouse_id(warehouse_id);
            rr.setAw_audio_private_id(ret.getAudio_id());
            audioWareHouseMapper.save( rr );
            return;
        }
        tmp.setName( name );
        tmp.setUser_id( user_id );
        tmp.setTxt_url( url );
        Date d = new Date();
        tmp.setTime( d );
        audioPrivateMapper.save( tmp );

        AudioWareHouseSchema rr=new AudioWareHouseSchema();
        rr.setAw_warehouse_id(warehouse_id);
        rr.setAw_audio_private_id(tmp.getAudio_id());
        audioWareHouseMapper.save( rr );
        return;
    }

    @Override
    public void newMp4(String name, String user_id,String url,Integer warehouse_id)
    {
        AudioPrivateSchema tmp = new  AudioPrivateSchema();
        if (audioPrivateMapper.findByName( name ) != null) {
            AudioPrivateSchema ret = audioPrivateMapper.findByName( name );
            Date d = new Date();
            ret.setTime( d );
            ret.setName( name );
            ret.setUser_id( user_id );
            ret.setVideo_url( url );
            audioPrivateMapper.saveMp4( ret );

            AudioWareHouseSchema rr=new AudioWareHouseSchema();
            rr.setAw_warehouse_id(warehouse_id);
            rr.setAw_audio_private_id(ret.getAudio_id());
            audioWareHouseMapper.save( rr );
            return;
        }
        tmp.setName( name );
        tmp.setUser_id( user_id );
        tmp.setVideo_url( url );
        Date d = new Date();
        tmp.setTime( d );
        audioPrivateMapper.saveMp4( tmp );
        AudioWareHouseSchema rr=new AudioWareHouseSchema();
        rr.setAw_warehouse_id(warehouse_id);
        rr.setAw_audio_private_id(tmp.getAudio_id());
        audioWareHouseMapper.save( rr );
        return;
    }

    @Override
    public void newMp3(String name, String user_id,String url,Integer warehouse_id)
    {
        AudioPrivateSchema tmp = new  AudioPrivateSchema();
        if (audioPrivateMapper.findByName( name ) != null) {
            AudioPrivateSchema ret = audioPrivateMapper.findByName( name );
            Date d = new Date();
            ret.setTime( d );
            ret.setName( name );
            ret.setUser_id( user_id );
            ret.setAudio_url( url );
            audioPrivateMapper.saveMp3( ret );
            AudioWareHouseSchema rr=new AudioWareHouseSchema();
            rr.setAw_warehouse_id(warehouse_id);
            rr.setAw_audio_private_id(ret.getAudio_id());
            audioWareHouseMapper.save( rr );
            return;
        }
        tmp.setName( name );
        tmp.setUser_id( user_id );
        tmp.setAudio_url( url );
        Date d = new Date();
        tmp.setTime( d );
        audioPrivateMapper.saveMp3( tmp );
        AudioWareHouseSchema rr=new AudioWareHouseSchema();
        rr.setAw_warehouse_id(warehouse_id);
        rr.setAw_audio_private_id(tmp.getAudio_id());
        audioWareHouseMapper.save( rr );
        return;
    }

    @Override
    public List<AudioGetAll> getallMp3(String userId) {
        List<AudioGetAll> ret = new ArrayList<>();
        List<AudioPrivateSchema> txt = audioPrivateMapper.getallMp3(userId);
        for (int i = 0; i < txt.size(); i++) {
            AudioGetAll tmp = new AudioGetAll();
            tmp.setAudio_id( txt.get(i).getAudio_id() );
            tmp.setAudio_name( txt.get(i).getAudio_name() );
            tmp.setAudio_url( txt.get(i).getAudio_url() );
            tmp.setCreate_time(txt.get(i).getCreate_time().toString());
            tmp.setUser_id( txt.get(i).getUser_id() );
            ret.add(tmp);
        }
        return ret;
    }

    @Override
    public List<AudioGetAll> getallpMp3(String userId) {
        List<AudioGetAll> ret = new ArrayList<>();
        List<AudioPrivateSchema> txt = audioPrivateMapper.getallPMp3(userId);
        for (int i = 0; i < txt.size(); i++) {
            AudioGetAll tmp = new AudioGetAll();
            tmp.setAudio_id( txt.get(i).getAudio_id() );
            tmp.setAudio_name( txt.get(i).getAudio_name() );
            tmp.setAudio_url( txt.get(i).getAudio_url() );
            tmp.setCreate_time(txt.get(i).getCreate_time().toString());
            tmp.setUser_id( txt.get(i).getUser_id() );
            ret.add(tmp);
        }
        return ret;
    }

    @Override
    public AudioGetAll findMp3Byid(String bgm_value) {
        AudioGetAll ret = new AudioGetAll();
        AudioPrivateSchema txt = audioPrivateMapper.findMp3Byid(bgm_value);
        ret.setAudio_id( txt.getAudio_id() );
        ret.setAudio_name( txt.getAudio_name() );
        ret.setAudio_url( txt.getAudio_url() );
        ret.setCreate_time(txt.getCreate_time().toString());
        ret.setUser_id( txt.getUser_id() );
        return ret;
    }

}
