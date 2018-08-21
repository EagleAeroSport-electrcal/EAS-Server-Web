package org.erau.eas.serverweb.db;

import org.junit.Test;
import static org.junit.Assert.*;

import java.util.Arrays;


public class DataTest {
    @Test
    public void getSetTest(){
        Data data = new Data();

        byte[] internalData1 = "A".getBytes();
        data.setData1(internalData1);
        byte[] internalData2 = "B".getBytes();
        data.setData2(internalData2);
        byte[] internalData3 = "C".getBytes();
        data.setData3(internalData3);
        byte[] internalData4 = "D".getBytes();
        data.setData4(internalData4);
        byte[] internalData5 = "E".getBytes();
        data.setData5(internalData5);
        byte[] internalData6 = "F".getBytes();
        data.setData6(internalData6);
        byte[] internalData7 = "G".getBytes();
        data.setData7(internalData7);
        byte[] internalData8 = "H".getBytes();
        data.setData8(internalData8);
        byte[] internalData9 = "I".getBytes();
        data.setData9(internalData9);
        byte[] internalData10 = "J".getBytes();
        data.setData10(internalData10);
        byte[] internalData11 = "K".getBytes();
        data.setData11(internalData11);
        byte[] internalData12 = "L".getBytes();
        data.setData12(internalData12);
        byte[] internalData13 = "M".getBytes();
        data.setData13(internalData13);
        byte[] internalData14 = "N".getBytes();
        data.setData14(internalData14);
        byte[] internalData15 = "O".getBytes();
        data.setData15(internalData15);
        byte[] internalData16 = "P".getBytes();
        data.setData16(internalData16);
        byte[] internalDataBig = "Hello World!!!!!!!!!!!!!!!!".getBytes();
        data.setRawData(internalDataBig);

        assertTrue(Arrays.equals("A".getBytes(), data.getData1()));
        assertTrue(Arrays.equals("B".getBytes(), data.getData2()));
        assertTrue(Arrays.equals("C".getBytes(), data.getData3()));
        assertTrue(Arrays.equals("D".getBytes(), data.getData4()));
        assertTrue(Arrays.equals("E".getBytes(), data.getData5()));
        assertTrue(Arrays.equals("F".getBytes(), data.getData6()));
        assertTrue(Arrays.equals("G".getBytes(), data.getData7()));
        assertTrue(Arrays.equals("H".getBytes(), data.getData8()));
        assertTrue(Arrays.equals("I".getBytes(), data.getData9()));
        assertTrue(Arrays.equals("J".getBytes(), data.getData10()));
        assertTrue(Arrays.equals("K".getBytes(), data.getData11()));
        assertTrue(Arrays.equals("L".getBytes(), data.getData12()));
        assertTrue(Arrays.equals("M".getBytes(), data.getData13()));
        assertTrue(Arrays.equals("N".getBytes(), data.getData14()));
        assertTrue(Arrays.equals("O".getBytes(), data.getData15()));
        assertTrue(Arrays.equals("P".getBytes(), data.getData16()));
        assertTrue(Arrays.equals("Hello World!!!!!!!!!!!!!!!!".getBytes(), data.getRawData()));

    }
}
