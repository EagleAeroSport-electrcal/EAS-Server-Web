package org.erau.eas.serverweb.redis.repositories;

import org.erau.eas.serverweb.redis.objects.Flight;
import org.springframework.data.repository.CrudRepository;

public interface FlightRepository extends CrudRepository<Flight, String> {
}
