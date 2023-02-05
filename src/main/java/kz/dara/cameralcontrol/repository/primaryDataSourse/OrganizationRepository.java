package kz.dara.cameralcontrol.repository.primaryDataSourse;

import kz.dara.cameralcontrol.model.Organization;
import kz.dara.cameralcontrol.model.Project;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface OrganizationRepository extends PagingAndSortingRepository<Organization, Long> {

}
