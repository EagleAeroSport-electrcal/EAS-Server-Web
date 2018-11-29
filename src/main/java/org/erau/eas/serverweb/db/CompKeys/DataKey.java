package org.erau.eas.serverweb.db.CompKeys;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.sql.Timestamp;

@Data
@Embeddable
@AllArgsConstructor
public class DataKey implements Serializable {

    private Timestamp timestamp;

    @Column(name = "flight_id")
    private int boardId;

    @Column(name = "board_id")
    private int flightId;

    @Column(name = "sensor_id")
    private int sensorId;
}
