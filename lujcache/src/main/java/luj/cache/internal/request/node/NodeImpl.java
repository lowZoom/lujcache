package luj.cache.internal.request.node;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Function;
import luj.cache.api.request.CacheRequest;
import luj.cache.internal.request.CacheRequestImpl;

public class NodeImpl implements CacheRequest.Node {

  public NodeImpl(Class<?> dataType, Object dataId, Function<?, ?> dataIdGetter,
      BiConsumer<Object, Object> resultFieldSetter,
      List<NodeImpl> childList) {
    _dataType = dataType;
    _dataId = dataId;
    _dataIdGetter = dataIdGetter;
    _resultFieldSetter = resultFieldSetter;
    _childList = childList;
  }

  @Override
  public <T1, T2> CacheRequest.Node addChild(Class<T2> dataType, Object dataId,
      BiConsumer<T1, T2> resultFieldSetter) {
    NodeImpl child = new NodeImpl(dataType, dataId, null,
        (BiConsumer<Object, Object>) resultFieldSetter, new ArrayList<>());
    _childList.add(child);

    _req.addNode(dataType, dataId, resultFieldSetter);

    return child;
  }

  @Override
  public void addChild(Function<?, ?> idGetter, BiConsumer<?, ?> resultFieldSetter) {
    NodeImpl node = new NodeImpl(null, null, idGetter,
        (BiConsumer<Object, Object>) resultFieldSetter, new ArrayList<>());
    _childList.add(node);
//    return child;
  }

  private final Class<?> _dataType;

  private final Object _dataId;
  private final Function<?, ?> _dataIdGetter;

  private final BiConsumer<Object, Object> _resultFieldSetter;

  private final List<NodeImpl> _childList;

  @Deprecated
  public CacheRequestImpl _req;
}
