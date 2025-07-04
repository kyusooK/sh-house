package shhouse.domain;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.time.LocalDate;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.persistence.*;
import lombok.Data;
import shhouse.ContractApplication;
import shhouse.domain.Contracted;

@Entity
@Table(name = "Contract_table")
@Data
//<<< DDD / Aggregate Root
public class Contract {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String title;

    private String houseName;

    private String houseLocation;

    private String content;

    private Date contractAt;

    private Date contractEndAt;

    private String name;

    private String phoneNumber;

    @PostPersist
    public void onPostPersist() {
        Contracted contracted = new Contracted(this);
        contracted.publishAfterCommit();
    }

    public static ContractRepository repository() {
        ContractRepository contractRepository = ContractApplication.applicationContext.getBean(
            ContractRepository.class
        );
        return contractRepository;
    }

    //<<< Clean Arch / Port Method
    public static void registerContract(SubscriptionDrawn subscriptionDrawn) {
        //implement business logic here:

        /** Example 1:  new item 
        Contract contract = new Contract();
        repository().save(contract);

        */

        /** Example 2:  finding and process
        

        repository().findById(subscriptionDrawn.get???()).ifPresent(contract->{
            
            contract // do something
            repository().save(contract);


         });
        */

    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public static void endContract(Left left) {
        //implement business logic here:

        /** Example 1:  new item 
        Contract contract = new Contract();
        repository().save(contract);

        */

        /** Example 2:  finding and process
        

        repository().findById(left.get???()).ifPresent(contract->{
            
            contract // do something
            repository().save(contract);


         });
        */

    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
