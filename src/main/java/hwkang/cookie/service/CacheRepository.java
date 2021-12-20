package hwkang.cookie.service;

import hwkang.cookie.data.CacheData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;

import java.time.LocalDateTime;
import java.util.ArrayList;

@Slf4j
public class CacheRepository {

    private final CacheData EMPTY_DATA = new CacheData();

    @Cacheable(cacheNames = "cacheExample", key = "#key")
    public CacheData get(final String key) {
        log.info("key 에 대한 캐시가 없음");
        return EMPTY_DATA;
    }

    @CachePut(cacheNames = "cacheExample", key = "#key")
    public CacheData update(final String key, final String value) {
        log.info("캐시 업데이트");
        CacheData cacheData = CacheData.builder()
                .id("업데이트_아이디")
                .list(new ArrayList<>())
                .localDateTime(LocalDateTime.now())
                .build();

        return cacheData;
    }

    @CacheEvict(cacheNames = "cacheExample", key = "#key")
    public boolean delete(final String key) {
        log.info("캐시를 지움");
        return true;
    }
}
