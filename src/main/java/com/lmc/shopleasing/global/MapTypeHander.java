package com.lmc.shopleasing.global;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

public class MapTypeHander extends BaseTypeHandler<Map<String,String>> {

    AttributeConverter attributeConverter  = new AttributeConverter();

    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, Map<String, String> map, JdbcType jdbcType) throws SQLException {
        ps.setString(i, attributeConverter.convertToDatabaseColumn(map));
    }

    @Override
    public Map<String, String> getNullableResult(ResultSet resultSet, String columnName) throws SQLException {
        return (Map<String, String>) attributeConverter.convertToEntityAttribute( resultSet.getString(columnName));
    }

    @Override
    public Map<String, String> getNullableResult(ResultSet resultSet, int i) throws SQLException {
        return (Map<String, String>)attributeConverter.convertToEntityAttribute( resultSet.getString(i));
    }

    @Override
    public Map<String, String> getNullableResult(CallableStatement callableStatement, int i) throws SQLException {
        return (Map<String, String>)attributeConverter.convertToEntityAttribute(callableStatement.getString(i));
    }

    public static class AttributeConverter extends BaseAttributeConverter<Map<String, String>> {
	}

}
