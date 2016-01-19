package jtechlog.springconverter.data;


import org.springframework.core.convert.converter.Converter;

public class LocationConverter implements Converter<Location, LocationDto> {

    @Override
    public LocationDto convert(Location location) {
        LocationDto locationDto = new LocationDto();
        locationDto.id = location.getId();
        locationDto.lat = location.getLat();
        locationDto.lon = location.getLon();
        return locationDto;
    }
}
