package jtechlog.springconverter;

import org.junit.Test;

import java.time.LocalDate;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class GasHourTest {

    @Test
    public void testParse() {
        GasHour gasHour = GasHour.parse("2015-11-11 5.");
        assertThat(gasHour.getDate(), is(LocalDate.parse("2015-11-11")));
        assertThat(gasHour.getHour(), is(5));

        gasHour = GasHour.parse("2015-11-11 11.");
        assertThat(gasHour.getDate(), is(LocalDate.parse("2015-11-11")));
        assertThat(gasHour.getHour(), is(11));
    }
}
