package org.erau.eas.serverweb.daqPacks;

import lombok.Data;
import org.apache.commons.codec.binary.Hex;
import org.apache.commons.lang3.ArrayUtils;
import org.erau.eas.serverweb.db.CompKeys.DataKey;

import javax.persistence.EmbeddedId;
import java.util.Date;

@Data
public class Time{
    @EmbeddedId
    private DataKey dataKey;

    private long course;

    private Date tv_sec;

    private long tv_nsec;

    Time(byte[] timeData, DataKey dataKey){
        this.dataKey = dataKey;
        byte[] courseBytes = ArrayUtils.subarray(timeData, 8, 12);
        byte[] tv_secBytes = ArrayUtils.subarray(timeData, 12, 16);
        byte[] tv_nsecBytes = ArrayUtils.subarray(timeData, 16, 25);
        ArrayUtils.reverse(courseBytes);
        ArrayUtils.reverse(tv_secBytes);
        ArrayUtils.reverse(tv_nsecBytes);
        String courseString = Hex.encodeHexString(courseBytes);
        String tv_secString = Hex.encodeHexString(tv_secBytes);
        String tv_nsecString = Hex.encodeHexString(tv_nsecBytes);
        this.course = Long.parseLong(courseString, 16);
        this.tv_sec = new Date(Long.parseLong(tv_secString, 16));
        this.tv_nsec = Long.parseLong(tv_nsecString, 16);
    }
}
