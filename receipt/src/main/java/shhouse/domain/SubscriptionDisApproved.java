package shhouse.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import shhouse.domain.*;
import shhouse.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class SubscriptionDisApproved extends AbstractEvent {

    private Long id;
    private String recipientName;
    private String documentFile;
    private ApplyStatus applyStatus;
    private String phoneNumber;
    private String email;

    public SubscriptionDisApproved(Subscription aggregate) {
        super(aggregate);
    }

    public SubscriptionDisApproved() {
        super();
    }
}
//>>> DDD / Domain Event
