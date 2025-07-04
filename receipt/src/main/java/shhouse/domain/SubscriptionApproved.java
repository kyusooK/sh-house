package shhouse.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import shhouse.domain.*;
import shhouse.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class SubscriptionApproved extends AbstractEvent {

    private Long id;
    private String recipientName;
    private String houseName;
    private String houseLocation;
    private String documentFile;
    private ApplyStatus applyStatus;
    private String phoneNumber;
    private String email;

    public SubscriptionApproved(Subscription aggregate) {
        super(aggregate);
    }

    public SubscriptionApproved() {
        super();
    }
}
//>>> DDD / Domain Event
