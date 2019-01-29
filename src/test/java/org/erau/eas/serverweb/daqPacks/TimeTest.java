package org.erau.eas.serverweb.daqPacks;

import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Hex;
import org.erau.eas.serverweb.db.CompKeys.DataKey;
import org.junit.Before;
import org.junit.Test;

import java.sql.Timestamp;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TimeTest {
    DataKey dataKey;

    @Before
    public void setUp(){
        dataKey = new DataKey(Timestamp.valueOf("2018-04-23 12:48:05"), 1, 1, 0);
    }

    @Test
    public void ConstructorTest() throws DecoderException {
        byte[] input = Hex.decodeHex("010000000C000000204E000078D61258FE67D30200000000");
        System.out.println(Arrays.toString(input));
        Time time = new Time(input, dataKey);

        assertEquals(20000, time.getCourse());
        assertTrue(new Timestamp(1477629560000L).equals(time.getTv_sec()));
        assertEquals(47409150, time.getTv_nsec());
        assertEquals(1, time.getDataKey().getSensorId());
    }
}
