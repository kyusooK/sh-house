package shhouse.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import shhouse.domain.*;
import shhouse.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class SupplyPlanApproved extends AbstractEvent {

    private Long id;
    private HousingProjectId housingProjectId;
    private String houseName;
    private String houseLocation;
    private SupplyStatus supplyStatus;

    public SupplyPlanApproved(HouseSupply aggregate) {
        super(aggregate);
    }

    public SupplyPlanApproved() {
        super();
    }
}
//>>> DDD / Domain Event
