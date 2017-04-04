package com.edutilos.main1;


import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class WorkerJdbcTemplate implements  WorkerDAO{
    private JdbcTemplate template;



    public WorkerJdbcTemplate(JdbcTemplate template) {
        this.template = template;
    }


    public void dropTable() {
        String sql = "drop table if exists SpringWorker";
        template.update(sql);
    }

    public void createTable() {
        String sql = "create table if not exists SpringWorker (" +
                "id bigint primary key , " +
                "name varchar(50) not null, " +
                "age int not null, " +
                "wage double not null" +
                ")";
        template.update(sql);
    }

    @Override
    public void save(Worker worker) {
        String sql = "insert into SpringWorker (id, name, age, wage) values(?, ?, ?, ?)";
       template.update(sql , worker.getId(), worker.getName(), worker.getAge(), worker.getWage());
    }

    @Override
    public void update(long id, Worker newW) {
       String sql = "update SpringWorker set name = ? , age = ?, wage = ? where id = ?";
        template.update(sql, newW.getName(), newW.getAge(), newW.getWage(), id);
    }

    @Override
    public void remove(long id) {
     String sql = "delete from SpringWorker where id = ?";
        template.update(sql , id);
    }

    @Override
    public Worker findById(long id) {
        Worker w ;
        String sql = "select * from SpringWorker where id = ?";
        w = template.queryForObject(sql, new Object[]{id}, new WorkerMapper());
        return w ;
    }

    @Override
    public List<Worker> findAll() {
        String sql = "select * from SpringWorker";
        List<Worker> list = template.query(sql, new WorkerMapper());
        return list;
    }
}
