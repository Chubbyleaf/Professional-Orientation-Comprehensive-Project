package com.music.manage.Model;

import org.hibernate.Hibernate;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class AudioCollectionId implements Serializable {
    private static final long serialVersionUID = 7094101083051135395L;
    @Column(name = "ac_collection_id", nullable = false)
    private Integer acCollectionId;
    @Column(name = "ac_audio_id", nullable = false)
    private Integer acAudioId;

    public Integer getAcAudioId() {
        return acAudioId;
    }

    public void setAcAudioId(Integer acAudioId) {
        this.acAudioId = acAudioId;
    }

    public Integer getAcCollectionId() {
        return acCollectionId;
    }

    public void setAcCollectionId(Integer acCollectionId) {
        this.acCollectionId = acCollectionId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(acAudioId, acCollectionId);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        AudioCollectionId entity = (AudioCollectionId) o;
        return Objects.equals(this.acAudioId, entity.acAudioId) &&
                Objects.equals(this.acCollectionId, entity.acCollectionId);
    }
}