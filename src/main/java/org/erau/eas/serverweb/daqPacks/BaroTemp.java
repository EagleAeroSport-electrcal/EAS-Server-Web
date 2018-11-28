package org.erau.eas.serverweb.daqPacks;

import lombok.Data;
import org.erau.eas.serverweb.db.CompKeys.DataKey;

import javax.persistence.EmbeddedId;

@Data
public class BaroTemp {

    @EmbeddedId
    private DataKey dataKey;

    private int press;

    private short temp;
}
