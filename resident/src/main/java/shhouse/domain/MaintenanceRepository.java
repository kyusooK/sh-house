package shhouse.domain;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import shhouse.domain.*;

//<<< PoEAA / Repository
@RepositoryRestResource(
    collectionResourceRel = "maintenances",
    path = "maintenances"
)
public interface MaintenanceRepository
    extends PagingAndSortingRepository<Maintenance, Long> {}
