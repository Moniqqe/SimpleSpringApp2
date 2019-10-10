package com.labyspring.GalleryApplication.properties;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@Configurable
@PropertySource("classpath:global.properties")
public class GlobalProperties {

    @Value("${gallery.path}")
    private String path;

    public String getGalleryPath() {
        return path;
    }
}
