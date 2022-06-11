package com.music.manage.Repository;


import com.music.manage.Model.Warehouse;
import org.springframework.data.jpa.repository.JpaRepository;


public interface WarehouseRepository extends JpaRepository<Warehouse, Integer> {
    //查找某个仓库
    Warehouse findWarehouseById(Integer id);
}