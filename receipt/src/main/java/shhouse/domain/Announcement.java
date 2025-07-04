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
import shhouse.ReceiptApplication;

@Entity
@Table(name = "Announcement_table")
@Data
//<<< DDD / Aggregate Root
public class Announcement {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String title;

    private String content;

    private String houseName;

    private String houseLocation;

    private Date applyStartDate;

    private Date applyEndDate;

    private Date moveInStartDate;

    private Date moveInEndDate;

    private String eligibilityCriteria;

    public static AnnouncementRepository repository() {
        AnnouncementRepository announcementRepository = ReceiptApplication.applicationContext.getBean(
            AnnouncementRepository.class
        );
        return announcementRepository;
    }

    //<<< Clean Arch / Port Method
    public static void registerAnnouncement(
        SupplyPlanApproved supplyPlanApproved
    ) {
        Announcement announcement = new Announcement();
        announcement.setTitle("2025년 " + supplyPlanApproved.getHouseName() + " 공공분양주택 입주자 모집공고");
        announcement.setContent("■ 공급위치: " + supplyPlanApproved.getHouseLocation() + 
                              "\n■ 공급규모: 지하2층~지상20층, 총 500세대" +
                              "\n■ 입주예정: 2026년 12월 예정" +
                              "\n■ 분양가격: 3.3㎡당 1,800만원 내외" +
                              "\n■ 접수방법: 인터넷 청약(청약홈 www.applyhome.co.kr)" +
                              "\n※ 자세한 사항은 모집공고문을 참조하시기 바랍니다.");
        announcement.setHouseName(supplyPlanApproved.getHouseName());
        announcement.setHouseLocation(supplyPlanApproved.getHouseLocation());
        // 신청 시작일: 현재 날짜
        Date currentDate = new Date();
        announcement.setApplyStartDate(currentDate);
        
        // 신청 종료일: 현재 날짜로부터 한달뒤
        Calendar cal = Calendar.getInstance();
        cal.setTime(currentDate);
        cal.add(Calendar.MONTH, 1);
        announcement.setApplyEndDate(cal.getTime());
        
        // 입주 시작일: 현재 날짜 기준 2달뒤
        cal.setTime(currentDate);
        cal.add(Calendar.MONTH, 2);
        announcement.setMoveInStartDate(cal.getTime());
        
        // 입주 종료일: 입주 시작일로부터 2년뒤
        cal.add(Calendar.YEAR, 2);
        announcement.setMoveInEndDate(cal.getTime());
        
        // 자격 요건
        announcement.setEligibilityCriteria("무주택 세대주, 소득 6분위 이하, 청약저축 가입 6개월 이상 등 일반공급 자격 요건 충족");
        repository().save(announcement);
    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
