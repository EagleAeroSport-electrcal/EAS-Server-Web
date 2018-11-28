package org.erau.eas.serverweb.db.CompKeys;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Data
@Embeddable
public class ConfigKey implements Serializable {

    @Column(name = "flight_id")
    private int flightID;

    @Column(name = "board_id")
    private int boardId;

    @Column(name = "sensor_id")
    private int sensorId;

    public ConfigKey(){

    }

    public ConfigKey(int flightID, int boardId, int sensorId) {
        this.flightID = flightID;
        this.boardId = boardId;
        this.sensorId = sensorId;
    }
}
