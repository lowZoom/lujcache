package luj.cache.internal.request;

import java.util.function.BiConsumer;
import luj.cache.api.request.CacheRequest;
import luj.cache.api.request.RequestWalkListener;
import luj.cache.internal.request.add.RequestNodeAdder;
import luj.cache.internal.request.state.RequestState;
import luj.cache.internal.request.walk.RequestWalker;

public class CacheRequestImpl implements CacheRequest {

  public CacheRequestImpl(RequestState state, RequestWalkListener walkListener) {
    _state = state;
    _walkListener = walkListener;
  }

  @Override
  public <T1, T2> void addNode(Class<T2> dataType,
      Object dataId, BiConsumer<T1, T2> resultFieldSetter) {
    new RequestNodeAdder(_state, dataType, dataId, resultFieldSetter).add();
  }

  @Override
  public void walk() {
    new RequestWalker(_state, _walkListener).walk();
  }

  private final RequestState _state;

  private final RequestWalkListener _walkListener;
}
