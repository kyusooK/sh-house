package shhouse.domain;

import java.util.Date;
import java.util.List;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import shhouse.domain.*;

//<<< PoEAA / Repository
@RepositoryRestResource(collectionResourceRel = "winners", path = "winners")
public interface WinnerRepository
    extends PagingAndSortingRepository<Winner, Long> {}
