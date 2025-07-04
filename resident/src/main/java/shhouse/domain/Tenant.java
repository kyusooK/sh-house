package shhouse.domain;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.time.LocalDate;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.persistence.*;
import lombok.Data;
import shhouse.ResidentApplication;
import shhouse.domain.TenantRegistered;

@Entity
@Table(name = "Tenant_table")
@Data
//<<< DDD / Aggregate Root
public class Tenant {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String houseName;

    private String houseLocation;

    private String tenantName;

    private String tenantPhone;

    private Date contractStartAt;

    private Date contractEndAt;

    private Boolean isMoveIn;

    private Boolean isLeaving;

    public static TenantRepository repository() {
        TenantRepository tenantRepository = ResidentApplication.applicationContext.getBean(
            TenantRepository.class
        );
        return tenantRepository;
    }

    public void moveIn() {
        repository().findById(this.getId()).ifPresent(tenant -> {
            tenant.setIsMoveIn(true);
            repository().save(tenant);
        });
    }

    public void leave() {
        repository().findById(this.getId()).ifPresent(tenant -> {
            tenant.setIsLeaving(true);
            repository().save(tenant);

            Left left = new Left(tenant);
            left.publishAfterCommit();
        });
    }

    public static void registerTenant(Contracted contracted) {
        Tenant tenant = new Tenant();
        tenant.setHouseName(contracted.getHouseName());
        tenant.setHouseLocation(contracted.getHouseLocation());
        tenant.setTenantName(contracted.getName());
        tenant.setTenantPhone(contracted.getPhoneNumber());
        tenant.setContractStartAt(contracted.getContractAt());
        tenant.setContractEndAt(contracted.getContractEndAt());
        repository().save(tenant);

        TenantRegistered tenantRegistered = new TenantRegistered(tenant);
        tenantRegistered.publishAfterCommit();

    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public static void updateMoveIn(ExtendApproved extendApproved) {
        //implement business logic here:

        /** Example 1:  new item 
        Tenant tenant = new Tenant();
        repository().save(tenant);

        */

        /** Example 2:  finding and process
        
        // if extendApproved.contractIdtenantId exists, use it
        
        // ObjectMapper mapper = new ObjectMapper();
        // Map<Long, Object> extendContractMap = mapper.convertValue(extendApproved.getContractId(), Map.class);
        // Map<Long, Object> extendContractMap = mapper.convertValue(extendApproved.getTenantId(), Map.class);

        repository().findById(extendApproved.get???()).ifPresent(tenant->{
            
            tenant // do something
            repository().save(tenant);


         });
        */

    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
