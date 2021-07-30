package qanguyen.demo.booking.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "room_info")
@Getter
@Setter
public class RoomInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int roomId;
    private String roomType;
    private String roomName;
    private String enterCode;
    private boolean available;
}
