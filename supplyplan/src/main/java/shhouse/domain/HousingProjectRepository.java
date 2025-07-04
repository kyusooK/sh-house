package shhouse.domain;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import shhouse.domain.*;

//<<< PoEAA / Repository
@RepositoryRestResource(
    collectionResourceRel = "housingProjects",
    path = "housingProjects"
)
public interface HousingProjectRepository
    extends PagingAndSortingRepository<HousingProject, Long> {}
