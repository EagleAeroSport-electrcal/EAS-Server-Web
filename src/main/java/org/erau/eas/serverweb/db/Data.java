package org.erau.eas.serverweb.db;

import org.erau.eas.serverweb.db.CompKeys.DataKey;

import javax.persistence.*;

@Entity
@Table(name = "data")
public class Data {

    @EmbeddedId
    private DataKey key;

    @Column(name = "raw_data")
    private String rawData;

    @Column(name = "data1")
    private Long data1;

    @Column(name = "data2")
    private Long data2;

    @Column(name = "data3")
    private Long data3;

    @Column(name = "data4")
    private Long data4;

    @Column(name = "data5")
    private Long data5;

    @Column(name = "data6")
    private Long data6;

    @Column(name = "data7")
    private Long data7;

    @Column(name = "data8")
    private Long data8;

    @Column(name = "data9")
    private Long data9;

    @Column(name = "data10")
    private Long data10;

    @Column(name = "data11")
    private Long data11;

    @Column(name = "data12")
    private Long data12;

    @Column(name = "data13")
    private Long data13;

    @Column(name = "data14")
    private Long data14;

    @Column(name = "data15")
    private Long data15;

    @Column(name = "data16")
    private Long data16;

    public DataKey getKey() {
        return key;
    }

    public void setKey(DataKey key) {
        this.key = key;
    }

    public String getRawData() {
        return rawData;
    }

    public void setRawData(String rawData) {
        this.rawData = rawData;
    }

    public Long getData1() {
        return data1;
    }

    public void setData1(Long data1) {
        this.data1 = data1;
    }

    public Long getData2() {
        return data2;
    }

    public void setData2(Long data2) {
        this.data2 = data2;
    }

    public Long getData3() {
        return data3;
    }

    public void setData3(Long data3) {
        this.data3 = data3;
    }

    public Long getData4() {
        return data4;
    }

    public void setData4(Long data4) {
        this.data4 = data4;
    }

    public Long getData5() {
        return data5;
    }

    public void setData5(Long data5) {
        this.data5 = data5;
    }

    public Long getData6() {
        return data6;
    }

    public void setData6(Long data6) {
        this.data6 = data6;
    }

    public Long getData7() {
        return data7;
    }

    public void setData7(Long data7) {
        this.data7 = data7;
    }

    public Long getData8() {
        return data8;
    }

    public void setData8(Long data8) {
        this.data8 = data8;
    }

    public Long getData9() {
        return data9;
    }

    public void setData9(Long data9) {
        this.data9 = data9;
    }

    public Long getData10() {
        return data10;
    }

    public void setData10(Long data10) {
        this.data10 = data10;
    }

    public Long getData11() {
        return data11;
    }

    public void setData11(Long data11) {
        this.data11 = data11;
    }

    public Long getData12() {
        return data12;
    }

    public void setData12(Long data12) {
        this.data12 = data12;
    }

    public Long getData13() {
        return data13;
    }

    public void setData13(Long data13) {
        this.data13 = data13;
    }

    public Long getData14() {
        return data14;
    }

    public void setData14(Long data14) {
        this.data14 = data14;
    }

    public Long getData15() {
        return data15;
    }

    public void setData15(Long data15) {
        this.data15 = data15;
    }

    public Long getData16() {
        return data16;
    }

    public void setData16(Long data16) {
        this.data16 = data16;
    }
}
