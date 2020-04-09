package luj.cache.internal.session;

import luj.cache.api.CacheSession;
import org.springframework.context.ApplicationContext;

final class CacheSessionFactoryImpl implements CacheSessionFactory {

  CacheSessionFactoryImpl(ApplicationContext appContext) {
    _appContext = appContext;
  }

  @Override
  public CacheSession create() {
    return new CacheSessionImpl();
  }

  private final ApplicationContext _appContext;
}
