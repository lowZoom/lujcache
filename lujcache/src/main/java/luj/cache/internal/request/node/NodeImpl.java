package luj.cache.internal.request.node;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;
import luj.cache.api.request.CacheRequest;

public class NodeImpl implements CacheRequest.Node {

  public NodeImpl(List<NodeImpl> childList) {
    _childList = childList;
  }

  @Override
  public <T1, T2> CacheRequest.Node addChild(Class<T2> dataType, Object dataId,
      BiConsumer<T1, T2> resultFieldSetter) {
    NodeImpl child = new NodeImpl(new ArrayList<>());
    _childList.add(child);
    return child;
  }

  private final List<NodeImpl> _childList;
}
