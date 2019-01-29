package org.erau.eas.serverweb.daqPacks;

import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Hex;
import org.erau.eas.serverweb.db.CompKeys.DataKey;
import org.junit.Before;
import org.junit.Test;

import java.sql.Timestamp;
import java.util.Arrays;

public class PresTempHumTest {
    DataKey dataKey;

    @Before
    public void setUp(){
        dataKey = new DataKey(Timestamp.valueOf("2018-04-23 12:48:05"), 1, 1, 1);
    }

    @Test
    public void ConstructorTest() throws DecoderException {
        byte[] input = Hex.decodeHex("020000000A00000020FB060040080800BD72000000000000");
        System.out.println(Arrays.toString(input));
        PresTempHum presTempHum = new PresTempHum(input, dataKey);

        assert true;
    }
}
