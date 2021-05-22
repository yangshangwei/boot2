package com.artisan.impt;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @author 小工匠
 * @version 1.0
 * @description: TODO
 * @date 2021/5/22 9:25
 * @mark: show me the code , change the world
 */
public class ArtisanImportSelector implements ImportSelector {


    @Override
    public String[] selectImports(AnnotationMetadata annotationMetadata) {
        return new String[]{"com.artisan.beans.Artisan"};
    }
}
    