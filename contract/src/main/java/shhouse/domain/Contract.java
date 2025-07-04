package shhouse.domain;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.time.LocalDate;
import java.util.Calendar;
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

    public static ContractRepository repository() {
        ContractRepository contractRepository = ContractApplication.applicationContext.getBean(
            ContractRepository.class
        );
        return contractRepository;
    }

    //<<< Clean Arch / Port Method
    public static void registerContract(SubscriptionDrawn subscriptionDrawn) {
        // 당첨자 정보를 기반으로 새로운 계약 생성
        Contract contract = new Contract();
        
        // 기본 정보 설정
        contract.setTitle(subscriptionDrawn.getHouse() + " 공공분양주택 계약서");
        contract.setHouseName(subscriptionDrawn.getHouse());
        contract.setHouseLocation(subscriptionDrawn.getLocation());
        contract.setName(subscriptionDrawn.getApplyName());
        contract.setPhoneNumber(subscriptionDrawn.getPhoneNumber());
        
        // 계약 내용 설정
        contract.setContent("■ 계약자: " + subscriptionDrawn.getApplyName() + 
                          "\n■ 연락처: " + subscriptionDrawn.getPhoneNumber() +
                          "\n■ 주택명: " + subscriptionDrawn.getHouse() +
                          "\n■ 소재지: " + subscriptionDrawn.getLocation() +
                          "\n■ 계약조건: 공공분양주택 공급계약 조건에 따름" +
                          "\n※ 본 계약은 관련 법령 및 공급규정에 의거하여 체결됩니다.");
        
        // 계약 시작일: 현재날짜 기준 한달뒤
        Date currentDate = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(currentDate);
        cal.add(Calendar.MONTH, 1);
        contract.setContractAt(cal.getTime());
        
        // 계약 종료일: 시작날짜 기준 2년뒤
        cal.add(Calendar.YEAR, 2);
        contract.setContractEndAt(cal.getTime());
        
        repository().save(contract);
    }

    public void contract() {
        repository().findById(this.getId()).ifPresent(contract -> {

            Contracted contracted = new Contracted(contract);
            contracted.publishAfterCommit();
        });
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
