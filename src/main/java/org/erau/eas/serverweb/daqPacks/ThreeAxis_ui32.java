package org.erau.eas.serverweb.daqPacks;

import lombok.Data;
import org.erau.eas.serverweb.db.CompKeys.DataKey;

import javax.persistence.EmbeddedId;

@Data
public class ThreeAxis_ui32 {

    @EmbeddedId
    private DataKey dataKey;

    private long x;

    private long y;

    private long z;
}
