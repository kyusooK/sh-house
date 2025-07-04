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
import shhouse.domain.SupplyPlanApproved;
import shhouse.domain.SupplyPlanDisApproved;

@Entity
@Table(name = "HouseSupply_table")
@Data
//<<< DDD / Aggregate Root
public class HouseSupply {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Embedded
    private HousingProjectId housingProjectId;

    private String houseName;

    private String houseLocation;

    private SupplyStatus supplyStatus;

    private String projectName;

    private String manager;

    private Integer recruitmentCount;

    @PostUpdate
    public void onPostUpdate() {
        SupplyPlanApproved supplyPlanApproved = new SupplyPlanApproved(this);
        supplyPlanApproved.publishAfterCommit();

        SupplyPlanDisApproved supplyPlanDisApproved = new SupplyPlanDisApproved(
            this
        );
        supplyPlanDisApproved.publishAfterCommit();
    }

    public static HouseSupplyRepository repository() {
        HouseSupplyRepository houseSupplyRepository = SupplyplanApplication.applicationContext.getBean(
            HouseSupplyRepository.class
        );
        return houseSupplyRepository;
    }
}
//>>> DDD / Aggregate Root
