package hwkang.cookie;

import hwkang.cookie.data.CacheData;
import hwkang.cookie.repository.CacheRepository;
import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cache.CacheManager;

@SpringBootTest
public class CacheRepositoryTest {

    @Autowired
    CacheRepository cacheRepository;

    @Autowired
    CacheManager cacheManager;

    @Test
    void 캐싱_안돼있고_디비에도_없으면_에러발생() {
        CacheData cacheData = CacheData.builder()
                .userId("hwkang")
                .ip("10.47.40.111")
                .build();

        assertThrows(Exception.class, () -> cacheRepository.get(cacheData.getKey()));
    }

    @Test
    void 캐싱_안돼있고_디비에_있으면_캐싱데이터에_추가후_데이터_리턴() throws Exception{
        CacheData requestData = CacheData.builder()
                .userId("user1")
                .ip("1.1.1.1")
                .build();

        //로그에 찍혀야 함
        System.out.println("이 다음 줄에 로그 나와야 함");
        CacheData responseData = cacheRepository.get(requestData.getKey());
        assertThat(requestData.getKey().equals(responseData.getKey()));

        //로그에 안찍혀야 함
        System.out.println("이 다음 줄에 로그 나오면 안됨");
        CacheData responseData2 = cacheRepository.get(requestData.getKey());
        assertThat(responseData2.getKey().equals(responseData.getKey()));

    }
}
