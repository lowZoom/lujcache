package luj.cache.internal.request;

import luj.cache.api.request.CacheRequest;
import luj.cache.api.request.RequestWalkListener;
import luj.cache.internal.request.node.NodeImpl;
import luj.cache.internal.request.state.RequestState;
import luj.cache.internal.request.walk.RequestWalker;

public class CacheRequestImpl implements CacheRequest {

  public CacheRequestImpl(RequestState state, NodeImpl root) {
    _state = state;
    _root = root;
  }

  @Override
  public Node getRoot() {
    return _root;
  }

  @Override
  public void walk(RequestWalkListener listener) {
    new RequestWalker(_root, _state.getRequestParam(), listener).walk();
  }

  private final RequestState _state;

  private final NodeImpl _root;
}
