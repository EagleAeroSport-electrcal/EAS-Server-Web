package org.erau.eas.serverweb.daqPacks;

import lombok.Data;
import org.apache.commons.codec.binary.Hex;
import org.apache.commons.lang3.ArrayUtils;

@Data
public class PresTempHum {

    private int press;

    private int temp;

    private short hum;

    public PresTempHum(byte[] data) {
        byte[] sensorIdBytes = ArrayUtils.subarray(data, 0, 4);
        byte[] pressBytes = ArrayUtils.subarray(data, 8, 12);
        byte[] tempBytes = ArrayUtils.subarray(data, 12, 16);
        byte[] humBytes = ArrayUtils.subarray(data, 16,18);
        ArrayUtils.reverse(sensorIdBytes);
        ArrayUtils.reverse(pressBytes);
        ArrayUtils.reverse(tempBytes);
        ArrayUtils.reverse(humBytes);
        String pressString = Hex.encodeHexString(pressBytes);
        String tempString = Hex.encodeHexString(tempBytes);
        String humString = Hex.encodeHexString(humBytes);
        this.press = Integer.parseInt(pressString, 16);
        this.temp = Integer.parseInt(tempString, 16);
        this.hum = Short.parseShort(humString, 16);
    }
}
