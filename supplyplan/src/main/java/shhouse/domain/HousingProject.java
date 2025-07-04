package shhouse.domain;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.time.LocalDate;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.persistence.*;
import lombok.Data;
import shhouse.SupplyplanApplication;

@Entity
@Table(name = "HousingProject_table")
@Data
//<<< DDD / Aggregate Root
public class HousingProject {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private String location;

    private Date completionDate;

    private Boolean isCompletion;

    public static HousingProjectRepository repository() {
        HousingProjectRepository housingProjectRepository = SupplyplanApplication.applicationContext.getBean(
            HousingProjectRepository.class
        );
        return housingProjectRepository;
    }

    //<<< Clean Arch / Port Method
    public void processCompletion(
        ProcessCompletionCommand processCompletionCommand
    ) {
        //implement business logic here:

    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
