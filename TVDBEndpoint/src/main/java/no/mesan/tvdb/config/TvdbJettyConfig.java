package no.mesan.tvdb.config;

import java.util.Collections;


import org.eclipse.jetty.servlets.CrossOriginFilter;
import org.springframework.boot.context.embedded.FilterRegistrationBean;
import org.springframework.boot.context.embedded.jetty.JettyEmbeddedServletContainerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TvdbJettyConfig {

    @Bean
    public JettyEmbeddedServletContainerFactory jettyEmbeddedServletContainerFactory() {
        final JettyEmbeddedServletContainerFactory factory = new JettyEmbeddedServletContainerFactory();

        return factory;
    }

    @Bean
    public FilterRegistrationBean crossOriginFilter() {
        final FilterRegistrationBean crossOriginFilterRegistrationBean = new FilterRegistrationBean();

        crossOriginFilterRegistrationBean.setFilter(new CrossOriginFilter());
        crossOriginFilterRegistrationBean.setUrlPatterns(Collections.singletonList("/api/*"));

        return crossOriginFilterRegistrationBean;
    }
}
