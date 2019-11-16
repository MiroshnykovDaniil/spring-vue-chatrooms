package com.donationalerts.youtubeparser.Controller;

import com.donationalerts.youtubeparser.entity.City;
import com.donationalerts.youtubeparser.exception.CityNotFoundException;
import com.donationalerts.youtubeparser.repository.CityRepository;
import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Slf4j
@RestController
public class CityController {

    private CityRepository repository;

    public CityController(CityRepository repository) {
        this.repository = repository;
    }


    @GetMapping("/response")
    public String response(){
        return "response";
    }

    @GetMapping("/all")
    public List<City>cities(){
        log.error("/all");
        return (List)repository.findAll();
    }

    @PostMapping("/add")
    public City addCity(@RequestBody City newCity){
        log.error("/add "+newCity);
        return repository.save(newCity);
    }

    @GetMapping("/cities/{id}")
    City one(@PathVariable Long id) {
        log.error("cities/id"+id);
        return repository.findById(id)
                .orElseThrow(() -> new CityNotFoundException(id));
    }

    @DeleteMapping("/cites/{id}")
    void deleteCity(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
