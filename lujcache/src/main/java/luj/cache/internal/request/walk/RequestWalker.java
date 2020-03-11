package luj.cache.internal.request.walk;

import luj.cache.api.request.RequestWalkListener;
import luj.cache.internal.request.state.RequestNode;
import luj.cache.internal.request.state.RequestState;

@Deprecated
public class RequestWalker {

  public RequestWalker(RequestState state, RequestWalkListener walkListener) {
    _state = state;
    _walkListener = walkListener;
  }

  public void walk() {
    for (RequestNode node : _state.getRootList()) {
      _walkListener.onWalk(createContext(node));
    }
  }

  private RequestWalkListener.Context createContext(RequestNode node) {
    return null;
  }

  private final RequestState _state;

  private final RequestWalkListener _walkListener;
}
