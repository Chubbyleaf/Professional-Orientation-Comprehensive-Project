package com.music.manage.Model;

import org.hibernate.Hibernate;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class AudioWarehouseId implements Serializable {
    private static final long serialVersionUID = -6254917848522034048L;
    @Column(name = "aw_warehouse_id", nullable = false)
    private Integer awWarehouseId;
    @Column(name = "aw_audio_private_id", nullable = false)
    private Integer awAudioPrivateId;

    public Integer getAwAudioPrivateId() {
        return awAudioPrivateId;
    }

    public void setAwAudioPrivateId(Integer awAudioPrivateId) {
        this.awAudioPrivateId = awAudioPrivateId;
    }

    public Integer getAwWarehouseId() {
        return awWarehouseId;
    }

    public void setAwWarehouseId(Integer awWarehouseId) {
        this.awWarehouseId = awWarehouseId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(awAudioPrivateId, awWarehouseId);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        AudioWarehouseId entity = (AudioWarehouseId) o;
        return Objects.equals(this.awAudioPrivateId, entity.awAudioPrivateId) &&
                Objects.equals(this.awWarehouseId, entity.awWarehouseId);
    }
}