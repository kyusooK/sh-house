package shhouse.domain;

import java.util.*;
import lombok.*;
import shhouse.domain.*;
import shhouse.infra.AbstractEvent;

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
}
