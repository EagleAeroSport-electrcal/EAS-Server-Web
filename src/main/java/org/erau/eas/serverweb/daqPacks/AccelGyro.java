package org.erau.eas.serverweb.daqPacks;

import lombok.Data;

@Data
public class AccelGyro {

    private short accel_x;

    private short accel_y;

    private short accel_z;

    private short gyro_x;

    private short gyro_y;

    private short gyro_z;

    private short time;
}
