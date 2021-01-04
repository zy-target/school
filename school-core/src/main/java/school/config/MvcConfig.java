package school.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import school.http.JacksonConverterCommon;
import school.intercepter.LoginIntercepter;

import java.util.List;

@Configuration
public class MvcConfig extends WebMvcConfigurationSupport
{
    
    @Override
    protected void addInterceptors(InterceptorRegistry registry)
    {
        registry.addInterceptor(new LoginIntercepter()).addPathPatterns("/**");
    }
    
    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry)
    {
        registry.addResourceHandler(new String[] { "swagger-ui.html" })
                .addResourceLocations(new String[] { "classpath:/META-INF/resources/" });
        registry.addResourceHandler(new String[] { "/webjars/**" })
                .addResourceLocations(new String[] { "classpath:/META-INF/resources/webjars/" });
    }
    
    @Override
    protected void configureMessageConverters(List<HttpMessageConverter<?>> converters)
    {
        converters.add(JacksonConverterCommon.config());
    }
    
//    @Bean
//    public CommonsMultipartResolver commonsMultipartResolver() {
//        CommonsMultipartResolver commonsMultipartResolver = new CommonsMultipartResolver();
//        commonsMultipartResolver.setDefaultEncoding("UTF-8");
//        return commonsMultipartResolver;
//    }
}
