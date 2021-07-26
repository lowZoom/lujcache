package luj.cache.internal.request.walk;

import java.util.function.BiConsumer;
import java.util.function.Function;
import luj.cache.api.request.RequestWalkListener;
import luj.cache.internal.request.node.NodeImpl;

final class WalkContextImpl implements RequestWalkListener.Context {

  @Override
  public Class<?> getDataType() {
    return _node.getDataType();
  }

  @SuppressWarnings("unchecked")
  @Override
  public <T> T getNode() {
    return (T) _node.getNodeOp();
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

  NodeImpl _node;

  Object _requestParam;
  Object _parentReturn;
}
