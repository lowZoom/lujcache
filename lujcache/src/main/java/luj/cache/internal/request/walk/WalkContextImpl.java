package luj.cache.internal.request.walk;

import java.util.Collection;
import java.util.function.BiConsumer;
import java.util.function.Function;
import luj.cache.api.request.RequestWalkListener;
import luj.cache.internal.request.node.NodeImpl;

final class WalkContextImpl implements RequestWalkListener.Context {

  WalkContextImpl(NodeImpl node, Object requestParam, Object parentReturn) {
    _node = node;
    _requestParam = requestParam;
    _parentReturn = parentReturn;
  }

  @Override
  public Class<?> getDataType() {
    return _node.getDataType();
  }

  @SuppressWarnings("unchecked")
  @Override
  public <T> T getDataId() {
    return (T) _node.getDataId();
  }

  @Override
  public Function<Object, Object> getDataIdGetter() {
    return _node.getDataIdGetter();
  }

  @Override
  public BiConsumer<Object, Object> getFieldSetter() {
    return _node.getResultFieldSetter();
  }

  @SuppressWarnings("unchecked")
  @Override
  public <T> T getRequestParam() {
    return (T) _requestParam;
  }

  @SuppressWarnings("unchecked")
  @Override
  public <T> T getParentReturn() {
    return (T) _parentReturn;
  }

  private final NodeImpl _node;

  private final Object _requestParam;
  private final Object _parentReturn;
}
