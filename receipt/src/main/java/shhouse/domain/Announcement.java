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
}
//>>> DDD / Aggregate Root
