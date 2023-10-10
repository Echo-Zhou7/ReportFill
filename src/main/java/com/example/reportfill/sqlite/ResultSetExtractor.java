package com.example.reportfill.sqlite;

/**
 * @Author EchoZhou
 * @Description TODO
 * @Date 2023/10/10 19:35
 * @Version 1.0
 */
import java.sql.ResultSet;
import java.sql.SQLException;

public interface ResultSetExtractor<T> {

    public abstract T extractData(ResultSet rs) throws SQLException;

}

