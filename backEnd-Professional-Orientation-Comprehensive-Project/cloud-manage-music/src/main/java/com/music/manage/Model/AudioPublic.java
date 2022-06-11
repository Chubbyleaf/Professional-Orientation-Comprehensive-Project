package com.music.manage.Model;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.time.Instant;

@Table(name = "audio_public", indexes = {
        @Index(name = "apub_author_id", columnList = "apub_author_id")
})
@Entity
public class AudioPublic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "audio_id", nullable = false)
    private Integer id;

    @Column(name = "audio_name")
    private String audioName;

    @Column(name = "status", nullable = false)
    private Integer status;

    @Lob
    @Column(name = "comment")
    private String comment;

    @Column(name = "create_time", nullable = false)
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone= "GMT+8")
    private Instant createTime;

    @Column(name = "des", length = 500)
    private String des;

    @Column(name = "audio_url", length = 500)
    private String audioUrl;

    @Column(name = "img_url", length = 500)
    private String imgUrl;

    @Column(name = "identity")
    private Integer identity;

    @ManyToOne
    @JoinColumn(name = "apub_author_id")
    private User apubAuthor;

    public User getApubAuthor() {
        return apubAuthor;
    }

    public void setApubAuthor(User apubAuthor) {
        this.apubAuthor = apubAuthor;
    }

    public Integer getIdentity() {
        return identity;
    }

    public void setIdentity(Integer identity) {
        this.identity = identity;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getAudioUrl() {
        return audioUrl;
    }

    public void setAudioUrl(String audioUrl) {
        this.audioUrl = audioUrl;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public Instant getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Instant createTime) {
        this.createTime = createTime;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getAudioName() {
        return audioName;
    }

    public void setAudioName(String audioName) {
        this.audioName = audioName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}