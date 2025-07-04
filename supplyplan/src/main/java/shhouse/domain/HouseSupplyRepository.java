package shhouse.domain;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import shhouse.domain.*;

//<<< PoEAA / Repository
@RepositoryRestResource(
    collectionResourceRel = "houseSupplies",
    path = "houseSupplies"
)
public interface HouseSupplyRepository
    extends PagingAndSortingRepository<HouseSupply, Long> {}
