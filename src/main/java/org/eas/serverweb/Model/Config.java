package org.eas.serverweb.Model;

import org.eas.serverweb.Model.CompKeys.ConfigKey;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "config")
public class Config {

    @EmbeddedId
    private ConfigKey key;

    private String type;

    private int calibration;

    public ConfigKey getKey() {
        return key;
    }

    public void setKey(ConfigKey key) {
        this.key = key;
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
