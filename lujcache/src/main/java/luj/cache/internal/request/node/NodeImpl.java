package luj.cache.internal.request.node;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Function;
import luj.cache.api.request.CacheRequest;

public class NodeImpl implements CacheRequest.Node {

  public NodeImpl(Class<?> dataType, Object nodeOp, Object dataId,
      Function<Object, Object> dataIdGetter, BiConsumer<Object, Object> resultFieldSetter,
      List<NodeImpl> childList) {
    _dataType = dataType;
    _nodeOp = nodeOp;
    _dataId = dataId;
    _dataIdGetter = dataIdGetter;
    _resultFieldSetter = resultFieldSetter;
    _childList = childList;
  }

  public Class<?> getDataType() {
    return _dataType;
  }

  public Object getDataId() {
    return _dataId;
  }

  public Function<Object, Object> getDataIdGetter() {
    return _dataIdGetter;
  }

  public Object getNodeOp() {
    return _nodeOp;
  }

  public BiConsumer<Object, Object> getResultFieldSetter() {
    return _resultFieldSetter;
  }

  public List<NodeImpl> getChildList() {
    return _childList;
  }

  @Override
  public <T1, T2> CacheRequest.Node addChild(Class<T2> dataType,
      BiConsumer<T1, T2> resultFieldSetter, Object op) {
    NodeImpl child = new NodeImpl(dataType, op, null, null,
        (BiConsumer<Object, Object>) resultFieldSetter, new ArrayList<>());
    _childList.add(child);
    return child;
  }

  @Override
  public <T1, T2> CacheRequest.Node addChild(Class<T2> dataType, Object dataId,
      BiConsumer<T1, T2> resultFieldSetter) {
    NodeImpl child = new NodeImpl(dataType, null, dataId, null,
        (BiConsumer<Object, Object>) resultFieldSetter, new ArrayList<>());
    _childList.add(child);

    return child;
  }

  @Override
  public <T1, T2> CacheRequest.Node addChild(Function<?, ?> idGetter, Class<T2> dataType,
      BiConsumer<T1, T2> resultFieldSetter) {
    NodeImpl node = new NodeImpl(dataType, null, null, (Function<Object, Object>) idGetter,
        (BiConsumer<Object, Object>) resultFieldSetter, new ArrayList<>());

    _childList.add(node);
    return node;
  }

  private final Class<?> _dataType;
  private final Object _nodeOp;

  @Deprecated
  private final Object _dataId;

  @Deprecated
  private final Function<Object, Object> _dataIdGetter;

  private final BiConsumer<Object, Object> _resultFieldSetter;

  /////////////////////////////

  private final List<NodeImpl> _childList;
}
