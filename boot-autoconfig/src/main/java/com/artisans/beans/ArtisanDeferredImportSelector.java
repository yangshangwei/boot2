package com.artisans.beans;

import org.springframework.context.annotation.DeferredImportSelector;
import org.springframework.core.type.AnnotationMetadata;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

/**
 * @author 小工匠
 * @version 1.0
 * @date 2022/4/12 23:46
 * @mark: show me the code , change the world
 */


public class ArtisanDeferredImportSelector implements DeferredImportSelector {


    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        return new String[]{"com.artisans.beans.ArtisanBean"};
    }

    @Override
    public Predicate<String> getExclusionFilter() {
        return null;
    }


    /**
     * 如果getImportGroup返回自定义Group ， 会调用自定义Group的process方法
     * <p>
     * 如果getImportGroup返回 null,会调用DefaultDeferredImportSelectorGroup的process方法,即调用selectImports
     *
     * @return clazz
     */
    @Override
    public Class<? extends Group> getImportGroup() {
        // 这个返回值决定调用DeferredImportSelector#selectImports  如果null
        // 还是调用Group.selectImports
        return ArtisanGroup.class;
    }


    /**
     * 分组利用归类，同一组的bean只影响本组的顺序
     */
    public class ArtisanGroup implements DeferredImportSelector.Group {

        public ArtisanGroup(AnnotationMetadata metadata) {
            this.metadata = metadata;
        }

        AnnotationMetadata metadata;

        @Override
        public void process(AnnotationMetadata metadata, DeferredImportSelector selector) {
            this.metadata = metadata;
        }

        @Override
        public Iterable<Entry> selectImports() {
            List list = new ArrayList();
            list.add(new Entry(metadata, "com.artisans.beans.ArtisanBean"));
            return null;
        }
    }
}
    