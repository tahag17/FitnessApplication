package com.jetbrains.FitnessApplication.run;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Optional;

@Repository
public class JdbcClientRunRepository {
    private static final Logger logger = LoggerFactory.getLogger(JdbcClientRunRepository.class);
    private final JdbcClient jdbcClient;

    public JdbcClientRunRepository(JdbcClient jdbcClient) {
        this.jdbcClient = jdbcClient;
    }

    public List<Run> findAll() {
        return jdbcClient.sql("SELECT * FROM Run")
                .query(Run.class)
                .list();
    }

    public Optional<Run> findById(Integer id){
        return jdbcClient.sql("SELECT * FROM Run WHERE id = :id")
                .param("id",id)
                .query(Run.class)
                .optional();
    }
    public void create(Run run) {
        var numberOfRowsAffected = jdbcClient.sql("INSERT INTO Run(id,name,start,finish,location,miles) values(?,?,?,?,?,?)")
                .params(List.of(run.id(), run.name(), run.start(), run.finish(), run.location().toString(), run.miles()))
                .update();
        Assert.state(numberOfRowsAffected == 1, "failed to create run " + run.name());
    }

    public void update(Run run, Integer id) {
        var numberOfRowsAffected = jdbcClient.sql("UPDATE Run SET name = ?, start = ?, finish = ?, location = ?, miles = ? WHERE id = ?")
                .params(List.of(run.name(), run.start(), run.finish(), run.location().toString(), run.miles(), id))
                .update();
        Assert.state(numberOfRowsAffected == 1, "failed to update run " + run.name());
    }

    public void delete(Integer id) {
        var numberOfRowsAffected = jdbcClient.sql("DELETE FROM Run WHERE id = :id")
                .param("id", id)
                .update();
        Assert.state(numberOfRowsAffected == 1, "failed to delete run " + id);
    }

    public int count() {
        return jdbcClient.sql("SELECT * FROM Run").query().listOfRows().size();
    }

    public void saveAll(List<Run> runs) {
        runs.stream().forEach(this::create);
    }

    public List<Run> findByLocation(String location) {
        return jdbcClient.sql("SELECT * FROM Run WHERE location =:location")
                .param("location", location)
                .query(Run.class)
                .list();
    }
}

