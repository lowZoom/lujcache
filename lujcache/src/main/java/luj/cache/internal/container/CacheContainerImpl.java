package luj.cache.internal.container;

import java.util.Map;
import luj.cache.api.container.CacheContainer;

public class CacheContainerImpl implements CacheContainer {

  public CacheContainerImpl(Map<Object, Object> cacheMap) {
    _cacheMap = cacheMap;
  }

  @SuppressWarnings("unchecked")
  @Override
  public <T> T get(Comparable<?> key) {
    return (T) _cacheMap.get(key);
  }

  @Override
  public void put(Comparable<?> key, Object value) {
    _cacheMap.put(key, value);
  }

  private final Map<Object, Object> _cacheMap;
}
