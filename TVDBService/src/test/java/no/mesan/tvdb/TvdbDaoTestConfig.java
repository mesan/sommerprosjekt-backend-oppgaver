package no.mesan.tvdb;

import javax.sql.DataSource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.XADataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.web.ErrorMvcAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

/**
 * Spring boot configuration for DAO-tests.
 */
@Configuration
@ComponentScan({
        "no.mesan.tvdb.shows.dao",
        "no.mesan.tvdb.episodes.dao",
        "no.mesan.tvdb.seasons.dao"
})
@EnableAutoConfiguration(
        exclude = {
                ErrorMvcAutoConfiguration.class,
                DataSourceAutoConfiguration.class,
                XADataSourceAutoConfiguration.class
        })
public class TvdbDaoTestConfig {

    public static void main(final String[] args) {
        SpringApplication.run(TvdbDaoTestConfig.class, args);
    }

    private static void setProperty(final String key, final String value) {
        if (System.getProperty(key) == null) {
            System.setProperty(key, value);
        }
    }

    @Bean
    public JdbcTemplate tvdbJdbcTemplate(final DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }

    @Bean
    public NamedParameterJdbcTemplate tvdbNamedTemplate(final JdbcTemplate tvdbJdbcTemplate) {
        return new NamedParameterJdbcTemplate(tvdbJdbcTemplate);
    }

    /**
     * Setting up the datasource using a HyperSQL (hsqldb) in memory database.
     */
    @Bean
    public DataSource dataSource()
    {
        return new EmbeddedDatabaseBuilder()
                .setName("DAOTEST")
                .setScriptEncoding("UTF-8")
                .ignoreFailedDrops(true)
                .addScript("schema.sql")
                .setType(EmbeddedDatabaseType.HSQL)
                .build();
    }

}
