package com.music.manage.Model;

import javax.persistence.*;

@Entity
@Table(name = "audio_tag", schema = "zyzh", catalog = "")
@IdClass(AudioTagPK.class)
public class AudioTag {
    private int atTagId;
    private int atAudioPublicId;

    @Id
    @Column(name = "at_tag_id")
    public int getAtTagId() {
        return atTagId;
    }

    public void setAtTagId(int atTagId) {
        this.atTagId = atTagId;
    }

    @Id
    @Column(name = "at_audio_public_id")
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

        AudioTag audioTag = (AudioTag) o;

        if (atTagId != audioTag.atTagId) return false;
        if (atAudioPublicId != audioTag.atAudioPublicId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = atTagId;
        result = 31 * result + atAudioPublicId;
        return result;
    }
}
