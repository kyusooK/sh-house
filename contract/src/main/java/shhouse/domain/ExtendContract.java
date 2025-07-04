package shhouse.domain;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.time.LocalDate;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.persistence.*;
import lombok.Data;
import shhouse.ContractApplication;

@Entity
@Table(name = "ExtendContract_table")
@Data
//<<< DDD / Aggregate Root
public class ExtendContract {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String document;

    private Date extendEndAt;

    private Boolean isExtend;

    @Embedded
    private ContractId contractId;

    @Embedded
    private TenantId tenantId;

    public static ExtendContractRepository repository() {
        ExtendContractRepository extendContractRepository = ContractApplication.applicationContext.getBean(
            ExtendContractRepository.class
        );
        return extendContractRepository;
    }

    //<<< Clean Arch / Port Method
    public void checkContract() {
        //implement business logic here:

        ExtendApproved extendApproved = new ExtendApproved(this);
        extendApproved.publishAfterCommit();
        ExtendDisApproved extendDisApproved = new ExtendDisApproved(this);
        extendDisApproved.publishAfterCommit();
    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
