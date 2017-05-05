package own.jadezhang.base.common.domain;

import java.util.Map;

public class ShardingBaseDomain<T> extends CreateBaseDomain<T> {
    /**
     * 分库选库条件数据
     */
    private Map<String, String> shardingMap;

    public Map<String, String> getShardingMap() {
        return shardingMap;
    }

    public void setShardingMap(Map<String, String> shardingMap) {
        this.shardingMap = shardingMap;
    }

}
