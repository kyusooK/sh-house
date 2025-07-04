package shhouse.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import shhouse.domain.*;
import shhouse.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class SubscriptionDrawn extends AbstractEvent {

    private Long id;
    private String applyName;
    private String phoneNumber;
    private String email;
    private WinningStatus winningStatus;
    private String house;
    private String location;

    public SubscriptionDrawn(Winner aggregate) {
        super(aggregate);
    }

    public SubscriptionDrawn() {
        super();
    }
}
//>>> DDD / Domain Event
