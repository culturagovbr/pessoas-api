package br.gov.cultura.sistema.pessoa.rest.resource;

import java.text.SimpleDateFormat;
import javax.ws.rs.Produces;
import javax.ws.rs.ext.ContextResolver;
import javax.ws.rs.ext.Provider;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig.Feature;

@Provider
@Produces({"application/json"})
public class JacksonConfig implements ContextResolver<ObjectMapper> {
    private final ObjectMapper objectMapper;

    public JacksonConfig() {
        this.objectMapper = (new ObjectMapper()).configure(Feature.WRITE_DATES_AS_TIMESTAMPS, false);
        this.objectMapper.setDateFormat(new SimpleDateFormat("dd/MM/yyyy"));
    }

    public ObjectMapper getContext(Class<?> type) {
        return this.objectMapper;
    }
}
