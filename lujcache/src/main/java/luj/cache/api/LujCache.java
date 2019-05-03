package luj.cache.api;

import luj.cache.internal.session.CacheSessionFactory;
import org.springframework.context.ApplicationContext;

public enum LujCache {
  ;

  public static CacheSession start(ApplicationContext appContext) {
    return CacheSessionFactory.get(appContext).create();
  }
}
