package com.music.manage.Repository;

import com.music.manage.Model.AudioPrivate;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AudioPrivateRepository extends JpaRepository<AudioPrivate, Integer> {
    void deleteById(Integer id);
    //通过audioId找到仓库中的音乐
    AudioPrivate findAudioPrivateById(Integer id);
    //通过key找音乐
    AudioPrivate findByKey(String key);
}