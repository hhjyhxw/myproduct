package zhumeng.com.uimei.config.datasource.shares;

import java.util.Collection;
import java.util.LinkedHashSet;

import com.dangdang.ddframe.rdb.sharding.api.ShardingValue;
import com.dangdang.ddframe.rdb.sharding.api.strategy.database.SingleKeyDatabaseShardingAlgorithm;
import com.google.common.collect.Range;

/**
 * 分库策略的简单实现
 */
public class ModuloDatabaseShardingAlgorithm implements SingleKeyDatabaseShardingAlgorithm<Long> {

    public String doEqualSharding(Collection<String> databaseNames, ShardingValue<Long> shardingValue) {
        for (String each : databaseNames) {
            if (each.endsWith(Long.parseLong(shardingValue.getValue().toString()) % 2 + "")) {
                return each;
            }
        }
        throw new IllegalArgumentException();
    }

    public Collection<String> doInSharding(Collection<String> databaseNames, ShardingValue<Long> shardingValue) {
        Collection<String> result = new LinkedHashSet<String>(databaseNames.size());
        for (Long value : shardingValue.getValues()) {
            for (String tableName : databaseNames) {
                if (tableName.endsWith(value % 2 + "")) {
                    result.add(tableName);
                }
            }
        }
        return result;
    }

    public Collection<String> doBetweenSharding(Collection<String> databaseNames, ShardingValue<Long> shardingValue) {
        Collection<String> result = new LinkedHashSet<String>(databaseNames.size());
        Range<Long> range = (Range<Long>) shardingValue.getValueRange();
        for (Long i = range.lowerEndpoint(); i <= range.upperEndpoint(); i++) {
            for (String each : databaseNames) {
                if (each.endsWith(i % 2 + "")) {
                    result.add(each);
                }
            }
        }
        return result;
    }
}

