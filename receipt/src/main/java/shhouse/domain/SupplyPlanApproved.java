package shhouse.domain;

import java.util.*;
import lombok.*;
import shhouse.domain.*;
import shhouse.infra.AbstractEvent;

@Data
@ToString
public class SupplyPlanApproved extends AbstractEvent {

    private Long id;
    private Object housingProjectId;
    private String houseName;
    private String houseLocation;
    private Object supplyStatus;
}
