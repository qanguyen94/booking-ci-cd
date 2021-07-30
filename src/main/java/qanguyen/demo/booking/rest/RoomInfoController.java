package qanguyen.demo.booking.rest;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import qanguyen.demo.booking.entity.RoomInfo;
import qanguyen.demo.booking.service.IRoomInfoService;
import qanguyen.demo.booking.to.RoomTO;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("room")
public class RoomInfoController {

    private final IRoomInfoService roomInfoService;

    @PostMapping("/{roomId}")
    public String getRoomInfo(@PathVariable String roomId) {
        return roomId;
    }

    @GetMapping("/all")
    public List<RoomTO> getAllRoomInfo() {
        List<RoomInfo> rooms = roomInfoService.findAll();
        return rooms.stream()
                .map(roomInfo -> RoomTO.builder()
                        .roomId(roomInfo.getRoomId())
                        .roomName(roomInfo.getRoomType())
                        .roomType(roomInfo.getRoomName())
                        .enterCode(roomInfo.getEnterCode())
                        .available(roomInfo.isAvailable())
                        .build())
                .collect(Collectors.toList());
    }
}
