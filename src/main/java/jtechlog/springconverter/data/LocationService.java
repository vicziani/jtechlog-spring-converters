package jtechlog.springconverter.data;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class LocationService {

    private LocationDao locationDao;

    public LocationService(LocationDao locationDao) {
        this.locationDao = locationDao;
    }

    public Page<LocationDto> listLocations(Pageable pageable) {
        return locationDao.findAllOrderById(pageable).map(new LocationConverter());
    }
}
