package com.example.demo15.postoffice;


import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/post-offices")
public class PostOfficeController {
    private final PostOfficeService postOfficeService;
    @GetMapping
    public List<PostOffice> getAllPostOffices() {
        return postOfficeService.findAll();
    }

    @PostMapping("/{departureId}")
    public ResponseEntity<PostOffice> createDeparture(@PathVariable Long departureId, @RequestBody PostOffice postOffice) {
        return postOfficeService.save(departureId, postOffice);
    }

    @DeleteMapping("/{id}")
    public void deletePostOffice(@PathVariable Long id) {
        postOfficeService.deleteById(id);
    }


    @GetMapping("/filter")
    public List<PostOffice> filterPostOffices(@RequestParam(required = false) String name,
                                              @RequestParam(required = false) String cityName) {
        return postOfficeService.filterPostOffices(name, cityName);
    }



    @GetMapping("/{id}")
    public PostOffice getDepartureById(@PathVariable Long id) {
        return postOfficeService.findById(id);
    }

}