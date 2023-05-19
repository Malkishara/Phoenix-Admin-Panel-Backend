package com.oxcentra.phoenix.adminpanel.controller;

import com.oxcentra.phoenix.adminpanel.dto.Vacancy;
import com.oxcentra.phoenix.adminpanel.dto.VacancyDto;
import com.oxcentra.phoenix.adminpanel.model.Admin;
import com.oxcentra.phoenix.adminpanel.service.VacancyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Slf4j
@RestController
public class VacancyController {
    @Autowired
    private VacancyService vacancyService;


    @CrossOrigin(origins = {"http://localhost:4200","http://localhost:3000"})
    @GetMapping("/vacancy")
    public @ResponseBody
    List<Vacancy> getVacancies()  {
        return vacancyService.getAllVacancy();
    }

    @CrossOrigin(origins = {"http://localhost:4200","http://localhost:3000"})
    @GetMapping("/vacancy/{id}")
    public @ResponseBody
    Optional<Vacancy> getVacancyById(@PathVariable Integer id)  {
        log.info(String.valueOf(id));
        //int vacancyId=Integer.parseInt(id);
        return vacancyService.getVacancyById(id);
    }

    @CrossOrigin(origins = {"http://localhost:4200","http://localhost:3000"})
    @DeleteMapping("/vacancy/{id}")
    public @ResponseBody
    Boolean deleteVacancyById(@PathVariable Integer id) {
        log.info(String.valueOf(id));
        return vacancyService.deleteVacancyById(id);
    }

    @CrossOrigin(origins = {"http://localhost:4200","http://localhost:3000"})
    @PutMapping("/vacancy/{id}")
    public @ResponseBody
    Boolean updateVacancy(@RequestBody VacancyDto vacancy) {

        log.info(String.valueOf(vacancy.getId()));
        return vacancyService.updateVacancy(vacancy);
    }

    @CrossOrigin(origins = {"http://localhost:4200","http://localhost:3000"})
    @GetMapping("/vacancies/{id}")
    public @ResponseBody
    List<Vacancy> getVacanciesByEmployerId(@PathVariable Integer id)  {
        return vacancyService.getVacanciesByEmployerId(id);
    }

    @CrossOrigin(origins = {"http://localhost:4200","http://localhost:3000"})
    @PostMapping("/vacancy")
    public @ResponseBody
    Boolean addVacancy(@RequestBody VacancyDto vacancy) {

        log.info(String.valueOf(vacancy));
        return vacancyService.addVacancy(vacancy);
    }

    @CrossOrigin(origins = {"http://localhost:4200","http://localhost:3000"})
    @PostMapping("/vacancy/title")
    public @ResponseBody List<Vacancy> searchVacancy(@RequestBody Map<String, String> requestData) {
        String title = requestData.get("title");
        log.info(title);
        return vacancyService.searchVacancy(title);
    }
}
