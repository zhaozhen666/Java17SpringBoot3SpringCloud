package com.zhao.sbsc17.handler;

import com.baomidou.mybatisplus.extension.plugins.handler.TenantLineHandler;
import com.zhao.sbsc17.config.property.TenantProperty;
import net.sf.jsqlparser.expression.Expression;
import net.sf.jsqlparser.expression.LongValue;
import net.sf.jsqlparser.expression.StringValue;
import net.sf.jsqlparser.schema.Column;

import java.util.List;

public class MultiTenantLineHandler implements TenantLineHandler {

    private TenantProperty tenantProperty;

    public MultiTenantLineHandler(TenantProperty tenantProperty){
        this.tenantProperty =tenantProperty;
    }
    @Override
    public Expression getTenantId() {
        return new StringValue("zhao");
    }

    @Override
    public String getTenantIdColumn() {
        return tenantProperty.getTenantColumn();
    }

    @Override
    public boolean ignoreTable(String tableName) {
        List<String> ignoreTables = tenantProperty.getIgnoreTables();
        if (ignoreTables.contains(tableName)){
            return true;
        }
        return false;
    }
//
//    @Override
//    public boolean ignoreInsert(List<Column> columns, String tenantIdColumn) {
//        return TenantLineHandler.super.ignoreInsert(columns, tenantIdColumn);
//    }
}
