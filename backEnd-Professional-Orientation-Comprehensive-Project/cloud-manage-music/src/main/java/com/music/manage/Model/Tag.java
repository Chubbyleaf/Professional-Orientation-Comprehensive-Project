package com.music.manage.Model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Tag {
    private int tagId;
    private String tagName;

    @Id
    @Column(name = "tag_id")
    public int getTagId() {
        return tagId;
    }

    public void setTagId(int tagId) {
        this.tagId = tagId;
    }

    @Basic
    @Column(name = "tag_name")
    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Tag tag = (Tag) o;

        if (tagId != tag.tagId) return false;
        if (!Objects.equals(tagName, tag.tagName)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = tagId;
        result = 31 * result + (tagName != null ? tagName.hashCode() : 0);
        return result;
    }
}
