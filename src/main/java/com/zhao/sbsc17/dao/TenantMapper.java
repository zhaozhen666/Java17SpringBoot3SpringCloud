package com.zhao.sbsc17.dao;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zhao.sbsc17.entity.Product;
import com.zhao.sbsc17.entity.Tenant;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TenantMapper extends BaseMapper<Tenant> {
}
