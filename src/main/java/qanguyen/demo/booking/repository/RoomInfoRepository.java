package qanguyen.demo.booking.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import qanguyen.demo.booking.entity.RoomInfo;

@Repository
public interface RoomInfoRepository extends CrudRepository<RoomInfo, Long> {
}
