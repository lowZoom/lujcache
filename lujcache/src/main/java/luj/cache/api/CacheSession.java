package luj.cache.api;

import luj.cache.api.container.CacheContainer;
import luj.cache.api.request.CacheRequest;

public interface CacheSession {

  CacheContainer createCache();

  CacheRequest createRequest(Object reqParam);
}
