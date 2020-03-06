package org.erau.eas.serverweb.redis.objects;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

@Data
@RedisHash("Flight")
public class Flight {
    @Id
    private String epochSeconds;

    private String flightData;


    public Flight(String epochSeconds) {
        this.epochSeconds = epochSeconds;
        flightData = "";
    }
}
