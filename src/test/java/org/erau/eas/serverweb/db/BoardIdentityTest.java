package org.erau.eas.serverweb.db;

import org.junit.Test;
import static org.junit.Assert.*;

public class BoardIdentityTest {
    @Test
    public void getSetTest(){
        BoardIdentity boardIdentity = new BoardIdentity();
        boardIdentity.setId(1);
        boardIdentity.setMacAddress("F85971535746");

        assertEquals(1,boardIdentity.getId());
        assertEquals("F85971535746",boardIdentity.getMacAddress());
    }
}
