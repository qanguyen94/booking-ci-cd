package qanguyen.demo.booking.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import qanguyen.demo.booking.entity.RoomInfo;
import qanguyen.demo.booking.repository.RoomInfoRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RoomInfoService implements IRoomInfoService {

    @Autowired
    private final RoomInfoRepository repository;

    @Override
    public List<RoomInfo> findAll() {
        var roomInfo = (List<RoomInfo>) repository.findAll();
        return roomInfo;
    }
}
