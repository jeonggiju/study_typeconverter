package hello.typeconverter.formatter;

import hello.typeconverter.controller.IpPortToStringConverter;
import hello.typeconverter.controller.StringToIpPortConverter;
import hello.typeconverter.type.IpPort;
import org.junit.jupiter.api.Test;
import org.springframework.format.support.DefaultFormattingConversionService;

import static org.assertj.core.api.Assertions.assertThat;

public class FormattingConversionServiceTest {

    @Test
    void formattingConversionService(){

        DefaultFormattingConversionService conversionService = new DefaultFormattingConversionService();

        // 컨버터 등록
        conversionService.addConverter(new StringToIpPortConverter());
        conversionService.addConverter(new IpPortToStringConverter());

        // 포맷터 등록
        conversionService.addFormatter(new MyNumberFormatter());

        // 컨버터, 포맷터 사용
        IpPort ipPort = conversionService.convert("127.0.0.1:8080", IpPort.class);
        assertThat(ipPort).isEqualTo(new IpPort("127.0.0.1", 8080));


        String toString = conversionService.convert(1000, String.class);
        Long toLong = conversionService.convert("1,000", Long.class);

        assertThat(toString).isEqualTo("1,000");
        assertThat(toLong).isEqualTo(1000L);
    }
}
