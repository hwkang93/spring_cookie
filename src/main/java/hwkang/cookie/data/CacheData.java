package hwkang.cookie.data;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Getter
@NoArgsConstructor
public class CacheData {

    private String key;

    private String userId;
    private String ip;
    private List<String> list;
    private String useAt;
    private LocalDateTime expirationTime;

    @Builder
    public CacheData(String userId, String ip, List<String> list, String userAt, LocalDateTime expirationTime) {
        this.userId = userId;
        this.ip = ip;
        this.list = list;
        this.expirationTime = expirationTime;

        this.key = userId + "::" + ip;
    }
}
