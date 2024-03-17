package com.davidticona.ent.config;

import java.util.Arrays;
import java.util.List;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

/**
 *
 * @author David Tomas Ticona Saravia
 */
@Configuration
public class WebConfig {
    @Bean
    public FilterRegistrationBean<CorsFilter> corsFilterRegistrationBean() {
        List<String> all = Arrays.asList("*");
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        corsConfiguration.setAllowedOriginPatterns(all);
        corsConfiguration.setAllowedHeaders(all);
        corsConfiguration.setAllowedMethods(all);
        corsConfiguration.setAllowCredentials(true);

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", corsConfiguration);
        CorsFilter corsFilter = new CorsFilter(source);
        FilterRegistrationBean<CorsFilter> filterBean = new FilterRegistrationBean<>(corsFilter);
        filterBean.setOrder(Ordered.HIGHEST_PRECEDENCE);
        return filterBean;
    }
}
