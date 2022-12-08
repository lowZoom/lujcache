package luj.cache.internal.session;

import java.util.ArrayList;
import java.util.HashMap;
import luj.cache.api.CacheSession;
import luj.cache.api.container.CacheContainer;
import luj.cache.api.request.CacheRequest;
import luj.cache.internal.container.CacheContainerImpl;
import luj.cache.internal.request.CacheRequestImpl;
import luj.cache.internal.request.node.NodeImpl;
import luj.cache.internal.request.state.RequestState;

final class CacheSessionImpl implements CacheSession {

  @Override
  public CacheContainer createCache() {
    return new CacheContainerImpl(new HashMap<>());
  }

  @Override
  public CacheRequest createRequest(Object reqParam) {
    var state = new RequestState(new ArrayList<>(), reqParam);
    var root = new NodeImpl(null, null, null, null, null, new ArrayList<>());

    return new CacheRequestImpl(state, root);
  }
}
