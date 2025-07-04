package shhouse.domain;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

//<<< EDA / CQRS
@Entity
@Table(name = "ContractDashboard_table")
@Data
public class ContractDashboard {

    @Id
    //@GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    private String title;
    private String name;
    private Date contractStartAt;
    private Date contractEndAt;
    private String houseName;
    private String houseLocation;
}
