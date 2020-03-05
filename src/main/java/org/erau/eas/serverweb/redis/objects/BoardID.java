package org.erau.eas.serverweb.redis.objects;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import java.util.UUID;

@Data
@RedisHash("BoardID")
public class BoardID {
    @Id
    private String macAddress;

    private UUID boardID;


    public BoardID(String macAddress){
        this.macAddress = macAddress;
        this.boardID = UUID.randomUUID();
    }
}