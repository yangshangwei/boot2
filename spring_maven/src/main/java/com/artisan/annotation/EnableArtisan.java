package com.artisan.annotation;


import com.artisan.configuration.ArtisanConfig;
import com.artisan.impt.ArtisanImportSelector;
import com.artisan.impt.ArtisanRegistrar;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented

// @Import({ArtisanConfig.class})   @Import({ArtisanImportSelector.class})  都可以
@Import({ArtisanRegistrar.class})
public @interface EnableArtisan {


}
