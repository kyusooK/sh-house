package shhouse.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import shhouse.domain.*;
import shhouse.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class TenantRegistered extends AbstractEvent {

    private Long id;
    private String houseName;
    private String houseLocation;
    private String tenantName;
    private String tenantPhone;
    private Date contractStartAt;
    private Date contractEndAt;
    private Boolean isMoveIn;
    private Boolean isLeaving;

    public TenantRegistered(Tenant aggregate) {
        super(aggregate);
    }

    public TenantRegistered() {
        super();
    }
}
//>>> DDD / Domain Event
