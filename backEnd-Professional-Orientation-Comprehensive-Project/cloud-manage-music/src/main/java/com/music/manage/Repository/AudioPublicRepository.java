package com.music.manage.Repository;


import com.music.manage.Model.AudioPublic;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AudioPublicRepository extends JpaRepository<AudioPublic, Integer> {
    List<AudioPublic> findByApubAuthor_Id(String ownerId);
    Optional<AudioPublic> findById(Integer audioId);
    List<AudioPublic> findByStatus(Integer status);
    List<AudioPublic> findByAudioName(String audioName);
    void deleteById(Integer id);

}