package org.erau.eas.serverweb.daqPacks;

import lombok.Data;
import org.erau.eas.serverweb.db.CompKeys.DataKey;

import javax.persistence.EmbeddedId;
import java.util.Date;

@Data
public class Time{
    @EmbeddedId
    private DataKey dataKey;

    private Date course;

    private int tv_sec;

    private long tv_nsec;

    Time(byte[] timeData){

    }
}
