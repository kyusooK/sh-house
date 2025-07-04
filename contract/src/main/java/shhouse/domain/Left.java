package shhouse.domain;

import java.util.*;
import lombok.*;
import shhouse.domain.*;
import shhouse.infra.AbstractEvent;

@Data
@ToString
public class Left extends AbstractEvent {

    private Long id;
    private String houseName;
    private String houseLocation;
    private String tenantName;
    private String tenantPhone;
    private Boolean isLeaving;
}
