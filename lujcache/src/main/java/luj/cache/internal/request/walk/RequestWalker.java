package luj.cache.internal.request.walk;

import luj.cache.api.request.RequestWalkListener;
import luj.cache.internal.request.node.NodeImpl;

public class RequestWalker {

  public RequestWalker(NodeImpl root, Object requestParam, RequestWalkListener walkListener) {
    _root = root;
    _requestParam = requestParam;
    _walkListener = walkListener;
  }

  public void walk() {
    for (NodeImpl child : _root.getChildList()) {
      walkImpl(child, null);
    }
  }

  private void walkImpl(NodeImpl node, Object parentReturn) {
    WalkContextImpl ctx = new WalkContextImpl();
    ctx._node = node;
    ctx._requestParam = _requestParam;
    ctx._parentReturn = parentReturn;

    Object selfReturn = _walkListener.onWalk(ctx);
    if (selfReturn == null) {
      // 该结点对应数据不存在，就打断不用再往下找了
      return;
    }

    for (NodeImpl child : node.getChildList()) {
      walkImpl(child, selfReturn);
    }
  }

  private final NodeImpl _root;
  private final Object _requestParam;

  private final RequestWalkListener _walkListener;
}
