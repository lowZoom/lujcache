package luj.cache.example.core.data;

import com.google.common.collect.ImmutableMap;
import java.util.HashMap;
import java.util.Map;
import luj.cache.example.module.player.data.PlayerDb;

public enum ExampleDataManager {
  SINGLETON;

  public Object findData(Class<?> dataType, Long dataId) {
    Map<Long, Object> subMap = _dataMap.getOrDefault(dataType, ImmutableMap.of());
    return subMap.get(dataId);
  }

  ExampleDataManager() {
    _dataMap = new HashMap<>();
    addPlayerDb(101L);
    addPlayerDb(201L);
  }

  private void addPlayerDb(Long id) {
    _dataMap.putIfAbsent(PlayerDb.class, new HashMap<>());
    Map<Long, Object> subMap = _dataMap.get(PlayerDb.class);
    subMap.put(id, new PlayerDb() {
      @Override
      public Long playerId() {
        return id;
      }
    });
  }

  private final Map<Class<?>, Map<Long, Object>> _dataMap;
}
