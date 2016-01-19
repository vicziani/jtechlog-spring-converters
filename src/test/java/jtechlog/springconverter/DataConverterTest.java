package jtechlog.springconverter;

import jtechlog.springconverter.data.LocationService;
import jtechlog.springconverter.data.LocationDto;
import jtechlog.springconverter.data.SpringDataConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringDataConfig.class)
public class DataConverterTest {

    @Autowired
    LocationService locationService;

    @Test
    public void testConvert() {
        Page<LocationDto> locations = locationService.listLocations(new PageRequest(0, 10));
        //assertThat(locations.getNumber(), is(2));
        assertThat(locations.getContent().get(0).lat, is(47.497912));
    }

}
