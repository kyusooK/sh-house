package shhouse.domain;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.time.LocalDate;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.persistence.*;
import lombok.Data;
import shhouse.WinningresultApplication;
import shhouse.domain.SubscriptionDrawn;

@Entity
@Table(name = "Winner_table")
@Data
//<<< DDD / Aggregate Root
public class Winner {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String applyName;

    private String phoneNumber;

    private String email;

    @Enumerated(EnumType.STRING)
    private WinningStatus winningStatus;

    private String house;

    private String location;

    @PostPersist
    public void onPostPersist() {
        SubscriptionDrawn subscriptionDrawn = new SubscriptionDrawn(this);
        subscriptionDrawn.publishAfterCommit();
    }

    public static WinnerRepository repository() {
        WinnerRepository winnerRepository = WinningresultApplication.applicationContext.getBean(
            WinnerRepository.class
        );
        return winnerRepository;
    }

    //<<< Clean Arch / Port Method
    public static void registerPasser(
        SubscriptionApproved subscriptionApproved
    ) {
        //implement business logic here:

        /** Example 1:  new item 
        Winner winner = new Winner();
        repository().save(winner);

        */

        /** Example 2:  finding and process
        
        // if subscriptionApproved.announcementId exists, use it
        
        // ObjectMapper mapper = new ObjectMapper();
        // Map<Long, Object> subscriptionMap = mapper.convertValue(subscriptionApproved.getAnnouncementId(), Map.class);

        repository().findById(subscriptionApproved.get???()).ifPresent(winner->{
            
            winner // do something
            repository().save(winner);


         });
        */

    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
