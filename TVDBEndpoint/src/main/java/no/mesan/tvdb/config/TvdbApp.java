package no.mesan.tvdb.config;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.XADataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.web.ErrorMvcAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("no.mesan.tvdb")
@EnableAutoConfiguration(
    exclude = {
        ErrorMvcAutoConfiguration.class,
        DataSourceAutoConfiguration.class,
        XADataSourceAutoConfiguration.class
    })
public class TvdbApp extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(final SpringApplicationBuilder application) {
        return application.sources(TvdbApp.class);
    }

    public static void main(final String[] args) {
        setProperty("LOG_PATH", "C:\\logs");

        final SpringApplicationBuilder builder = new SpringApplicationBuilder(TvdbApp.class);
        new TvdbApp().configure(builder).run(args);
    }

    private static void setProperty(final String key, final String value) {
        if (System.getProperty(key) == null) {
            System.setProperty(key, value);
        }
    }
}
