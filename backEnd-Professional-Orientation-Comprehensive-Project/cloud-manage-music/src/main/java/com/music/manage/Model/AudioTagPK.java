package com.music.manage.Model;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public class AudioTagPK implements Serializable {
    private int atTagId;
    private int atAudioPublicId;

    @Column(name = "at_tag_id")
    @Id
    public int getAtTagId() {
        return atTagId;
    }

    public void setAtTagId(int atTagId) {
        this.atTagId = atTagId;
    }

    @Column(name = "at_audio_public_id")
    @Id
    public int getAtAudioPublicId() {
        return atAudioPublicId;
    }

    public void setAtAudioPublicId(int atAudioPublicId) {
        this.atAudioPublicId = atAudioPublicId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AudioTagPK that = (AudioTagPK) o;

        if (atTagId != that.atTagId) return false;
        if (atAudioPublicId != that.atAudioPublicId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = atTagId;
        result = 31 * result + atAudioPublicId;
        return result;
    }
}
