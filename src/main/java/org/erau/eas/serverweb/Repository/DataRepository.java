package org.erau.eas.serverweb.Repository;

import org.erau.eas.serverweb.db.CompKeys.DataKey;
import org.erau.eas.serverweb.db.Data;
import org.springframework.data.repository.CrudRepository;

public interface DataRepository extends CrudRepository<Data, DataKey>{
}
