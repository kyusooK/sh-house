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
import shhouse.domain.SubscriptionApproved;
import shhouse.domain.SubscriptionDisApproved;

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

    @Enumerated(EnumType.STRING)
    private ApplyStatus applyStatus;

    private String phoneNumber;

    private String email;

    @Embedded
    private AnnouncementId announcementId;

    @PostUpdate
    public void onPostUpdate() {
        SubscriptionApproved subscriptionApproved = new SubscriptionApproved(
            this
        );
        subscriptionApproved.publishAfterCommit();

        SubscriptionDisApproved subscriptionDisApproved = new SubscriptionDisApproved(
            this
        );
        subscriptionDisApproved.publishAfterCommit();
    }

    public static SubscriptionRepository repository() {
        SubscriptionRepository subscriptionRepository = ReceiptApplication.applicationContext.getBean(
            SubscriptionRepository.class
        );
        return subscriptionRepository;
    }
}
//>>> DDD / Aggregate Root
