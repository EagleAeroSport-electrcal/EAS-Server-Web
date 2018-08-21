package org.erau.eas.serverweb.Mappings;

import org.junit.Test;
import static org.junit.Assert.*;



public class DataReceiverTest {
    @Test
    public void getSetTest(){
        byte[] data = "e04fd020ea3a6910a2d808002b30309d".getBytes();
        DataReceiver dataReceiver = new DataReceiver();
        dataReceiver.setDeviceId(1);
        dataReceiver.setFlightId(1);
        dataReceiver.setPacketSize(24L);
        dataReceiver.setData(data);

        assertEquals(1, dataReceiver.getDeviceId());
        assertEquals(1, dataReceiver.getFlightId());
        assertEquals(24L, dataReceiver.getPacketSize());
        assertEquals(data, dataReceiver.getData());
    }
}
