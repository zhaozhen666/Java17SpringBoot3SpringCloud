package com.zhao.sbsc17.config.property;


import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Data
@Configuration
@ConfigurationProperties(prefix = "tenant")
public class TenantProperty {

    private Boolean enable =true;

    private String tenantColumn="tenant_id";

    private List<String> ignoreTables;

    private List<String> shardingTables;



}
