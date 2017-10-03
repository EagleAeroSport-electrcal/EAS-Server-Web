package org.erau.eas.serverweb;

import org.erau.eas.serverweb.Repository.ConfigRepository;
import org.erau.eas.serverweb.Repository.DataRepository;
import org.erau.eas.serverweb.Repository.FlightsRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.apache.maven.model.Model;
import org.apache.maven.model.io.xpp3.MavenXpp3Reader;
import org.codehaus.plexus.util.xml.pull.XmlPullParserException;

import java.io.FileReader;
import java.io.IOException;

/**
 * Created by ferrinkatz on 9/17/17.
 */

@RestController
public class RequestController {

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

    @RequestMapping(value = "/data", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> inputData(){

        return new ResponseEntity<Object>("asdf", HttpStatus.OK);
    }
}
