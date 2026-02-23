package com.recetas.recetasapi.controller;

import com.recetas.recetasapi.entity.Step;
import com.recetas.recetasapi.service.StepService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/steps")
public class StepController {

    private final StepService stepService;

    public StepController(StepService stepService) {
        this.stepService = stepService;
    }

    @GetMapping
    public ResponseEntity<List<Step>> getAllSteps() {
        List<Step> steps = stepService.findAll();
        return ResponseEntity.ok(steps);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Step> getStepById(@PathVariable Long id) {
        return stepService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Step> createStep(@Valid @RequestBody Step step) {
        Step savedStep = stepService.save(step);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedStep);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Step> updateStep(@PathVariable Long id, @Valid @RequestBody Step step) {
        if (!stepService.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        step.setId(id);
        Step updateStep = stepService.save(step);
        return ResponseEntity.ok(updateStep);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStep(@PathVariable Long id) {
        if (!stepService.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        stepService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
