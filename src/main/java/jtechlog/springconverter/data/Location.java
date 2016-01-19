package jtechlog.springconverter.data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Location {

    @Id
    private Long id;

    private double lat;

    private double lon;

    public Long getId() {
        return id;
    }

    public double getLat() {
        return lat;
    }

    public double getLon() {
        return lon;
    }
}
