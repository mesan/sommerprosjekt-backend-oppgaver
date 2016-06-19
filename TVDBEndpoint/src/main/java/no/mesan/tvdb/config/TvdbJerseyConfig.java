package no.mesan.tvdb.config;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.ext.MessageBodyReader;
import javax.ws.rs.ext.MessageBodyWriter;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;

import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;

@Configuration
@ApplicationPath("/api")
public class TvdbJerseyConfig extends ResourceConfig {

    public TvdbJerseyConfig() {
        packages("no.mesan.tvdb");

        register(JacksonJsonProvider.class, MessageBodyReader.class, MessageBodyWriter.class);
    }
}
