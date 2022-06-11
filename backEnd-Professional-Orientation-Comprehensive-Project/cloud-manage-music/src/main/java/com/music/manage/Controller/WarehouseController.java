package com.music.manage.Controller;

import com.music.manage.Model.*;
import com.music.manage.Repository.AudioPrivateRepository;
import com.music.manage.Repository.AudioWarehouseRepository;
import com.music.manage.Repository.UserRepository;
import com.music.manage.Repository.WarehouseRepository;
import com.music.manage.Service.WarehouseService;
import com.alibaba.fastjson.JSONObject;
import com.music.manage.Util.QiNiuUtil;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@RequestMapping("Warehouse")
@RestController
@CrossOrigin
public class WarehouseController {
    @Autowired
    WarehouseService warehouseService;
    @Autowired
    WarehouseRepository warehouseRepository;
    @Autowired
    AudioWarehouseRepository audioWarehouseRepository;
    @Autowired
    AudioPrivateRepository audioPrivateRepository;
    @Autowired
    UserRepository userRepository;

    //新建仓库
    @RequestMapping(value ="Add",method = RequestMethod.POST)
    public Object addWarehouse(@RequestBody WarehouseInfo newWarehouse){
        JSONObject jsonObject = new JSONObject();
        User user=new User();
        String warehouseName= newWarehouse.getWarehouseName();
        Instant createTime=Instant.now();
        user.setId(newWarehouse.getOwnerId());

        Warehouse warehouse=new Warehouse();
        warehouse.setWarehouseName(warehouseName);
        warehouse.setWOwner(user);
        warehouse.setCreateTime(createTime);
        warehouseService.add(warehouse);

        jsonObject.put("warehouse", newWarehouse);
        jsonObject.put("message", "成功创建仓库！");
        jsonObject.put("status", 1);
        return jsonObject;
    }

    /**
     * 删除仓库
     * 1.删除warehouse表中信息✔
     * 2.删除audio_warehouse表中信息✔
     * 3.删除audioPrivate中的信息正确
     * @param warehouseId 仓库id
     * @return
     */
    @RequestMapping(value = "Delete", method = RequestMethod.POST)
    public Object deleteWarehouse(Integer warehouseId) {
        JSONObject jsonObject = new JSONObject();
        if (warehouseRepository.findWarehouseById(warehouseId)==null) {
            jsonObject.put("message", "您想要删除的仓库不存在，删除失败!");
            jsonObject.put("status", -1);
            return jsonObject;
        }

        Warehouse warehouse=warehouseRepository.findWarehouseById(warehouseId);
        List<AudioWarehouse> audiosInWarehouse=audioWarehouseRepository.findById_AwWarehouseId(warehouseId);
        for(AudioWarehouse audioWarehouse:audiosInWarehouse){
            //从云端删除
            QiNiuUtil.delete(audioPrivateRepository.findAudioPrivateById(audioWarehouse.getId().getAwAudioPrivateId()).getKey());
            //从数据库删除
            audioPrivateRepository.deleteById(audioWarehouse.getId().getAwAudioPrivateId());//privateMusic表删除
        }
        warehouseRepository.deleteById(warehouseId);
        audioWarehouseRepository.deleteById_AwWarehouseId(warehouseId);
        jsonObject.put("message", "成功删除个人仓库：" + warehouse.getWarehouseName() + "！");
        jsonObject.put("status", 1);
        return jsonObject;
    }

    /**
     * 更新仓库信息
     * 1.更改收藏夹名称
     */
    @RequestMapping(value = "Update", method = RequestMethod.POST)
    public Object updateWarehouse(@RequestBody WarehouseInfo warehouseInfo) {
        JSONObject jsonObject = new JSONObject();
        Warehouse warehouseEdited;
        Optional<Warehouse> targetWarehouse = warehouseRepository.findById(warehouseInfo.getWarehouseId());
        if (targetWarehouse==null) {
            jsonObject.put("message", "仓库不存在，信息修改失败!");
            jsonObject.put("status", -1);
        } else {
            warehouseEdited=targetWarehouse.get();
            warehouseEdited.setWarehouseName(warehouseInfo.getWarehouseName());
            warehouseService.edit(warehouseEdited);
            jsonObject.put("message","仓库名称修改成功！");
            jsonObject.put("status", 1);
        }
        return jsonObject;
    }

