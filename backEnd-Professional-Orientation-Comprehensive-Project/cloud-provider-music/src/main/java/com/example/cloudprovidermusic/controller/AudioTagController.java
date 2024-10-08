package com.example.cloudprovidermusic.controller;



import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.cloudprovidermusic.entity.AudioTag;
import com.example.cloudprovidermusic.service.AudioTagService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * (AudioTag)表控制层
 *
 * @author PinkCrow007
 * @since 2022-04-27 02:15:32
 */
@RestController
@RequestMapping("audioTag")
public class AudioTagController extends ApiController {
    /**
     * 服务对象
     */
    @Resource
    private AudioTagService audioTagService;

    /**
     * 分页查询所有数据
     *
     * @param page 分页对象
     * @param audioTag 查询实体
     * @return 所有数据
     */
    @GetMapping
    public R selectAll(Page<AudioTag> page, AudioTag audioTag) {
        return success(this.audioTagService.page(page, new QueryWrapper<>(audioTag)));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public R selectOne(@PathVariable Serializable id) {
        return success(this.audioTagService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param audioTag 实体对象
     * @return 新增结果
     */
    @PostMapping
    public R insert(@RequestBody AudioTag audioTag) {
        return success(this.audioTagService.save(audioTag));
    }

    /**
     * 修改数据
     *
     * @param audioTag 实体对象
     * @return 修改结果
     */
    @PutMapping
    public R update(@RequestBody AudioTag audioTag) {
        return success(this.audioTagService.updateById(audioTag));
    }

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @DeleteMapping
    public R delete(@RequestParam("idList") List<Long> idList) {
        return success(this.audioTagService.removeByIds(idList));
    }
}

