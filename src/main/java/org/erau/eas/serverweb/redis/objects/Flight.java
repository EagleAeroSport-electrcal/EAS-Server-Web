package org.erau.eas.serverweb.redis.objects;

@Data
@RedisHash("Flight")
public class Flight {
    @Id
    String flightData;
}
