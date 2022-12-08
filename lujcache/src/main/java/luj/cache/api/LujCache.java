package luj.cache.api;

import luj.cache.internal.session.CacheSessionFactory;

public enum LujCache {
  ;

  public static CacheSession start() {
    return CacheSessionFactory.get().create();
  }
}
