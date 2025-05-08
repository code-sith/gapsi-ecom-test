package com.gapsi.ecom.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class User {

    private Long userId;
    private String fullName;
}
