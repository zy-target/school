package school.http;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.nio.charset.Charset;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;

public class JacksonConverterCommon {
    public JacksonConverterCommon() {
    }

    public static MappingJackson2HttpMessageConverter config() {
        MappingJackson2HttpMessageConverter jackson2HttpMessageConverter = new MappingJackson2HttpMessageConverter();
        List<MediaType> supportedMediaTypes = new ArrayList();
        supportedMediaTypes.add(MediaType.APPLICATION_JSON);
        supportedMediaTypes.add(MediaType.TEXT_PLAIN);
        ObjectMapper objectMapper = jackson2HttpMessageConverter.getObjectMapper();
        objectMapper.setSerializationInclusion(Include.NON_NULL);
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        objectMapper.setDateFormat(df);
        jackson2HttpMessageConverter.setObjectMapper(objectMapper);
        jackson2HttpMessageConverter.setDefaultCharset(Charset.forName("UTF-8"));
        jackson2HttpMessageConverter.setSupportedMediaTypes(supportedMediaTypes);
        return jackson2HttpMessageConverter;
    }
}
