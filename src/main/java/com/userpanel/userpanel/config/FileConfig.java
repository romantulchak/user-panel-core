package com.userpanel.userpanel.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.io.File;

@Configuration
public class FileConfig implements WebMvcConfigurer {

    @Value("${user.panel.path.pattern}")
    private String pathPattern;

    @Value("${user.panel.files.location}")
    private String location;

    @Value("${user.panel.files.folder}")
    private String folderPath;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        createMainFolder();
        registry.addResourceHandler(pathPattern)
                .addResourceLocations(location)
                .setCachePeriod(0)
                .resourceChain(true)
                .addResolver(new CustomPathResourceResolver());
    }

    private void createMainFolder(){
        File file = new File(folderPath);
        if (!file.exists()){
            file.mkdir();
        }
    }
}
