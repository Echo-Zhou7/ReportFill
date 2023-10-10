package com.example.reportfill.sqlite;

/**
 * @Author EchoZhou
 * @Description TODO
 * @Date 2023/10/10 19:35
 * @Version 1.0
 */
import java.sql.ResultSet;
import java.sql.SQLException;

public interface RowMapper<T> {
    public abstract T mapRow(ResultSet rs, int index) throws SQLException;
}

