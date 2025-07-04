package shhouse.domain;

import java.util.*;
import lombok.*;
import shhouse.domain.*;
import shhouse.infra.AbstractEvent;

@Data
@ToString
public class ExtendDisApproved extends AbstractEvent {

    private Long id;
    private Object contractId;
    private Object tenantId;
    private Boolean isExtend;
}
