package org.erau.eas.serverweb.db;

import javax.persistence.*;

@Entity
@Table(name = "board_identity")
public class BoardIdentity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "mac_address")
    private String macAddress;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMacAddress() {
        return macAddress;
    }

    public void setMacAddress(String macAddress) {
        this.macAddress = macAddress;
    }
}
