package com.artisan.admin.xxx;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;

/**
 * @author 小工匠
 * @version 1.0
 * @description: TODO
 * @date 2021/5/30 17:36
 * @mark: show me the code , change the world
 */
public class ArtisanServiceHealthIndicator  implements HealthIndicator {
    @Override
    public Health getHealth(boolean includeDetails) {
        return null;
    }

    @Override
    public Health health() {
        return null;
    }
}
    