package shhouse.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import shhouse.domain.*;
import shhouse.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class Contracted extends AbstractEvent {

    private Long id;
    private String title;
    private String content;
    private Date contractAt;
    private Date contractEndAt;
    private String name;
    private String phoneNumber;
    private String houseName;
    private String houseLocation;

    public Contracted(Contract aggregate) {
        super(aggregate);
    }

    public Contracted() {
        super();
    }
}
//>>> DDD / Domain Event
