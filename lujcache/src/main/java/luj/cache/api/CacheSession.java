package luj.cache.api;

import luj.cache.api.request.CacheRequest;

public interface CacheSession {

//  <T> CacheContainer<T> createCache(Object cacheParam);

  CacheRequest createRequest();
}
