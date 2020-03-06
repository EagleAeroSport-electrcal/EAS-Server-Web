package org.erau.eas.serverweb;

import lombok.extern.slf4j.Slf4j;
import org.erau.eas.serverweb.recievers.ConfigReceiver;
import org.erau.eas.serverweb.recievers.DataReceiver;
import org.erau.eas.serverweb.redis.objects.BoardID;
import org.erau.eas.serverweb.redis.repositories.BoardIDRepository;
import org.erau.eas.serverweb.redis.repositories.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Optional;

/**
 * Created by ferrinkatz on 9/17/17.
 *
 **/

@Slf4j
@RestController
public class RequestController {
    LocalDate localDate;
    ZoneId currentZoneId = ZoneId.of("America/Phoenix");

    BoardIDRepository boardIDRepository;
    FlightRepository flightRepository;

    @Autowired
    public RequestController(BoardIDRepository boardIDRepository, FlightRepository flightRepository) {
        LocalDate localDate = LocalDate.now(currentZoneId);
        this.boardIDRepository = boardIDRepository;
        this.flightRepository = flightRepository;
    }

    @RequestMapping(value = "/getid", method = RequestMethod.POST)
    public ResponseEntity<String> getid(@RequestBody() String macAddress){
        macAddress = macAddress.replaceAll("[\\s\\-]", "");
        Optional<BoardID> optionalBoardID = boardIDRepository.findById(macAddress);
        if (optionalBoardID.isEmpty()){
            BoardID newBoard = new BoardID(macAddress);
            boardIDRepository.save(newBoard);
            return ResponseEntity.ok(newBoard.getBoardID().toString());
        } else {
            BoardID board = optionalBoardID.get();
            return ResponseEntity.ok(board.getBoardID().toString());
        }

    }

    @RequestMapping(value = "/getflight", method = RequestMethod.GET)
    public ResponseEntity<String> getFlight(){
        String epoch = "" + localDate.atStartOfDay(currentZoneId).toEpochSecond();
        Optional<Flight> optionalFlight = flightRepository.findById(epoch);

        if (optionalFlight.isEmpty()) {
            Flight newFlight = new Flight();
            flightRepository.save(newFlight);
            return ResponseEntity.ok(newFlight.getFlightData);
        }
        else {
            Flight flight = optionalFlight.get();
            return ResponseEntity.ok(flight.getFlightData);
        }
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
