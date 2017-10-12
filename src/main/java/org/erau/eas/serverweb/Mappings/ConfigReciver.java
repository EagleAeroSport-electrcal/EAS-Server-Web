package org.erau.eas.serverweb.Mappings;

public class ConfigReciver {
    private int flightID;

    private int boardId;

    private int sensorId;

    private String type;

    private int calibration;

    public int getFlightID() {
        return flightID;
    }

    public void setFlightID(int flightID) {
        this.flightID = flightID;
    }

    public int getBoardId() {
        return boardId;
    }

    public void setBoardId(int boardId) {
        this.boardId = boardId;
    }

    public int getSensorId() {
        return sensorId;
    }

    public void setSensorId(int sensorId) {
        this.sensorId = sensorId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getCalibration() {
        return calibration;
    }

    public void setCalibration(int calibration) {
        this.calibration = calibration;
    }
}
