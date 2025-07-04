package shhouse.domain;

import java.util.Date;
import lombok.Data;

@Data
public class GetAnnouncementQuery {

    private Long id;
    private String title;
    private String houseName;
    private String houseLocation;
    private String eligibilityCriteria;
}
