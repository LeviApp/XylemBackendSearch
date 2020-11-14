package xylembackend.search.repo;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface LikedPlant {
    @Query("SELECT COUNT(l) FROM LIKEDPLANT l WHERE l.plant_id=:plantid AND l.liked = true")
    Long likeAPlant(@Param("plantid") Integer plantid);
}
