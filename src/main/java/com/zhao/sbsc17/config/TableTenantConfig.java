package com.zhao.sbsc17.config;

import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.handler.TableNameHandler;
import com.baomidou.mybatisplus.extension.plugins.inner.DynamicTableNameInnerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.OptimisticLockerInnerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.TenantLineInnerInterceptor;
import com.zhao.sbsc17.config.property.TenantProperty;
import com.zhao.sbsc17.handler.MultiTenantLineHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;

@Configuration
public class TableTenantConfig {
//    @Bean
//    public MybatisPlusInterceptor mybatisPlusInterceptor(){
//        MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
//        interceptor.addInnerInterceptor(new OptimisticLockerInnerInterceptor());
//        return interceptor;
//    }
    private static final String tenant_id = "zhao";
    @Autowired
    TenantProperty tenantProperty;
    @Bean
    public MybatisPlusInterceptor mybatisPlusInterceptor(){
        MybatisPlusInterceptor interceptor =new MybatisPlusInterceptor();
        interceptor.addInnerInterceptor(new OptimisticLockerInnerInterceptor());
        interceptor.addInnerInterceptor(new TenantLineInnerInterceptor(new MultiTenantLineHandler(tenantProperty)));
        DynamicTableNameInnerInterceptor dynamicTableNameInnerInterceptor= new DynamicTableNameInnerInterceptor();
        TableNameHandler tableNameHandler = new TableNameHandler() {
            @Override
            public String dynamicTableName(String sql, String tableName) {
                if (tenantProperty.getShardingTables().contains(tableName)){
                    return tableName+"_"+tenant_id;
                }
                return tableName;
            }
        };
        dynamicTableNameInnerInterceptor.setTableNameHandler(tableNameHandler);
        interceptor.addInnerInterceptor(dynamicTableNameInnerInterceptor);

        return interceptor;
    }
}
