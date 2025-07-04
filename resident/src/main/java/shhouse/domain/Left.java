package shhouse.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import shhouse.domain.*;
import shhouse.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class Left extends AbstractEvent {

    private Long id;
    private String houseName;
    private String houseLocation;
    private String tenantName;
    private String tenantPhone;
    private Boolean isLeaving;

    public Left(Tenant aggregate) {
        super(aggregate);
    }

    public Left() {
        super();
    }
}
//>>> DDD / Domain Event
