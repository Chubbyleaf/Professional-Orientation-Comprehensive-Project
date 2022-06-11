package com.music.manage.Repository;


import com.music.manage.Model.AudioTag;
import com.music.manage.Model.AudioTagPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AudioTagRepository extends JpaRepository<AudioTag, AudioTagPK> {

    void deleteByAtAudioPublicId(int audioId);


    /**
     * 查找某个音乐的所有标签
     */
    @Query("select AT.atTagId,TAG.tagName" +
            " from AudioTag AT left join Tag TAG on AT.atTagId=TAG.tagId " +
            "where AT.atAudioPublicId=?1")
    List<Object[]> findMusicTags(Integer audioId);
}