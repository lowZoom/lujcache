package luj.cache.internal.request.add;

import java.util.function.BiConsumer;
import luj.cache.internal.request.state.RequestNode;
import luj.cache.internal.request.state.RequestState;

@Deprecated
public class RequestNodeAdder {

  public RequestNodeAdder(RequestState state, Class<?> dataType, Object dataId,
      BiConsumer<?, ?> resultFieldSetter) {
    _state = state;
    _dataType = dataType;
    _dataId = dataId;
    _resultFieldSetter = resultFieldSetter;
  }

  public void add() {
    RequestNode node = new RequestNode(_dataType, _dataId,
        (BiConsumer<Object, Object>) _resultFieldSetter);
    _state.getRootList().add(node);
  }

  private final RequestState _state;

  private final Class<?> _dataType;
  private final Object _dataId;
  private final BiConsumer<?, ?> _resultFieldSetter;
}
