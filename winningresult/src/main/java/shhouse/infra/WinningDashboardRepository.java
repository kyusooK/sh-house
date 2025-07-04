package shhouse.infra;

import java.util.List;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import shhouse.domain.*;

@RepositoryRestResource(
    collectionResourceRel = "winningDashboards",
    path = "winningDashboards"
)
public interface WinningDashboardRepository
    extends PagingAndSortingRepository<WinningDashboard, Long> {}
