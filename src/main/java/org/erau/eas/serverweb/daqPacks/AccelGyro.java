package org.erau.eas.serverweb.daqPacks;

import lombok.Data;
import org.erau.eas.serverweb.db.CompKeys.DataKey;

import javax.persistence.EmbeddedId;

@Data
public class AccelGyro {

    @EmbeddedId
    private DataKey dataKey;

    private short accel_x;

    private short accel_y;

    private short accel_z;

    private short gyro_x;

    private short gyro_y;

    private short gyro_z;

    private short time;
}
