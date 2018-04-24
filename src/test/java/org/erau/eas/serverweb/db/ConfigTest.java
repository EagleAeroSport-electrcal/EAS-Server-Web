package org.erau.eas.serverweb.db;

import org.erau.eas.serverweb.db.CompKeys.ConfigKey;
import org.junit.Test;
import static org.junit.Assert.*;

public class ConfigTest {
    @Test
    public void getSetTest(){
        Config config = new Config();
        ConfigKey configKey = new ConfigKey(1,1,1);

        config.setKey(configKey);
        config.setCalibration(12345);
        config.setType("ADXL345 three-Axis accelerometer");

        assertTrue(config.getKey().equals(configKey));
        assertEquals(12345,config.getCalibration());
        assertEquals("ADXL345 three-Axis accelerometer", config.getType());
    }
}
