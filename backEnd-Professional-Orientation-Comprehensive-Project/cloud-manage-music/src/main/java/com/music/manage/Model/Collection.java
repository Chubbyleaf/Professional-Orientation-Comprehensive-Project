package com.music.manage.Model;

import javax.persistence.*;
import java.time.Instant;

@Table(name = "collection", indexes = {
        @Index(name = "col_owner_id", columnList = "col_owner_id")
})
@Entity
public class Collection {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "collection_id", nullable = false)
    private Integer id;

    @Column(name = "collection_name")
    private String collectionName;

    @Column(name = "identity", nullable = false)
    private Integer identity;

    @ManyToOne
    @JoinColumn(name = "col_owner_id")
    private User colOwner;

    @Column(name = "create_time", nullable = false)
    private Instant createTime;

    public Instant getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Instant createTime) {
        this.createTime = createTime;
    }

    public User getColOwner() {
        return colOwner;
    }

    public void setColOwner(User colOwner) {
        this.colOwner = colOwner;
    }

    public Integer getIdentity() {
        return identity;
    }

    public void setIdentity(Integer identity) {
        this.identity = identity;
    }

    public String getCollectionName() {
        return collectionName;
    }

    public void setCollectionName(String collectionName) {
        this.collectionName = collectionName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}