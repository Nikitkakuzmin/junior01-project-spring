package kz.kuzmin.glavnaya.glavnaya.Service;

import kz.kuzmin.glavnaya.glavnaya.Model.Country;
import kz.kuzmin.glavnaya.glavnaya.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class CountryService {

    @Autowired
    private CountryRepository countryRepository;
    public List<Country> GetCountries(){
        return countryRepository.findAll();

    }

    public Country getCountry(Long id){
        return countryRepository.findById(id).orElseThrow();

    }
}
