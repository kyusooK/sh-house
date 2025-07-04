package shhouse.domain;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.time.LocalDate;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.persistence.*;
import lombok.Data;
import shhouse.NotificationApplication;

@Entity
@Table(name = "Notification_table")
@Data
//<<< DDD / Aggregate Root
public class Notification {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private String phoneNumber;

    private String email;

    private String content;

    public static NotificationRepository repository() {
        NotificationRepository notificationRepository = NotificationApplication.applicationContext.getBean(
            NotificationRepository.class
        );
        return notificationRepository;
    }

    //<<< Clean Arch / Port Method
    public static void notifySubscriptionResult(
        SubscriptionDisApproved subscriptionDisApproved
    ) {
        //implement business logic here:

        /** Example 1:  new item 
        Notification notification = new Notification();
        repository().save(notification);

        */

        /** Example 2:  finding and process
        
        // if subscriptionDisApproved.announcementId exists, use it
        
        // ObjectMapper mapper = new ObjectMapper();
        // Map<Long, Object> subscriptionMap = mapper.convertValue(subscriptionDisApproved.getAnnouncementId(), Map.class);

        repository().findById(subscriptionDisApproved.get???()).ifPresent(notification->{
            
            notification // do something
            repository().save(notification);


         });
        */

    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public static void notifyWinning(SubscriptionDrawn subscriptionDrawn) {
        //implement business logic here:

        /** Example 1:  new item 
        Notification notification = new Notification();
        repository().save(notification);

        */

        /** Example 2:  finding and process
        

        repository().findById(subscriptionDrawn.get???()).ifPresent(notification->{
            
            notification // do something
            repository().save(notification);


         });
        */

    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public static void notifyMoveIn(TenantRegistered tenantRegistered) {
        //implement business logic here:

        /** Example 1:  new item 
        Notification notification = new Notification();
        repository().save(notification);

        */

        /** Example 2:  finding and process
        

        repository().findById(tenantRegistered.get???()).ifPresent(notification->{
            
            notification // do something
            repository().save(notification);


         });
        */

    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public static void notifyExtendResult(ExtendApproved extendApproved) {
        //implement business logic here:

        /** Example 1:  new item 
        Notification notification = new Notification();
        repository().save(notification);

        */

        /** Example 2:  finding and process
        
        // if extendApproved.contractIdtenantId exists, use it
        
        // ObjectMapper mapper = new ObjectMapper();
        // Map<Long, Object> extendContractMap = mapper.convertValue(extendApproved.getContractId(), Map.class);
        // Map<Long, Object> extendContractMap = mapper.convertValue(extendApproved.getTenantId(), Map.class);

        repository().findById(extendApproved.get???()).ifPresent(notification->{
            
            notification // do something
            repository().save(notification);


         });
        */

    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public static void notifyExtendResult(ExtendDisApproved extendDisApproved) {
        //implement business logic here:

        /** Example 1:  new item 
        Notification notification = new Notification();
        repository().save(notification);

        */

        /** Example 2:  finding and process
        
        // if extendDisApproved.contractIdtenantId exists, use it
        
        // ObjectMapper mapper = new ObjectMapper();
        // Map<Long, Object> extendContractMap = mapper.convertValue(extendDisApproved.getContractId(), Map.class);
        // Map<Long, Object> extendContractMap = mapper.convertValue(extendDisApproved.getTenantId(), Map.class);

        repository().findById(extendDisApproved.get???()).ifPresent(notification->{
            
            notification // do something
            repository().save(notification);


         });
        */

    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
