package com.jetbrains.FitnessApplication.run;

import jakarta.annotation.PostConstruct;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.management.InstanceNotFoundException;
import java.util.List;

@RestController
@RequestMapping("/api/runs")
public class RunController {
    private final RunRepository runRepository;

    public RunController(RunRepository runRepository) {
        this.runRepository = runRepository;
    }

    @GetMapping("")
    public List<Run> findAll() {
        return runRepository.findAll();
    }

    //GET
    @GetMapping("/{id}")
    Run findById(@PathVariable Integer id) {
        if (runRepository.findById(id).isPresent()) {
            return runRepository.findById(id).get();
        } else {
            throw new RunNotFoundException();
        }
    }

    //POST
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    void create(@Valid @RequestBody Run run) {
        runRepository.create(run);
    }

    //PUT
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void update(@RequestBody Run run, Integer id) {
        runRepository.update(run, id);
    }
    //DELETE
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void update(Integer id) {
        runRepository.delete(id);
    }

}
