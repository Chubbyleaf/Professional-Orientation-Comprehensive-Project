package com.music.manage.Repository;

import com.music.manage.Model.AudioCollection;
import com.music.manage.Model.AudioCollectionId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface AudioCollectionRepository extends JpaRepository<AudioCollection, AudioCollectionId> {

    void deleteById(AudioCollectionId audioCollectionId);
    //通过collectionId删除
    void deleteById_AcCollectionId(Integer collectionId);
    //通过audioId删除
    void deleteById_AcAudioId(Integer audioId);
    Optional<AudioCollection> findById(AudioCollectionId audioCollectionId);


    /**
     * 查找某个收藏夹里面的而全部歌曲
     */
    @Query("select AC.id.acAudioId,AP.audioName,AP.des,AP.audioUrl,AP.imgUrl,user.id,user.userName,AP.identity" +
            " from AudioCollection AC left join AudioPublic AP on AC.id.acAudioId=AP.id left join User user on AP.apubAuthor=user.id " +
            "where AC.id.acCollectionId=?1")
    List<Object[]> musicInCollection(Integer audioId);
}