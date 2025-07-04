package shhouse.domain;

import java.util.Date;
import java.util.List;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import shhouse.domain.*;

//<<< PoEAA / Repository
@RepositoryRestResource(
    collectionResourceRel = "announcements",
    path = "announcements"
)
public interface AnnouncementRepository
    extends PagingAndSortingRepository<Announcement, Long> {
    @Query(
        value = "select announcement " +
        "from Announcement announcement " +
        "where(:id is null or announcement.id = :id) and (:title is null or announcement.title like %:title%) and (:houseName is null or announcement.houseName like %:houseName%) and (:houseLocation is null or announcement.houseLocation like %:houseLocation%) and (:eligibilityCriteria is null or announcement.eligibilityCriteria like %:eligibilityCriteria%)"
    )
    List<Announcement> getAnnouncement(
        Long id,
        String title,
        String houseName,
        String houseLocation,
        String eligibilityCriteria,
        Pageable pageable
    );
}
