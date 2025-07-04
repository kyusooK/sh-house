package shhouse.infra;

import java.util.List;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import shhouse.domain.*;

@RepositoryRestResource(
    collectionResourceRel = "contractDashboards",
    path = "contractDashboards"
)
public interface ContractDashboardRepository
    extends PagingAndSortingRepository<ContractDashboard, Long> {}
