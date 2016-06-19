package no.mesan.tvdb.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import javax.ws.rs.ext.ContextResolver;
import javax.ws.rs.ext.Provider;

/***
 * Configuration class for ObjectMapper used by Jersey in isolation. The object mapper otherwise autowired is the one
 * found in ObjectMapperConfig.
 * Configures dates to display as "2015-12-11T13:36:57.596+0000" instead of 1449842203688.
 */
@Provider
public class TvdbObjectMapperProviderConfig implements ContextResolver<ObjectMapper> {

    private final ObjectMapper mapper;

    public TvdbObjectMapperProviderConfig() {
        mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
    }

    @Override
    public ObjectMapper getContext(final Class<?> type) {
        return mapper;
    }
}
