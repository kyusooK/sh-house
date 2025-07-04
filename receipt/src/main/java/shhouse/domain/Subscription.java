package shhouse.domain;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.time.LocalDate;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.persistence.*;
import lombok.Data;
import shhouse.ReceiptApplication;

@Entity
@Table(name = "Subscription_table")
@Data
//<<< DDD / Aggregate Root
public class Subscription {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String houseName;

    private String houseLocation;

    private String recipientName;

    private String documentFile;

    private ApplyStatus applyStatus;

    private String phoneNumber;

    private String email;

    @Embedded
    private AnnouncementId announcementId;

    private Boolean isApprove;

    public static SubscriptionRepository repository() {
        SubscriptionRepository subscriptionRepository = ReceiptApplication.applicationContext.getBean(
            SubscriptionRepository.class
        );
        return subscriptionRepository;
    }

    //<<< Clean Arch / Port Method
    public void checkSubscription(CheckSubscriptionCommand checkSubscriptionCommand) {
        repository().findById(this.getId()).ifPresent(subscription -> {
            if(checkSubscriptionCommand.getIsApprove() == true){
                this.setApplyStatus(ApplyStatus.APPROVED);
                repository().save(subscription);

                SubscriptionApproved subscriptionApproved = new SubscriptionApproved(this);
                subscriptionApproved.publishAfterCommit();
            }else{
                this.setApplyStatus(ApplyStatus.DISAPPROVED);
                repository().save(subscription);

                SubscriptionDisApproved subscriptionDisApproved = new SubscriptionDisApproved(this);
                subscriptionDisApproved.publishAfterCommit();
            }
        });
    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
