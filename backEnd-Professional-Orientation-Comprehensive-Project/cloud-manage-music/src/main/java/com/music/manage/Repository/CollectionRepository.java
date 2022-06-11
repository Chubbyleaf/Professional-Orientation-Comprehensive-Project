package com.music.manage.Repository;


import com.music.manage.Model.Collection;
import com.music.manage.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CollectionRepository extends JpaRepository<Collection, Integer> {
    //查找某个收藏夹
    Collection findCollectionById(Integer id);
    //查找用户的收藏夹
    List<Collection> findByColOwner(User user);
}