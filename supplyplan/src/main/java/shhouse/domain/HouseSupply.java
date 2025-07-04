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
@Table(name = "HouseSupply_table")
@Data
//<<< DDD / Aggregate Root
public class HouseSupply {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String houseName;

    private String houseLocation;

    private SupplyStatus supplyStatus;

    private String projectName;

    private String manager;

    private Integer recruitmentCount;

    @Embedded
    private HousingProjectId housingProjectId;

    private Boolean isApprove;

    public static HouseSupplyRepository repository() {
        HouseSupplyRepository houseSupplyRepository = SupplyplanApplication.applicationContext.getBean(
            HouseSupplyRepository.class
        );
        return houseSupplyRepository;
    }

    //<<< Clean Arch / Port Method
    public void examineSupplyplan(ExamineSupplyplanCommand examineSupplyplanCommand) {
        repository().findById(this.getId()).ifPresent(houseSupply -> {
            if(examineSupplyplanCommand.getIsApprove() == true){
                this.setSupplyStatus(SupplyStatus.APPROVED);
                repository().save(houseSupply);

                SupplyPlanApproved supplyPlanApproved = new SupplyPlanApproved(this);
                supplyPlanApproved.publishAfterCommit();
            }else{
                this.setSupplyStatus(SupplyStatus.DISAPPROVED);
                repository().save(houseSupply);

                SupplyPlanDisApproved supplyPlanDisApproved = new SupplyPlanDisApproved(this);
                supplyPlanDisApproved.publishAfterCommit();
            }
        });
    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
