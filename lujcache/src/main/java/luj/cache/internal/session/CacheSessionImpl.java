package luj.cache.internal.session;

import java.util.ArrayList;
import luj.cache.api.CacheSession;
import luj.cache.api.request.CacheRequest;
import luj.cache.api.request.RequestWalkListener;
import luj.cache.internal.request.CacheRequestImpl;
import luj.cache.internal.request.state.RequestState;

final class CacheSessionImpl implements CacheSession {

  CacheSessionImpl(RequestWalkListener requestWalkListener) {
    _requestWalkListener = requestWalkListener;
  }

  @Override
  public CacheRequest createRequest() {
    return new CacheRequestImpl(new RequestState(new ArrayList<>()), _requestWalkListener);
  }

  private final RequestWalkListener _requestWalkListener;
}
