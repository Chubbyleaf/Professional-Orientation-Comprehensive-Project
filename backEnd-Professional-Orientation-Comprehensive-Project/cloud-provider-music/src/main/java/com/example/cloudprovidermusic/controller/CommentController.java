package com.example.cloudprovidermusic.controller;



import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.cloudprovidermusic.entity.Comment;
import com.example.cloudprovidermusic.service.CommentService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * (Comment)表控制层
 *
 * @author PinkCrow007
 * @since 2022-05-11 09:09:11
 */
@RestController
@RequestMapping("comment")
public class CommentController extends ApiController {
    /**
     * 服务对象
     */
    @Resource
    private CommentService commentService;

    @GetMapping("/selectCommentByAudioId")
    public R selectCommentByAudioId(Integer audioId) {
        return success(this.commentService.findAll(audioId));
    }

    /**
     * 分页查询所有数据
     *
     * @param page 分页对象
     * @param comment 查询实体
     * @return 所有数据
     */
    @GetMapping
    public R selectAll(Page<Comment> page, Comment comment) {
        return success(this.commentService.page(page, new QueryWrapper<>(comment)));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public R selectOne(@PathVariable Serializable id) {
        return success(this.commentService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param comment 实体对象
     * @return 新增结果
     */
    @PostMapping
    public R insert(@RequestBody Comment comment) {
        return success(this.commentService.save(comment));
    }

    /**
     * 修改数据
     *
     * @param comment 实体对象
     * @return 修改结果
     */
    @PutMapping
    public R update(@RequestBody Comment comment) {
        return success(this.commentService.updateById(comment));
    }

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @DeleteMapping
    public R delete(@RequestParam("idList") List<Long> idList) {
        return success(this.commentService.removeByIds(idList));
    }
}

