package shhouse.domain;

import java.util.*;
import lombok.*;
import shhouse.domain.*;
import shhouse.infra.AbstractEvent;

@Data
@ToString
public class SubscriptionDrawn extends AbstractEvent {

    private Long id;
    private String applyName;
    private String phoneNumber;
    private String email;
    private Object winningStatus;
    private String house;
    private String location;
}
