package com.zhao.sbsc17.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.Version;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@TableName(value = "sharding")
public class Sharding {
    @TableId(value = "id",type = IdType.AUTO)
    private Long id;
    private Long goodsId;
    private String goodsName;
    private Long num;
    @Version
    private Integer version;
}
