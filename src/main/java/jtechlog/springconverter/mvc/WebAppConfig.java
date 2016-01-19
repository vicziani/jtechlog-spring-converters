package jtechlog.springconverter.mvc;

import jtechlog.springconverter.GasHourConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@EnableWebMvc
public class WebAppConfig extends WebMvcConfigurerAdapter {

    @Bean
    public GasHourController gasHourController() {
        return new GasHourController();
    }

    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(new GasHourConverter());
    }

}
