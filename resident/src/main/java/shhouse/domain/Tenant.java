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

    //<<< Clean Arch / Port Method
    public void moveIn() {
        //implement business logic here:

    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public void leave() {
        //implement business logic here:

        Left left = new Left(this);
        left.publishAfterCommit();
    }

    //>>> Clean Arch / Port Method

    //<<< Clean Arch / Port Method
    public static void registerTenant(Contracted contracted) {
        //implement business logic here:

        /** Example 1:  new item 
        Tenant tenant = new Tenant();
        repository().save(tenant);

        TenantRegistered tenantRegistered = new TenantRegistered(tenant);
        tenantRegistered.publishAfterCommit();
        */

        /** Example 2:  finding and process
        

        repository().findById(contracted.get???()).ifPresent(tenant->{
            
            tenant // do something
            repository().save(tenant);

            TenantRegistered tenantRegistered = new TenantRegistered(tenant);
            tenantRegistered.publishAfterCommit();

         });
        */

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
