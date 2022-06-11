package com.music.manage.Model;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "audio_private")
public class AudioPrivate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "audio_id", nullable = false)
    private Integer id;

    @Column(name = "audio_name")
    private String audioName;

    @Column(name = "audio_url", length = 500)
    private String audioUrl;

    @Column(name = "txt_url", length = 500)
    private String txtUrl;

    @Column(name = "video_url", length = 500)
    private String videoUrl;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "apri_author_id")
    private User apriAuthor;

    @Column(name = "create_time", nullable = false)
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone= "GMT+8")
    private Instant createTime;

    @Column(name = "`key`")
    private String key;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Instant getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Instant createTime) {
        this.createTime = createTime;
    }

    public User getApriAuthor() {
        return apriAuthor;
    }

    public void setApriAuthor(User apriAuthor) {
        this.apriAuthor = apriAuthor;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    public String getTxtUrl() {
        return txtUrl;
    }

    public void setTxtUrl(String txtUrl) {
        this.txtUrl = txtUrl;
    }

    public String getAudioUrl() {
        return audioUrl;
    }

    public void setAudioUrl(String audioUrl) {
        this.audioUrl = audioUrl;
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