package org.erau.eas.serverweb.Repository;

import org.erau.eas.serverweb.db.BoardIdentity;
import org.springframework.data.repository.CrudRepository;

import java.util.LinkedList;
import java.util.List;

public interface BoardIdentityRepository extends CrudRepository<BoardIdentity, Integer>{

    LinkedList<BoardIdentity> getAllByMacAddress(String macAddress);
}
