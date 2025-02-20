package hello.typeconverter;

import hello.typeconverter.controller.IntegerToStringConverter;
import hello.typeconverter.controller.IpPortToStringConverter;
import hello.typeconverter.controller.StringToIntegerConverter;
import hello.typeconverter.controller.StringToIpPortConverter;
import hello.typeconverter.formatter.MyNumberFormatter;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addFormatters(FormatterRegistry registry) {
        // converter 등록
//        registry.addConverter(new StringToIntegerConverter());
//        registry.addConverter(new IntegerToStringConverter());
        registry.addConverter(new StringToIpPortConverter());
        registry.addConverter(new IpPortToStringConverter());
        
        
        // formatter 등록
        registry.addFormatter(new MyNumberFormatter());
    }
}
