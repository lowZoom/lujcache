package luj.cache.internal.session;

import luj.cache.api.CacheSession;
import luj.cache.api.request.RequestWalkListener;
import org.springframework.context.ApplicationContext;

final class CacheSessionFactoryImpl implements CacheSessionFactory {

  CacheSessionFactoryImpl(ApplicationContext appContext) {
    _appContext = appContext;
  }

  @Override
  public CacheSession create() {
    RequestWalkListener listener = _appContext.getBean(RequestWalkListener.class);
    return new CacheSessionImpl(listener);
  }

  private final ApplicationContext _appContext;
}
