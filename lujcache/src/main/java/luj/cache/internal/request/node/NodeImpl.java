package luj.cache.internal.request.node;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Function;
import luj.cache.api.request.CacheRequest;

public class NodeImpl implements CacheRequest.Node {

  public NodeImpl(Class<?> dataType, Object dataId,
      Function<Object, Collection<Comparable<?>>> dataIdGetter,
      BiConsumer<Object, Object> resultFieldSetter, List<NodeImpl> childList) {
    _dataType = dataType;
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

  public Function<Object, Collection<Comparable<?>>> getDataIdGetter() {
    return _dataIdGetter;
  }

  public BiConsumer<Object, Object> getResultFieldSetter() {
    return _resultFieldSetter;
  }

  public List<NodeImpl> getChildList() {
    return _childList;
  }

  @Override
  public <T1, T2> CacheRequest.Node addChild(Class<T2> dataType, Object dataId,
      BiConsumer<T1, T2> resultFieldSetter) {
    NodeImpl child = new NodeImpl(dataType, dataId, null,
        (BiConsumer<Object, Object>) resultFieldSetter, new ArrayList<>());
    _childList.add(child);

    return child;
  }

  @SuppressWarnings("unchecked")
  @Override
  public void addChild(Function<?, ?> idGetter, Class<?> dataType,
      BiConsumer<?, ?> resultFieldSetter) {
    NodeImpl node = new NodeImpl(dataType, null,
        (Function<Object, Collection<Comparable<?>>>) idGetter,
        (BiConsumer<Object, Object>) resultFieldSetter, new ArrayList<>());

    _childList.add(node);
//    return child;
  }

  private final Class<?> _dataType;

  private final Object _dataId;
  private final Function<Object, Collection<Comparable<?>>> _dataIdGetter;

  private final BiConsumer<Object, Object> _resultFieldSetter;

  /////////////////////////////

  private final List<NodeImpl> _childList;
}
