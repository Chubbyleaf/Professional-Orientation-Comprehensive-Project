package com.music.manage.Service;

import com.music.manage.Model.AudioPrivate;
import com.music.manage.Model.AudioWarehouse;
import com.music.manage.Model.Warehouse;
import com.music.manage.Repository.AudioPrivateRepository;
import com.music.manage.Repository.AudioWarehouseRepository;
import com.music.manage.Repository.WarehouseRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * 个人仓库服务类
 */
@Service("WarehouseService")
public class WarehouseService {
    @Resource
    WarehouseRepository warehouseRepository;
    @Resource
    AudioWarehouseRepository audioWarehouseRepository;
    @Resource
    AudioPrivateRepository audioPrivateRepository;
    /**
     * 创建个人仓库
     */
    public void add(Warehouse warehouse){warehouseRepository.save(warehouse);}

    /**
     * 删除个人仓库/
     */
    public void remove(Warehouse warehouse){
        warehouseRepository.deleteById(warehouse.getId());
        audioWarehouseRepository.deleteById_AwWarehouseId(warehouse.getId());
    }

    /**
     * 修改仓库信息
     */
    public void edit(Warehouse warehouse){warehouseRepository.save(warehouse);}

    /**
     * 从仓库删除音乐
     */
    public void removeMusicFromWarehouse(Integer audioId){
        audioWarehouseRepository.deleteById_AwWarehouseId(audioId);
        audioPrivateRepository.deleteById(audioId);
    }

    /**
     * 查找某个人所有的仓库
     */
    public List<Warehouse>findWarehouseByOwner(String ownerId){
        List<Warehouse>allWarehouse=warehouseRepository.findAll();
        System.out.println(ownerId);
        List<Warehouse> result=new ArrayList<>();
        for(Warehouse warehouse:allWarehouse){
            System.out.println(warehouse.getWOwner().getId());
            if(Objects.equals(warehouse.getWOwner().getId(), ownerId)){
                result.add(warehouse);
                System.out.println("1111");
            }
        }
        return result;
    }


}