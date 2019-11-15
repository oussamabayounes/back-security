package com.dpc.Scolarity.Config;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.MultipartConfigElement;


import org.modelmapper.ModelMapper;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.ByteArrayHttpMessageConverter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.accept.ContentNegotiationManagerFactoryBean;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.mvc.method.annotation.ExceptionHandlerExceptionResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;


@Configuration
@EnableWebMvc
@ComponentScan
public class WebMvcConfiguration extends WebMvcConfigurerAdapter {

    /**
     * Configure Exception resolvers
     *
     * @param exceptionResolvers
     */

    static final Long MAXFILESIZEUPLOAD = 60_000_000L;

    @Override
    public void configureHandlerExceptionResolvers(List<HandlerExceptionResolver> exceptionResolvers) {
        exceptionResolvers.add(exceptionHandlerExceptionResolver());
    }

    /**
     * Configure list of converter
     *
     * @param converters
     */
 
    /**
     * Create JSON converter by using Jackson
     *
     * @return MappingJackson2HttpMessageConverter
     */
    @Bean
    public MappingJackson2HttpMessageConverter mappingJacksonHttpMessageConverter() {
        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
        converter.setPrettyPrint(true);
        return converter;
    }

    /**
     * Create Exception resolver
     *
     * @return ExceptionHandlerExceptionResolver
     */
    @Bean
    public ExceptionHandlerExceptionResolver exceptionHandlerExceptionResolver() {
        ExceptionHandlerExceptionResolver resolver = new ExceptionHandlerExceptionResolver();
        List<HttpMessageConverter<?>> converters = resolver.getMessageConverters();

        converters.add(mappingJacksonHttpMessageConverter());
        resolver.setMessageConverters(converters);

        ContentNegotiationManagerFactoryBean contentNegotiationManager = new ContentNegotiationManagerFactoryBean();
        contentNegotiationManager.addMediaType("json", MediaType.APPLICATION_JSON);
        contentNegotiationManager.afterPropertiesSet();
        resolver.setContentNegotiationManager(contentNegotiationManager.getObject());

        return resolver;
    }

    @Override
    public void configurePathMatch(PathMatchConfigurer configurer) {
        configurer.setUseSuffixPatternMatch(false);
    }

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addRedirectViewController("/docApi/v2/api-docs", "/v2/api-docs");
        registry.addRedirectViewController("/docApi/swagger-resources/configuration/ui",
                "/swagger-resources/configuration/ui");
        registry.addRedirectViewController("/docApi/swagger-resources/configuration/security",
                "/swagger-resources/configuration/security");
        registry.addRedirectViewController("/docApi/swagger-resources", "/swagger-resources");
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/docApi/swagger-ui.html**")
                .addResourceLocations("classpath:/META-INF/resources/swagger-ui.html");
        registry.addResourceHandler("/docApi/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");

        //registry.addResourceHandler("/icons/**").addResourceLocations("/icons/", "classpath:/icons/");


    }
 
     
        
        



    @Bean
    InternalResourceViewResolver viewResolverRegistry() {
        return new InternalResourceViewResolver();
    }
    
	/*
	 * @Bean DataSource dataSource() throws SQLException { OracleDataSource
	 * dataSource = new OracleDataSource(); dataSource.setUser("SCOLARITY");
	 * dataSource.setPassword("SCOLARITY");
	 * dataSource.setURL("@//207.180.211.160:1521/ORCL");
	 * dataSource.setImplicitCachingEnabled(true);
	 * dataSource.setFastConnectionFailoverEnabled(true); return dataSource; }
	 */
    
}