    // 以userid获取某个人的仓库
    @RequestMapping(value = "GetByOwner", method = RequestMethod.GET)
    public Object getWarehouseByUser(String ownerId) {
        return warehouseService.findWarehouseByOwner(ownerId);
    }

    //获取某个仓库里里面的全部音乐
    @RequestMapping(value = "AllMusic", method = RequestMethod.GET)
    public Object showWarehouse(Integer warehouseId){
        List<JSONObject> jsonObjects = new ArrayList<>();
        List<Object[]> musics = audioWarehouseRepository.musicInWarehouse(warehouseId);
        for(Object[] music:musics){
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("audioId",music[0]);
            jsonObject.put("audioName",music[1]);
            jsonObject.put("audioUrl",music[2]);
            jsonObject.put("txtUrl",music[3]);
            jsonObject.put("videoUrl",music[4]);
            jsonObject.put("userId",music[5]);
            jsonObject.put("userName",music[6]);
            String time=music[7].toString();
            time=time.replace('T', ' ');
            time=time.replace('Z',' ');
            jsonObject.put("createTime",time);
            jsonObjects.add(jsonObject);
        }
        return jsonObjects;
    }

    /**
     * 将音乐从仓库中删除
     * 1.audio_warehouse表删除✔
     * 2.private_music表删除✔
     * 3.云端删除✔
     */
    @RequestMapping(value = "DeleteMusic", method = RequestMethod.POST)
    public Object deleteMusic(@RequestBody AudioWarehouseId music){
        JSONObject jsonObject = new JSONObject();

        if(!audioWarehouseRepository.findById(music).isPresent()) {
            jsonObject.put("message", "仓库中未找到该音乐！");
            jsonObject.put("status", -1);
        }else{
            //从云端删除
            QiNiuUtil.delete(audioPrivateRepository.findAudioPrivateById(music.getAwAudioPrivateId()).getKey());
            //从数据库删除
            warehouseService.removeMusicFromWarehouse(music.getAwAudioPrivateId());
            jsonObject.put("message", "成功将音乐从仓库删除！");
            jsonObject.put("status", 1);
        }
        return jsonObject;
    }


    /**
     * 上传音乐至个人仓库
     * 1.上传音乐至七牛云✔
     * 2.添加Audio_private表中信息✔
     * 3.添加Audio_WareHouse表中信息✔
     * @param file
     * @return
     */
    @RequestMapping(value = "UploadMusic", method = RequestMethod.POST)
    public Object uploadMusic(@RequestPart("file") MultipartFile file,@RequestParam Integer warehouseId,@RequestParam String ownerId){

        JSONObject jsonObject = new JSONObject();
        if(file.isEmpty()){
            jsonObject.put("message", "您没有选择文件");
            jsonObject.put("status", -1);
            return jsonObject;
        }
        String key= QiNiuUtil.uploadFile(file);
        if(key!=null){
            System.out.println(key);
            jsonObject.put("message", "成功上传音乐"+file.getOriginalFilename()+"!");
            jsonObject.put("filename",key);
            jsonObject.put("status", 1);
            //添加Audio_private表中信息
            User user=userRepository.findUserById(ownerId);
            System.out.println(user.getId());
            AudioPrivate audio=new AudioPrivate();
            audio.setKey(key);
            audio.setAudioName(file.getOriginalFilename());
            audio.setApriAuthor(user);
            audio.setCreateTime(Instant.now());
            audio.setAudioUrl("http://rcqhtityo.bkt.clouddn.com/" +key);
            Integer audioPrivateId=audioPrivateRepository.save(audio).getId();

            //添加Audio_WareHouse表中信息
            AudioWarehouseId audioWarehouseId=new AudioWarehouseId();
            audioWarehouseId.setAwAudioPrivateId(audioPrivateId);
            audioWarehouseId.setAwWarehouseId(warehouseId);
            AudioWarehouse audioWarehouse=new AudioWarehouse();
            audioWarehouse.setId(audioWarehouseId);
            audioWarehouseRepository.save(audioWarehouse);

        }else{
            jsonObject.put("message", "上传音乐失败，请重新上传！");
            jsonObject.put("status", -1);
        }
        return jsonObject;
    }


    @Data
    public static class WarehouseInfo{
        private Integer warehouseId;
        private String warehouseName;
        private String ownerId;
    }

}