package com.gapsi.ecom.controller.v1;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/version")
@CrossOrigin(origins = "http://localhost:3000")
public class VersionController {

    @Value("${build.version}")
    private String buildVersion;

    @GetMapping
    public String getBuildVersion(){
        return buildVersion;
    }
}
