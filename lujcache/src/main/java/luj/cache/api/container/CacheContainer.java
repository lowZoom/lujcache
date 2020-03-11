package luj.cache.api.container;

public interface CacheContainer {

  <T> T get(Comparable<?> key);

  void put(Comparable<?> key, Object value);
}
