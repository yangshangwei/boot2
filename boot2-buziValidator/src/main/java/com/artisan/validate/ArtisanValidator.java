package com.artisan.validate;

import com.artisan.annos.NotConflictArtisan;
import com.artisan.annos.UniqueArtisan;
import com.artisan.bean.Artisan;
import com.artisan.repository.ArtisanDao;
import lombok.extern.slf4j.Slf4j;

import javax.annotation.Resource;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.lang.annotation.Annotation;
import java.util.Collection;
import java.util.function.Predicate;

/**
 * @author 小工匠
 * @version 1.0
 * @mark: show me the code , change the world
 */


@Slf4j
public class ArtisanValidator<T extends Annotation> implements ConstraintValidator<T, Artisan> {

    protected Predicate<Artisan> predicate = c -> true;

    @Resource
    protected ArtisanDao artisanDao;

    @Override
    public boolean isValid(Artisan artisan, ConstraintValidatorContext constraintValidatorContext) {
        return artisanDao == null || predicate.test(artisan);
    }

    /**
     * 校验用户是否唯一
     * 即判断数据库是否存在当前新用户的信息，如用户名，手机，邮箱
     */
    public static class UniqueArtisanValidator extends ArtisanValidator<UniqueArtisan> {
        @Override
        public void initialize(UniqueArtisan uniqueArtisan) {
            predicate = c -> !artisanDao.existsByNameOrEmailOrPhone(c.getName(), c.getEmail(), c.getPhone());
        }
    }

    /**
     * 校验是否与其他用户冲突
     * 将用户名、邮件、电话改成与现有完全不重复的，或者只与自己重复的，就不算冲突
     */
    public static class NotConflictArtisanValidator extends ArtisanValidator<NotConflictArtisan> {
        @Override
        public void initialize(NotConflictArtisan notConflictUser) {
            predicate = c -> {
                log.info("user detail is {}", c);
                Collection<Artisan> collection = artisanDao.findByNameOrEmailOrPhone(c.getName(), c.getEmail(), c.getPhone());
                // 将用户名、邮件、电话改成与现有完全不重复的，或者只与自己重复的，就不算冲突
                return collection.isEmpty() || (collection.size() == 1 && collection.iterator().next().getId().equals(c.getId()));
            };
        }
    }
}
    