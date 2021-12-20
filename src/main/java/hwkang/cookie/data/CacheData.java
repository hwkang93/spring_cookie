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

    private String id;
    private List<String> list;
    private LocalDateTime localDateTime;

    @Builder
    public CacheData(String id, List<String> list, LocalDateTime localDateTime) {
        this.id = id;
        this.list = list;
        this.localDateTime = localDateTime;
    }
}
