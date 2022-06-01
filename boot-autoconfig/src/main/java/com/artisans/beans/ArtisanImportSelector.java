package com.artisans.beans;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.stereotype.Component;

import java.util.function.Predicate;

/**
 * @author 小工匠
 * @version 1.0
 * @date 2022/4/13 0:05
 * @mark: show me the code , change the world
 */

@Component
public class ArtisanImportSelector implements ImportSelector {
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        return new String[]{"com.artisans.beans.AA"};
    }

    @Override
    public Predicate<String> getExclusionFilter() {
        return null;
    }
}
    