package org.erau.eas.serverweb.daqPacks;

import com.google.common.primitives.Ints;
import com.google.common.primitives.Longs;
import lombok.Data;
import org.apache.commons.codec.binary.Hex;
import org.apache.commons.lang3.ArrayUtils;
import org.erau.eas.serverweb.db.CompKeys.DataKey;

import javax.persistence.EmbeddedId;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;
import java.util.Date;

@Data
public class Time{
    @EmbeddedId
    private DataKey dataKey;

    private Date course;

    private int tv_sec;

    private long tv_nsec;

    Time(byte[] timeData, DataKey dataKey){
        this.dataKey = dataKey;
    }
}
