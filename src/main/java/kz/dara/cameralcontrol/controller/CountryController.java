package kz.dara.cameralcontrol.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import kz.dara.cameralcontrol.model.Country;
import kz.dara.cameralcontrol.model.Project;
import kz.dara.cameralcontrol.repository.secondaryDataSourse.CountryRepository;
import kz.dara.cameralcontrol.service.CountryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/country", produces = APPLICATION_JSON_VALUE)
@Tag(name = "country", description = "Country management resource")
public class CountryController {

    @Autowired
    private CountryService countryService;

    @PostMapping
    public Country createCountry(@RequestBody Country Country) {
        return countryService.createCountry(Country);
    }

    @GetMapping
    public List<Country> getAllCountrys() {
        return countryService.getAllCountries();
    }

    @PutMapping
    public Country updateCountry(@RequestBody Country Country) {
        return countryService.updateCountry(Country);
    }

    @DeleteMapping("/{id}")
    public void deleteCountry(@PathVariable Long id) {
        countryService.deleteCountry(id);
    }
}
