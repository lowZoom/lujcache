package luj.cache.internal.session;

import luj.cache.api.CacheSession;

final class CacheSessionFactoryImpl implements CacheSessionFactory {

  @Override
  public CacheSession create() {
    return new CacheSessionImpl();
  }
}
