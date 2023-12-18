package com.zhao.sbsc17.dao;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zhao.sbsc17.entity.Product;
import com.zhao.sbsc17.entity.Sharding;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ShardingMapper extends BaseMapper<Sharding> {
}
