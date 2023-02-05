package kz.dara.cameralcontrol.repository.secondaryDataSourse;

import kz.dara.cameralcontrol.model.Country;
import kz.dara.cameralcontrol.model.Project;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface CountryRepository extends PagingAndSortingRepository<Country, Long> {

}
