package jtechlog.springconverter;

import org.springframework.core.convert.converter.Converter;

public class GasHourConverter implements Converter<String, GasHour> {

    @Override
    public GasHour convert(String s) {
        return GasHour.parse(s);
    }
}
