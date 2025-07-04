package shhouse.domain;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.time.LocalDate;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Random;
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

    public void drawSubscription() {
        // 1. 등록된 전체 Winner 정보를 조회
        List<Winner> allWinners = (List<Winner>) repository().findAll();
        
        if (allWinners.isEmpty()) {
            return;
        }
        
        // 2. 랜덤한 인원 (2명) 선별
        Collections.shuffle(allWinners);
        int winnersCount = Math.min(2, allWinners.size());
        
        // 3. 선별된 인원에게는 WON을, 선별되지 않은 모든 인원에게는 FALLEN을 설정
        for (int i = 0; i < allWinners.size(); i++) {
            Winner winner = allWinners.get(i);
            if (i < winnersCount) {
                winner.setWinningStatus(WinningStatus.WON);
                repository().save(winner);
                
                // 당첨자에 대해서만 이벤트 발행
                SubscriptionDrawn subscriptionDrawn = new SubscriptionDrawn(winner);
                subscriptionDrawn.publishAfterCommit();
            } else {
                winner.setWinningStatus(WinningStatus.FALLEN);
                repository().save(winner);
            }
        }
    }

    public static WinnerRepository repository() {
        WinnerRepository winnerRepository = WinningresultApplication.applicationContext.getBean(
            WinnerRepository.class
        );
        return winnerRepository;
    }

    //<<< Clean Arch / Port Method
    public static void registerPasser(SubscriptionApproved subscriptionApproved) {
        Winner winner = new Winner();
        winner.setApplyName(subscriptionApproved.getRecipientName());
        winner.setPhoneNumber(subscriptionApproved.getPhoneNumber());
        winner.setEmail(subscriptionApproved.getEmail());
        winner.setHouse(subscriptionApproved.getHouseName());
        winner.setLocation(subscriptionApproved.getHouseLocation());
        repository().save(winner);
    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
