package luj.cache.internal.session;

import luj.cache.api.CacheSession;

public interface CacheSessionFactory {

  static CacheSessionFactory get() {
    return new CacheSessionFactoryImpl();
  }

  CacheSession create();
}
