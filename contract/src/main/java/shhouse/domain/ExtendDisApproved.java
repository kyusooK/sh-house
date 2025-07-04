package shhouse.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import shhouse.domain.*;
import shhouse.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class ExtendDisApproved extends AbstractEvent {

    private Long id;
    private ContractId contractId;
    private TenantId tenantId;
    private Boolean isExtend;

    public ExtendDisApproved(ExtendContract aggregate) {
        super(aggregate);
    }

    public ExtendDisApproved() {
        super();
    }
}
//>>> DDD / Domain Event
