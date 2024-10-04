package ru.innopolis.java.tvapp.controller;

import ru.innopolis.java.tvapp.model.TV;
import ru.innopolis.java.tvapp.service.TVService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tv")
public class TVController {

    private final TVService tvService;

    @Autowired
    public TVController(TVService tvService) {
        this.tvService = tvService;
    }

    @PostMapping
    public ResponseEntity<TV> createTV(@RequestBody TV tv) {
        TV createdTV = tvService.createTV(tv);
        return new ResponseEntity<>(createdTV, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TV> updateTV(@PathVariable Long id, @RequestBody TV tv) {
        tv.setId(id);
        TV updatedTV = tvService.updateTV(tv);
        return ResponseEntity.ok(updatedTV);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTV(@PathVariable Long id) {
        tvService.deleteTV(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<TV> getTVById(@PathVariable Long id) {
        TV tv = tvService.getTVById(id);
        return ResponseEntity.ok(tv);
    }

    @GetMapping
    public ResponseEntity<List<TV>> getAllTVs() {
        List<TV> tvs = tvService.getAllTVs();
        return ResponseEntity.ok(tvs);
    }
}
