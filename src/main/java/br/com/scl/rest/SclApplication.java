package br.com.scl.rest;

import javax.ws.rs.core.Application;
import java.util.HashMap;
import java.util.Map;

public class SclApplication extends Application {

    public static final String PACKAGE = "br.com.scl.rest";

    @Override
    public Map<String, Object> getProperties() {
        Map<String, Object> properties = new HashMap<>();
        // Configura o pacote para fazer scan das classes com anotações REST.
        properties.put("jersey.config.server.provider.packages", PACKAGE);
        return properties;
    }
}
