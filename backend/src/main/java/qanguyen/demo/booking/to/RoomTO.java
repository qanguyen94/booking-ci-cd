package qanguyen.demo.booking.to;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class RoomTO {
    private int roomId;
    private String roomType;
    private String roomName;
    private String enterCode;
    private boolean available;
}
