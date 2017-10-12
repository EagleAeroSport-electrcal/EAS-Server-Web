package org.erau.eas.serverweb.db.CompKeys;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.sql.Timestamp;

@Embeddable
public class DataKey implements Serializable {

    private Timestamp timestamp;

    private int boardId;

    private int flightId;

    public DataKey() {
    }

    public DataKey(Timestamp timestamp, int boardId, int flightId) {
        this.timestamp = timestamp;
        this.boardId = boardId;
        this.flightId = flightId;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public int getBoardId() {
        return boardId;
    }

    public void setBoardId(int boardId) {
        this.boardId = boardId;
    }

    public int getFlightId() {
        return flightId;
    }

    public void setFlightId(int flightId) {
        this.flightId = flightId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DataKey dataKey = (DataKey) o;

        if (getBoardId() != dataKey.getBoardId()) return false;
        if (getFlightId() != dataKey.getFlightId()) return false;
        return getTimestamp().equals(dataKey.getTimestamp());
    }

    @Override
    public int hashCode() {
        int result = getTimestamp().hashCode();
        result = 31 * result + getBoardId();
        result = 31 * result + getFlightId();
        return result;
    }
}
