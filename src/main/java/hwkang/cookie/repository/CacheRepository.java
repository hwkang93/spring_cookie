package hwkang.cookie.repository;

import hwkang.cookie.data.CacheNames;
import hwkang.cookie.data.CacheData;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

@Slf4j
@RequiredArgsConstructor
@Repository
public class CacheRepository {

    private final DataRepository dataRepository;

    /**
     * @Cacheable : 캐시가 있다면 캐시 값을 리턴하고 없다면 메소드 내부 로직 실행
     */
    @Cacheable(cacheNames = CacheNames.API_CERTIFY, key = "#key")
    public CacheData get(final String key) throws Exception {
        log.info("캐싱돼있지 않으면 여기로 옴");

        return dataRepository.findByKey(key);
    }

/*
    @CachePut(cacheNames = CacheNames.REGISTRATION_USER, key = "#key")
    public CacheData update(final String key, CacheData cacheData) {
        log.info("캐시 업데이트");

        return cacheData;
    }
*/

    // 권한이 아예 없는 경우는 ?

    /**
     *  사용 여부가 바뀌는 경우
     */
    @CacheEvict(cacheNames = CacheNames.API_CERTIFY, key = "#key")
    public boolean delete(final String key) {
        log.info("캐시를 지움");

        return true;
    }

    /**
     * 운영자가 해당 사용자를 삭제한 경우
     * 접근 가능한 API 가 변경된 경우
     * 만료 기한이 지난 경우
     */
    @CacheEvict(cacheNames = CacheNames.API_CERTIFY, allEntries = true)
    public boolean deleteAll() {
        log.info("delete all cache");

        return true;
    }
}
