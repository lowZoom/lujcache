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
  public CacheRequest createRequest(Object reqParam) {
    RequestState state = new RequestState(new ArrayList<>(), reqParam);
    return new CacheRequestImpl(state, _requestWalkListener);
  }

  private final RequestWalkListener _requestWalkListener;
}
