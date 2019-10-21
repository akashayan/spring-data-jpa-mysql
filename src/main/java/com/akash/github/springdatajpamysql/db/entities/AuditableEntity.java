package com.akash.github.springdatajpamysql.db.entities;

import com.akash.github.springdatajpamysql.utils.DateUtil;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

@MappedSuperclass
@Getter
@Setter
public abstract class AuditableEntity extends BaseEntity {

    @Column(name = "created_at")
    private String createdAt;

    @Column(name = "updated_at")
    private String updatedAt;

    @PrePersist
    public void onPersist() {
        setCreatedAt(DateUtil.now());
    }

    @PreUpdate
    public void onUpdate() {
        setUpdatedAt(DateUtil.now());
    }
}
