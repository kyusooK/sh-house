package shhouse.domain;

import java.util.*;
import lombok.*;
import shhouse.domain.*;
import shhouse.infra.AbstractEvent;

@Data
@ToString
public class SubscriptionApproved extends AbstractEvent {

    private Long id;
    private String recipientName;
    private String houseName;
    private String houseLocation;
    private String documentFile;
    private Object applyStatus;
    private String phoneNumber;
    private String email;
}
