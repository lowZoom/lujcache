package luj.cache.internal.request.walk;

import java.util.function.BiConsumer;
import luj.cache.api.request.RequestWalkListener;
import luj.cache.internal.request.state.RequestNode;
import luj.cache.internal.request.state.RequestState;

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
    return new RequestWalkListener.Context() {
      @Override
      public Class<?> getDataType() {
        return node.getDataType();
      }

      @Override
      public <T> T getDataId() {
        return (T) node.getDataId();
      }

      @Override
      public BiConsumer<Object, Object> getFieldSetter() {
        return node.getFieldSetter();
      }

      @Override
      public <T> T getRequestParam() {
        return (T) _state.getRequestParam();
      }
    };
  }

  private final RequestState _state;

  private final RequestWalkListener _walkListener;
}
