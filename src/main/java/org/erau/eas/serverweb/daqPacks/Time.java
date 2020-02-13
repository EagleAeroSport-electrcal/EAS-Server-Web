package org.erau.eas.serverweb.daqPacks;

import lombok.Data;
import org.apache.commons.codec.binary.Hex;
import org.apache.commons.lang3.ArrayUtils;

import java.sql.Timestamp;

@Data
public class Time{

    private long course;

    private Timestamp tv_sec;

    private long tv_nsec;

    Time(byte[] timeData){
        byte[] sensorIdBytes = ArrayUtils.subarray(timeData, 0, 4);
        byte[] courseBytes = ArrayUtils.subarray(timeData, 8, 12);
        byte[] tv_secBytes = ArrayUtils.subarray(timeData, 12, 16);
        byte[] tv_nsecBytes = ArrayUtils.subarray(timeData, 16, 24);
        ArrayUtils.reverse(sensorIdBytes);
        ArrayUtils.reverse(courseBytes);
        ArrayUtils.reverse(tv_secBytes);
        ArrayUtils.reverse(tv_nsecBytes);
        String courseString = Hex.encodeHexString(courseBytes);
        String tv_secString = Hex.encodeHexString(tv_secBytes);
        String tv_nsecString = Hex.encodeHexString(tv_nsecBytes);
        this.course = Long.parseLong(courseString, 16);
        this.tv_sec = new Timestamp(Long.parseLong(tv_secString, 16) * 1000);
        this.tv_nsec = Long.parseLong(tv_nsecString, 16);
    }
}
