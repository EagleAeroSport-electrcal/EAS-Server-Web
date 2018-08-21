package org.erau.eas.serverweb.Repository;

import org.erau.eas.serverweb.db.Flight;
import org.springframework.data.repository.CrudRepository;

public interface FlightsRepository extends CrudRepository<Flight, Integer>{
}
