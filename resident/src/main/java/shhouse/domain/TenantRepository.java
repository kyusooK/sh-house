package shhouse.domain;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import shhouse.domain.*;

//<<< PoEAA / Repository
@RepositoryRestResource(collectionResourceRel = "tenants", path = "tenants")
public interface TenantRepository
    extends PagingAndSortingRepository<Tenant, Long> {}
