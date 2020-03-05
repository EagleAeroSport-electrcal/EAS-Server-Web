package org.erau.eas.serverweb.redis.repositories;

import org.erau.eas.serverweb.redis.objects.BoardID;
import org.springframework.data.repository.CrudRepository;

public interface BoardIDRepository extends CrudRepository<BoardID, String> {
}
