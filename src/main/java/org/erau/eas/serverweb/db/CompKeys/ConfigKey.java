package org.erau.eas.serverweb.db.CompKeys;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class ConfigKey implements Serializable {

    @Column(name = "flight_id")
    private int flightID;

    @Column(name = "board_id")
    private int boardId;

    @Column(name = "sensor_id")
    private int sensorId;

    public ConfigKey(int flightID, int boardId, int sensorId) {
        this.flightID = flightID;
        this.boardId = boardId;
        this.sensorId = sensorId;
    }

    public int getFlightID() {
        return flightID;
    }

    public int getBoardId() {
        return boardId;
    }

    public int getSensorId() {
        return sensorId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ConfigKey configKey = (ConfigKey) o;

        if (getFlightID() != configKey.getFlightID()) return false;
        if (getBoardId() != configKey.getBoardId()) return false;
        return getSensorId() == configKey.getSensorId();
    }

    @Override
    public int hashCode() {
        int result = getFlightID();
        result = 31 * result + getBoardId();
        result = 31 * result + getSensorId();
        return result;
    }
}
