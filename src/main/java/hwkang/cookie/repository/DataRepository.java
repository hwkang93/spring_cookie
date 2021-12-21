package hwkang.cookie.repository;

import hwkang.cookie.data.CacheData;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

@Repository
public class DataRepository {
    List<CacheData> cacheDataList = Arrays.asList(
            CacheData.builder().userId("user1").ip("1.1.1.1").list(Arrays.asList("A","B","C","D","E")).build(),
            CacheData.builder().userId("user2").ip("2.2.2.2").list(Arrays.asList("A","B","C","D","E")).build(),
            CacheData.builder().userId("user3").ip("3.3.3.3").list(Arrays.asList("A","B","C","D","E")).build(),
            CacheData.builder().userId("user4").ip("4.4.4.4").list(Arrays.asList("A","B","C","D","E")).build(),
            CacheData.builder().userId("user5").ip("5.5.5.5").list(Arrays.asList("A","B","C","D","E")).build(),
            CacheData.builder().userId("user6").ip("6.6.6.6").list(Arrays.asList("A","B","C","D","E")).build(),
            CacheData.builder().userId("user7").ip("7.7.7.7").list(Arrays.asList("A","B","C","D","E")).build(),
            CacheData.builder().userId("user8").ip("8.8.8.8").list(Arrays.asList("A","B","C","D","E")).build(),
            CacheData.builder().userId("user9").ip("9.9.9.9").list(Arrays.asList("A","B","C","D","E")).build(),
            CacheData.builder().userId("user10").ip("10.10.10.10").list(Arrays.asList("A","B","C","D","E")).build()
    );

    public CacheData findByKey(String key) throws Exception {
        return cacheDataList.stream()
                .filter(cacheData -> cacheData.getKey().equals(key))
                .findFirst()
                .orElseThrow(() -> new Exception("API 사용 신청이 필요함"));
    }
}
