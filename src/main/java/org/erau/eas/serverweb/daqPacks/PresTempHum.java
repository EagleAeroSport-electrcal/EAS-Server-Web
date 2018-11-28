package org.erau.eas.serverweb.daqPacks;

import lombok.Data;
import org.erau.eas.serverweb.db.CompKeys.DataKey;

import javax.persistence.EmbeddedId;

@Data
public class PresTempHum {

    @EmbeddedId
    private DataKey dataKey;

    private int press;

    private int temp;

    private short humid;
}
