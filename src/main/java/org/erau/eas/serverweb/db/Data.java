package org.erau.eas.serverweb.db;

import org.erau.eas.serverweb.db.CompKeys.DataKey;

import javax.persistence.*;

@Entity
@Table(name = "data")
public class Data {

    @EmbeddedId
    private DataKey key;

    @Lob
    @Column(name = "raw_Data", length=2000)
    private byte[] rawData;

    @Column(name = "data1", length=100)
    private byte[] data1;

    @Column(name = "data2", length=100)
    private byte[] data2;

    @Column(name = "data3", length=100)
    private byte[] data3;

    @Column(name = "data4", length=100)
    private byte[] data4;

    @Column(name = "data5", length=100)
    private byte[] data5;

    @Column(name = "data6", length=100)
    private byte[] data6;

    @Column(name = "data7", length=100)
    private byte[] data7;

    @Column(name = "data8", length=100)
    private byte[] data8;

    @Column(name = "data9", length=100)
    private byte[] data9;

    @Column(name = "data10", length=100)
    private byte[] data10;

    @Column(name = "data11", length=100)
    private byte[] data11;

    @Column(name = "data12", length=100)
    private byte[] data12;

    @Column(name = "data13", length=100)
    private byte[] data13;

    @Column(name = "data14", length=100)
    private byte[] data14;

    @Column(name = "data15", length=100)
    private byte[] data15;

    @Column(name = "data16", length=100)
    private byte[] data16;

    public DataKey getKey() {
        return key;
    }

    public void setKey(DataKey key) {
        this.key = key;
    }

    public byte[] getRawData() {
        return rawData;
    }

    public void setRawData(byte[] rawData) {
        this.rawData = rawData;
    }

    public byte[] getData1() {
        return data1;
    }

    public void setData1(byte[] data1) {
        this.data1 = data1;
    }

    public byte[] getData2() {
        return data2;
    }

    public void setData2(byte[] data2) {
        this.data2 = data2;
    }

    public byte[] getData3() {
        return data3;
    }

    public void setData3(byte[] data3) {
        this.data3 = data3;
    }

    public byte[] getData4() {
        return data4;
    }

    public void setData4(byte[] data4) {
        this.data4 = data4;
    }

    public byte[] getData5() {
        return data5;
    }

    public void setData5(byte[] data5) {
        this.data5 = data5;
    }

    public byte[] getData6() {
        return data6;
    }

    public void setData6(byte[] data6) {
        this.data6 = data6;
    }

    public byte[] getData7() {
        return data7;
    }

    public void setData7(byte[] data7) {
        this.data7 = data7;
    }

    public byte[] getData8() {
        return data8;
    }

    public void setData8(byte[] data8) {
        this.data8 = data8;
    }

    public byte[] getData9() {
        return data9;
    }

    public void setData9(byte[] data9) {
        this.data9 = data9;
    }

    public byte[] getData10() {
        return data10;
    }

    public void setData10(byte[] data10) {
        this.data10 = data10;
    }

    public byte[] getData11() {
        return data11;
    }

    public void setData11(byte[] data11) {
        this.data11 = data11;
    }

    public byte[] getData12() {
        return data12;
    }

    public void setData12(byte[] data12) {
        this.data12 = data12;
    }

    public byte[] getData13() {
        return data13;
    }

    public void setData13(byte[] data13) {
        this.data13 = data13;
    }

    public byte[] getData14() {
        return data14;
    }

    public void setData14(byte[] data14) {
        this.data14 = data14;
    }

    public byte[] getData15() {
        return data15;
    }

    public void setData15(byte[] data15) {
        this.data15 = data15;
    }

    public byte[] getData16() {
        return data16;
    }

    public void setData16(byte[] data16) {
        this.data16 = data16;
    }
}
