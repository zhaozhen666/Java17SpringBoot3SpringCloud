package com.zhao.sbsc17.controller;


import com.baomidou.dynamic.datasource.annotation.DS;
import com.zhao.sbsc17.dao.ShardingMapper;
import com.zhao.sbsc17.dao.TenantMapper;
import com.zhao.sbsc17.entity.Product;
import com.zhao.sbsc17.entity.Sharding;
import com.zhao.sbsc17.entity.Tenant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("tenant")
public class TenantController {

    @Autowired
    ShardingMapper shardingMapper;
    @Autowired
    TenantMapper tenantMapper;


    private static final  String tenant_id ="zhao";
    @GetMapping("tenant")
    @DS("master")
    public Tenant master(){
        return tenantMapper.selectById(1L);
    }

    @GetMapping("sharding")
    @DS("master")
    public Sharding sharding(){
        return shardingMapper.selectById(1L);
    }


    @GetMapping("tenant_insert")
    @DS("master")
    public Tenant tenant_insert(){
        Tenant tenant = new Tenant();
        tenant.setId(2L);
        tenant.setGoodsName("测试");
        tenant.setNum(Long.valueOf(1));
        tenant.setVersion(1);
//        tenant.setTenantId(tenant_id);
        tenantMapper.insert(tenant);
        return tenant;
    }

    @GetMapping("sharding_insert")
    @DS("master")
    public Sharding sharding_insert(){
        Sharding sharding = new Sharding();
        sharding.setId(2L);
        sharding.setGoodsName("测试");
        sharding.setNum(Long.valueOf(1));
        sharding.setVersion(1);
        shardingMapper.insert(sharding);
        return sharding;
    }
}
