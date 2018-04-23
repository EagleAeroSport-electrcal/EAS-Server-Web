package org.erau.eas.serverweb.db.CompKeys;

import org.junit.Test;
import static org.junit.Assert.*;

public class ConfigKeyTest {
    @Test
    public void getSetTest(){
        ConfigKey configKey = new ConfigKey(1,1,1);
        assertEquals(1, configKey.getFlightID());
        assertEquals(1, configKey.getBoardId());
        assertEquals(1, configKey.getSensorId());
    }

    @Test
    public void hashCodeTest(){
        ConfigKey configKey = new ConfigKey(1,1,1);
        assertEquals(993,configKey.hashCode());
    }

    @Test
    public void equalsTest(){
        ConfigKey configKey1 = new ConfigKey(1,1,1);
        ConfigKey configKey2 = new ConfigKey(1,1,1);
        ConfigKey configKey3 = new ConfigKey(2,2,2);

        assertFalse(configKey1.equals(configKey3));
        assertTrue(configKey1.equals(configKey2));
    }


}
