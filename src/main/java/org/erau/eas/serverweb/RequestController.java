package org.erau.eas.serverweb;

import lombok.extern.slf4j.Slf4j;
import org.erau.eas.serverweb.recievers.ConfigReceiver;
import org.erau.eas.serverweb.recievers.DataReceiver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.UUID;

/**
 * Created by ferrinkatz on 9/17/17.
 *
 **/

@Slf4j
@RestController
public class RequestController {
    LocalDate localDate;

    @Autowired
    public RequestController() {
        LocalDate localDate = LocalDate.now(ZoneId.of("America/Phoenix"));
    }

    @RequestMapping(value = "/getid", method = RequestMethod.POST)
    public ResponseEntity<String> getid(@RequestBody() String macAddress){

  Jedis jedis = new Jedis("localhost");
  String id = null;

        try {
          if(jedis.get(macAddress) == null) {

            UUID newID = UUID.randomUUID();
            id = newID.toString();
            jedis.set(macAddress, id);
          }else {

            id = jedis.get(macAddress);

          }
        }
        catch(Exception e){

        }

        return id;
    }

    @RequestMapping(value = "/getflight", method = RequestMethod.GET)
    public ResponseEntity<String> getFlight(){
        return null;
    }

    @RequestMapping(value = "/sensorconfig", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> sensorConfig(@RequestBody ConfigReceiver input){
        return null;
    }

    @RequestMapping(value = "/dataput", method = RequestMethod.PUT)
    public ResponseEntity<String> inputData(@RequestBody DataReceiver input){
        return null;
    }
}
