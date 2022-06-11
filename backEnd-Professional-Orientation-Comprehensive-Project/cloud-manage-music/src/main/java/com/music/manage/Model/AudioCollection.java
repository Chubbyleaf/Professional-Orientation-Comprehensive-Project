package com.music.manage.Model;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.Table;

@Table(name = "audio_collection", indexes = {
        @Index(name = "ac_audio_id", columnList = "ac_audio_id")
})
@Entity
public class AudioCollection {
    @EmbeddedId
    private AudioCollectionId id;

    public AudioCollectionId getId() {
        return id;
    }

    public void setId(AudioCollectionId id) {
        this.id = id;
    }
}