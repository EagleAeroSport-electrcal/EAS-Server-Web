package org.eas.serverweb.Model.CompKeys;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.sql.Timestamp;

@Embeddable
public class DataKey implements Serializable {

    private Timestamp timestamp;

    private Long Id;

    public DataKey() {
    }

    public DataKey(Timestamp timestamp, Long id) {
        this.timestamp = timestamp;
        Id = id;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public Long getId() {
        return Id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DataKey dataKey = (DataKey) o;

        if (!getTimestamp().equals(dataKey.getTimestamp())) return false;
        return getId().equals(dataKey.getId());
    }

    @Override
    public int hashCode() {
        int result = getTimestamp().hashCode();
        result = 31 * result + getId().hashCode();
        return result;
    }
}
