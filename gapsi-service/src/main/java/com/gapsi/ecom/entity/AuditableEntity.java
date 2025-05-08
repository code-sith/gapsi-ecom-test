package com.gapsi.ecom.entity;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class AuditableEntity {

    @CreatedDate
    @Column(name = "created_date")
    private Date created;
    @CreatedBy
    @Column(name = "created_by")
    private String createdBy;
    @LastModifiedDate
    @Column(name = "updated_date")
    private Date updated;
    @LastModifiedBy
    @Column(name = "updated_by")
    private String updatedBy;
}
