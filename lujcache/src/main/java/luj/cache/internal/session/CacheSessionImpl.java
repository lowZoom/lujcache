package luj.cache.internal.session;

import luj.cache.api.CacheSession;
import luj.cache.api.request.CacheRequest;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

final class CacheSessionImpl implements CacheSession {

  @Override
  public CacheRequest createRequest() {
    throw new NotImplementedException();
  }

//  private final ApplicationContext _appContext;
}
