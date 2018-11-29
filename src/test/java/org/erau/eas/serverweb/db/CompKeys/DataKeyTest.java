package org.erau.eas.serverweb.db.CompKeys;

        import org.junit.Test;
        import static org.junit.Assert.*;
        import java.sql.Timestamp;


public class DataKeyTest {
    @Test
    public void getSetTest(){
        DataKey dataKey = new DataKey(Timestamp.valueOf("2018-04-23 12:48:05"), 1, 1, 1);

        assertEquals(Timestamp.valueOf("2018-04-23 12:48:05"), dataKey.getTimestamp());
        assertEquals(1, dataKey.getBoardId());
        assertEquals(1, dataKey.getBoardId());
    }

    @Test
    public void hashCodeTest(){
        DataKey dataKey = new DataKey(Timestamp.valueOf("2018-04-23 12:48:05"),1,1,1);
        assertEquals(587994634,dataKey.hashCode());
    }

    @Test
    public void equalsTest(){
        DataKey dataKey1 = new DataKey(Timestamp.valueOf("2018-04-23 12:48:05"),1,1,1);
        DataKey dataKey2 = new DataKey(Timestamp.valueOf("2018-04-23 12:48:05"),1,1,1);
        DataKey dataKey3 = new DataKey(Timestamp.valueOf("2018-04-23 12:48:06"),2,2,2);

        assertFalse(dataKey1.equals(dataKey3));
        assertTrue(dataKey1.equals(dataKey2));
    }
}
