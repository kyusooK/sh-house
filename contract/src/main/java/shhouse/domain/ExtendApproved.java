package shhouse.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import shhouse.domain.*;
import shhouse.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class ExtendApproved extends AbstractEvent {

    private Long id;
    private ContractId contractId;
    private TenantId tenantId;
    private String document;
    private Date extendEndAt;
    private Boolean isExtend;

    public ExtendApproved(ExtendContract aggregate) {
        super(aggregate);
    }

    public ExtendApproved() {
        super();
    }
}
//>>> DDD / Domain Event
