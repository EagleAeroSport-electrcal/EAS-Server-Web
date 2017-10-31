package org.erau.eas.serverweb;

import org.erau.eas.serverweb.Mappings.ConfigReceiver;
import org.erau.eas.serverweb.Mappings.DataReceiver;
import org.erau.eas.serverweb.Repository.BoardIdentityRepository;
import org.erau.eas.serverweb.Repository.ConfigRepository;
import org.erau.eas.serverweb.Repository.DataRepository;
import org.erau.eas.serverweb.Repository.FlightsRepository;
import org.erau.eas.serverweb.db.BoardIdentity;
import org.erau.eas.serverweb.db.CompKeys.ConfigKey;
import org.erau.eas.serverweb.db.Config;
import org.erau.eas.serverweb.db.Flights;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.apache.maven.model.Model;
import org.apache.maven.model.io.xpp3.MavenXpp3Reader;
import org.codehaus.plexus.util.xml.pull.XmlPullParserException;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.HashMap;
import java.util.LinkedList;

/**
 * Created by ferrinkatz on 9/17/17.
 */

@RestController
public class RequestController {


    //Variable to store current flight
    private Flights flight;

    //Create Logger
    private final Logger log = LoggerFactory.getLogger(this.getClass());

    //Load config database
    @Autowired
    ConfigRepository configRepository;

    //Load data database
    @Autowired
    DataRepository dataRepository;

    //Load flights database
    @Autowired
    FlightsRepository flightsRepository;

    //Load boardidentity database
    @Autowired
    BoardIdentityRepository boardIdentityRepository;

    public RequestController() {
        LocalDate localDate = LocalDate.now(ZoneId.of("America/Phoenix"));
        flight = new Flights();
        flight.setFlightDate(Date.valueOf(localDate));
    }

    //Request a mapping from the tomcat server to $theurl/version
    @RequestMapping(value = "/version")
    String version() throws IOException, XmlPullParserException{
        //Open a maven file reader
        MavenXpp3Reader reader = new MavenXpp3Reader();
        //Load the pom.xml into the reader and save it as a model
        Model model = reader.read(new FileReader("pom.xml"));
        //Log that the version was requested to the log
        log.info("Api version requested and returned as " + model.getVersion());
        //Return the version
        return model.getVersion();
    }

    @RequestMapping(value = "/getid", method = RequestMethod.POST)
    public ResponseEntity<String> getid(@RequestBody() String macAddress){
        BoardIdentity boardIdentity;

        LinkedList<BoardIdentity> allByMacAddress = boardIdentityRepository.getAllByMacAddress(macAddress);

        if(allByMacAddress.isEmpty()){
            boardIdentity = new BoardIdentity();
            boardIdentity.setMacAddress(macAddress);
            boardIdentityRepository.save(boardIdentity);
        }
        else {
            boardIdentity = allByMacAddress.getFirst();
        }

        return ResponseEntity.ok().body(Integer.toString(boardIdentity.getId()));
    }

    @RequestMapping(value = "/getflight", method = RequestMethod.GET)
    public ResponseEntity<String> getFlight(){
        if (!flightsRepository.exists(flight.getId())) {
            flightsRepository.save(flight);
        }

        return ResponseEntity.ok().body(Integer.toString(flight.getId()));
    }

    @RequestMapping(value = "/sensorconfig", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> sensorConfig(@RequestBody ConfigReceiver input){

        String[] sensorSet = input.getBody().split("-{2,}");

        for(int i = 0; i < (sensorSet.length - 1); i++)
        {
            HashMap<String, String> sensorData = new HashMap<String, String>();
            sensorSet[i] = sensorSet[i].trim();
            String[] currentSensor = sensorSet[i].split("\\R");
            for (int j = 0; j < currentSensor.length; j++)
            {
                String[] currentSection = currentSensor[j].split(":");
                currentSection[0]= currentSection[0].trim();
                currentSection[1]= currentSection[1].trim();
                sensorData.put(currentSection[0], currentSection[1]);
            }

            if(sensorData.containsKey("Sensor unique ID"))
            {
                ConfigKey configKey = new ConfigKey(input.getFlightID(), input.getBoardId(), Integer.parseInt(sensorData.get("Sensor unique ID")));
                Config config = new Config();
                config.setKey(configKey);
                config.setType(sensorData.get("Sensor type"));
                config.setCalibration(0);

                configRepository.save(config);
            }
        }

        return ResponseEntity.ok().body(" ");
    }

    @RequestMapping(value = "/data", method = RequestMethod.PUT)
    public ResponseEntity<String> inputData(@RequestBody DataReceiver input){
        System.out.println(input.toString());
        return ResponseEntity.ok().body(" ");
    }
}
