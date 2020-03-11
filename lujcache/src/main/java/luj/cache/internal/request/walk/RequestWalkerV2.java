package luj.cache.internal.request.walk;

import luj.cache.api.request.RequestWalkListener;
import luj.cache.internal.request.node.NodeImpl;

public class RequestWalkerV2 {

  public RequestWalkerV2(NodeImpl root, Object requestParam, RequestWalkListener walkListener) {
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
    WalkContextImpl ctx = new WalkContextImpl(node, _requestParam, parentReturn);
    Object selfReturn = _walkListener.onWalk(ctx);

    for (NodeImpl child : node.getChildList()) {
      walkImpl(child, selfReturn);
    }
  }

  private final NodeImpl _root;
  private final Object _requestParam;

  private final RequestWalkListener _walkListener;
}
