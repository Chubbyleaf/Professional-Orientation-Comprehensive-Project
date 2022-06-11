package com.music.manage.Model;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.Table;

@Table(name = "audio_warehouse", indexes = {
        @Index(name = "aw_audio_id", columnList = "aw_audio_private_id")
})
@Entity
public class AudioWarehouse {
    @EmbeddedId
    private AudioWarehouseId id;

    public AudioWarehouseId getId() {
        return id;
    }

    public void setId(AudioWarehouseId id) {
        this.id = id;
    }
}