package com.music.manage.Model;

import javax.persistence.*;
import java.time.Instant;

@Table(name = "warehouse", indexes = {
        @Index(name = "w_owner_id", columnList = "w_owner_id")
})
@Entity
public class Warehouse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "warehouse_id", nullable = false)
    private Integer id;

    @Column(name = "warehouse_name")
    private String warehouseName;

    @ManyToOne(optional = false)
    @JoinColumn(name = "w_owner_id", nullable = false)
    private User wOwner;

    @Column(name = "create_time", nullable = false)
    private Instant createTime;

    public Instant getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Instant createTime) {
        this.createTime = createTime;
    }

    public User getWOwner() {
        return wOwner;
    }

    public void setWOwner(User wOwner) {
        this.wOwner = wOwner;
    }

    public String getWarehouseName() {
        return warehouseName;
    }

    public void setWarehouseName(String warehouseName) {
        this.warehouseName = warehouseName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}