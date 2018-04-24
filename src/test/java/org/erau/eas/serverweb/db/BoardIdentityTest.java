package org.erau.eas.serverweb.db;

import org.junit.Test;

public class BoardIdentityTest {
    @Test
    public void getSetTest(){
        BoardIdentity boardIdentity = new BoardIdentity();
        boardIdentity.setId(1);
        boardIdentity.setMacAddress("F85971535746");
    }
}
