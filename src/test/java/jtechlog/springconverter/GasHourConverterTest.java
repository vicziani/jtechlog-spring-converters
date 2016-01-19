package jtechlog.springconverter;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ConversionServiceFactoryBean;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;
import org.springframework.expression.spel.support.StandardTypeConverter;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class GasHourConverterTest {

    ConversionService conversionService;

    @Before
    public void init() {
        ConversionServiceFactoryBean factoryBean = new ConversionServiceFactoryBean();
        factoryBean.setConverters(Collections.singleton(new GasHourConverter()));
        factoryBean.afterPropertiesSet();
        conversionService = factoryBean.getObject();
    }

    @Test
    public void testWithConversationService() {
        GasHour gasHour = conversionService.convert("2011-11-11 5.", GasHour.class);
        assertThat(gasHour, is(GasHour.parse("2011-11-11 5.")));
    }

    @Test
    @SuppressWarnings("unchecked")
    public void testList() {
        // http://stackoverflow.com/questions/7738305/spring-conversion-service-from-lista-to-listb

        List<GasHour> gasHours = (List<GasHour>) conversionService.convert(Arrays.asList("2011-11-11 5.", "2011-11-11 6.", "2011-11-11 7."),
                TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(String.class)),
                TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(GasHour.class)));
        assertThat(gasHours, is(Arrays.asList(GasHour.parse("2011-11-11 5."), GasHour.parse("2011-11-11 6."), GasHour.parse("2011-11-11 7."))));
    }

    @Test
    public void testInSpel() {
        StandardEvaluationContext evaluationContext = new StandardEvaluationContext();
        StandardTypeConverter converter = new StandardTypeConverter(conversionService);
        evaluationContext.setTypeConverter(converter);
        ExpressionParser expressionParser = new SpelExpressionParser();
        GasHour gasHour = expressionParser.parseExpression("'2011-11-11 5.'").getValue(evaluationContext, GasHour.class);
        assertThat(gasHour, is(GasHour.parse("2011-11-11 5.")));
    }

}
