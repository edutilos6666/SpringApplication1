package com.edutilos.main1;

import javax.activation.DataSource;
import java.util.List;

/**
 * Created by edutilos on 04/04/2017.
 */
public interface WorkerDAO {
    //void setJdbcTemplate(DataSource ds);
   void save(Worker worker);
    void update(long id, Worker newW);
    void remove(long id);
    Worker findById(long id);
    List<Worker> findAll();
}
