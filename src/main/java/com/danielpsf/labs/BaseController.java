package com.danielpsf.labs;

import java.net.URI;
import java.net.URISyntaxException;

public abstract class BaseController {

    protected URI getCreatedResourceUri(String resourcePath, Integer id) throws URISyntaxException {
        StringBuilder uri = new StringBuilder();
        uri.append(resourcePath)
           .append("/")
           .append(id);
        return new URI(uri.toString());
    }
}
