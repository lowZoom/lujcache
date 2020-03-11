package luj.cache.internal.request.walk;

import java.util.function.BiConsumer;
import luj.cache.api.request.RequestWalkListener;
import luj.cache.internal.request.node.NodeImpl;

final class WalkContextImpl implements RequestWalkListener.Context {

  WalkContextImpl(NodeImpl node, Object requestParam) {
    _node = node;
    _requestParam = requestParam;
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
  public BiConsumer<Object, Object> getFieldSetter() {
    return _node.getResultFieldSetter();
  }

  @SuppressWarnings("unchecked")
  @Override
  public <T> T getRequestParam() {
    return (T) _requestParam;
  }

  private final NodeImpl _node;

  private final Object _requestParam;
}
