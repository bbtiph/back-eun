package kz.dara.cameralcontrol.service;

import kz.dara.cameralcontrol.model.Country;
import kz.dara.cameralcontrol.repository.secondaryDataSourse.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryService {
    @Autowired
    private CountryRepository countryRepository;

    public Country createCountry(Country Country) {
        return countryRepository.save(Country);
    }

    public Country getCountry(Long id) {
        return countryRepository.findById(id).orElse(null);
    }

    public List<Country> getAllCountries() {
        return (List<Country>) countryRepository.findAll();
    }

    public Country updateCountry(Country Country) {
        return countryRepository.save(Country);
    }

    public void deleteCountry(Long id) {
        countryRepository.deleteById(id);
    }
}

