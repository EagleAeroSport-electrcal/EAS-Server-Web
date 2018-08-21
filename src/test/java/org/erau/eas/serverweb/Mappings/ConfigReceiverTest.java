package org.erau.eas.serverweb.Mappings;

import org.junit.Test;
import static org.junit.Assert.*;

public class ConfigReceiverTest {
    @Test
    public void getSetTest(){
        ConfigReceiver configReceiver = new ConfigReceiver();
        configReceiver.setBoardId(1);
        configReceiver.setBody("This is a test");
        configReceiver.setFlightID(1);

        assertEquals(1, configReceiver.getBoardId());
        assertEquals(1, configReceiver.getFlightID());
        assertEquals("This is a test", configReceiver.getBody());
    }
}
