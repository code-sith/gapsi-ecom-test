package com.gapsi.ecom.dto;

import lombok.Builder;
import lombok.Getter;

import java.util.Date;

@Getter
@Builder
public class Provider {

    private Long id;
    private String name;
    private String address;
    private String companyName;
    private Date created;
    private String createdBy;
    private Date updated;
    private String updatedBy;
}
