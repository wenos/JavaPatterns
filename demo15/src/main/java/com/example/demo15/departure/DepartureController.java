package com.example.demo15.departure;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/departures")
public class DepartureController {
    private final DepartureService departureService;
    @Autowired
    private final DepartureRepository departureRepository;

    @GetMapping
    public List<Departure> getAllDepartures() {
        return departureService.findAll();
    }

    @PostMapping
    public ResponseEntity<Departure> createDeparture(@RequestBody Departure departure) {
        return ResponseEntity.ok(departureService.save(departure));
    }

    @DeleteMapping("/{id}")
    public void deleteDeparture(@PathVariable Long id) {
        departureService.deleteById(id);
    }

    @GetMapping("/{id}")
    public Departure getDepartureById(@PathVariable Long id) {
        return departureService.findById(id);
    }

    @GetMapping("/filter")
    public List<Departure> filterDepartures(@RequestParam(required = false) String type,
                                            @RequestParam(required = false) String departureDate) {
        return departureService.filterDepartures(type, departureDate);
    }


}