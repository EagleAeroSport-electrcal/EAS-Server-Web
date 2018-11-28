package org.erau.eas.serverweb.daqPacks;

import lombok.Data;
import org.erau.eas.serverweb.db.CompKeys.DataKey;

import javax.persistence.EmbeddedId;

@Data
public class ThreeAxis_ss16 {

    @EmbeddedId
    private DataKey dataKey;

    private short x;

    private short y;

    private short z;
}
