package com.userpanel.userpanel.config;

import lombok.NonNull;
import org.springframework.core.io.Resource;
import org.springframework.web.servlet.resource.PathResourceResolver;
import org.springframework.web.servlet.resource.ResourceResolver;

import java.io.IOException;

public class CustomPathResourceResolver extends PathResourceResolver implements ResourceResolver {
    @Override
    protected Resource getResource(String resourcePath, @NonNull Resource location) throws IOException {
        return super.getResource(resourcePath.replace("%2520", "%20"), location);
    }
}
