package org.erau.eas.serverweb.Repository;

import org.erau.eas.serverweb.db.CompKeys.ConfigKey;
import org.erau.eas.serverweb.db.Config;
import org.springframework.data.repository.CrudRepository;

public interface ConfigRepository extends CrudRepository<Config, ConfigKey>{

    int countDistinctByKey_BoardIdAndKey_FlightID(int boardId, int FlightId);
}

