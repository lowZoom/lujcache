package luj.cache.internal.session;

import luj.cache.api.CacheSession;
import org.springframework.context.ApplicationContext;

public interface CacheSessionFactory {

  static CacheSessionFactory get(ApplicationContext appContext) {
    return new CacheSessionFactoryImpl(appContext);
  }

  CacheSession create();
}
