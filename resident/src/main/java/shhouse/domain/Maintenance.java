package shhouse.domain;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.time.LocalDate;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.persistence.*;
import lombok.Data;
import shhouse.ResidentApplication;

@Entity
@Table(name = "Maintenance_table")
@Data
//<<< DDD / Aggregate Root
public class Maintenance {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String houseName;

    private String houseLocation;

    private Boolean isMaintenance;

    private Date maintenanceDate;

    public static MaintenanceRepository repository() {
        MaintenanceRepository maintenanceRepository = ResidentApplication.applicationContext.getBean(
            MaintenanceRepository.class
        );
        return maintenanceRepository;
    }

    //<<< Clean Arch / Port Method
    public static void applyMaintenance(Left left) {
        //implement business logic here:

        /** Example 1:  new item 
        Maintenance maintenance = new Maintenance();
        repository().save(maintenance);

        */

        /** Example 2:  finding and process
        

        repository().findById(left.get???()).ifPresent(maintenance->{
            
            maintenance // do something
            repository().save(maintenance);


         });
        */

    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
