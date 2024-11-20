package kz.kuzmin.glavnaya.glavnaya.repository;

import jakarta.transaction.Transactional;
import kz.kuzmin.glavnaya.glavnaya.Model.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface CountryRepository extends JpaRepository<Country, Long> {


}
