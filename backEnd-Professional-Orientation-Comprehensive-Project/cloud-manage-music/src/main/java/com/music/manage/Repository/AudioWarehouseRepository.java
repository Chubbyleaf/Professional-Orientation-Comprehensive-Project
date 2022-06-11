package com.music.manage.Repository;


import com.music.manage.Model.AudioWarehouse;
import com.music.manage.Model.AudioWarehouseId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface AudioWarehouseRepository extends JpaRepository<AudioWarehouse, AudioWarehouseId> {
    void deleteById(AudioWarehouseId audioWarehouseId);
    //通过warehouseId删除
    void deleteById_AwWarehouseId(Integer warehouseId);
    //通过warehouseId查找全部音乐
    List<AudioWarehouse> findById_AwWarehouseId(Integer warehouseId);

    /**
     * 查找某个收藏夹里面的而全部歌曲
     */
    @Query("select AW.id.awAudioPrivateId,AP.audioName,AP.audioUrl,AP.txtUrl,AP.videoUrl,user.id,user.userName,AP.createTime" +
            " from AudioWarehouse AW left join AudioPrivate AP on AW.id.awAudioPrivateId=AP.id left join User user on AP.apriAuthor.id=user.id " +
            "where AW.id.awWarehouseId=?1")
    List<Object[]> musicInWarehouse(Integer audioId);
}