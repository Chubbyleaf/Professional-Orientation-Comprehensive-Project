package com.example.cloudprovidermusic.controller;



import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.cloudprovidermusic.entity.Collection;
import com.example.cloudprovidermusic.service.CollectionService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * (Collection)表控制层
 *
 * @author PinkCrow007
 * @since 2022-05-16 19:23:37
 */
@RestController
@RequestMapping("collection")
public class CollectionController extends ApiController {
    /**
     * 服务对象
     */
    @Resource
    private CollectionService collectionService;

    /**
     * 分页查询所有数据
     *
     * @param page 分页对象
     * @param collection 查询实体
     * @return 所有数据
     */
    @GetMapping
    public R selectAll(Page<Collection> page, Collection collection) {
        return success(this.collectionService.page(page, new QueryWrapper<>(collection)));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public R selectOne(@PathVariable Serializable id) {
        return success(this.collectionService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param collection 实体对象
     * @return 新增结果
     */
    @PostMapping
    public R insert(@RequestBody Collection collection) {
        return success(this.collectionService.save(collection));
    }

    /**
     * 修改数据
     *
     * @param collection 实体对象
     * @return 修改结果
     */
    @PutMapping
    public R update(@RequestBody Collection collection) {
        return success(this.collectionService.updateById(collection));
    }

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @DeleteMapping
    public R delete(@RequestParam("idList") List<Long> idList) {
        return success(this.collectionService.removeByIds(idList));
    }
}

