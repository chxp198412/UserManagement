package org.rothurtech.usermanagement.config;

import org.springframework.cache.CacheManager;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CacheConfig {

    //    the default cache manager is ConcurrentMapCacheManager, which internally is a ConcurrentHashMap
    @Bean
    public CacheManager cacheManager() {
        return new ConcurrentMapCacheManager("usersCache");
    }
}
