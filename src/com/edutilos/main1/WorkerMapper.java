package com.edutilos.main1;


import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class WorkerMapper  implements RowMapper<Worker>{
    @Override
    public Worker mapRow(ResultSet resultSet, int i) throws SQLException {
        Worker w = new Worker();
        w.setId(resultSet.getLong("id"));
        w.setName(resultSet.getString("name"));
        w.setAge(resultSet.getInt("age"));
        w.setWage(resultSet.getDouble("wage"));
        return w;
    }
}
