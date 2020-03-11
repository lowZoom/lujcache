package luj.cache.internal.session;

import java.util.ArrayList;
import luj.cache.api.CacheSession;
import luj.cache.api.container.CacheContainer;
import luj.cache.api.request.CacheRequest;
import luj.cache.api.request.RequestWalkListener;
import luj.cache.internal.container.CacheContainerImpl;
import luj.cache.internal.request.CacheRequestImpl;
import luj.cache.internal.request.node.NodeImpl;
import luj.cache.internal.request.state.RequestState;

final class CacheSessionImpl implements CacheSession {

  CacheSessionImpl(RequestWalkListener requestWalkListener) {
    _requestWalkListener = requestWalkListener;
  }

  @Override
  public CacheContainer createCache(Object cacheParam) {
    return new CacheContainerImpl();
  }

  @Override
  public CacheRequest createRequest(Object reqParam) {
    RequestState state = new RequestState(new ArrayList<>(), reqParam);
    NodeImpl root = new NodeImpl(null, null, null, null, new ArrayList<>());

    return new CacheRequestImpl(state, root, _requestWalkListener);
  }

  private final RequestWalkListener _requestWalkListener;
}
