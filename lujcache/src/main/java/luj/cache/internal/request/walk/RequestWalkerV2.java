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
      walkImpl(child);
    }
  }

  private void walkImpl(NodeImpl node) {
    WalkContextImpl ctx = new WalkContextImpl(node, _requestParam);
    _walkListener.onWalk(ctx);

    for (NodeImpl child : node.getChildList()) {
      walkImpl(child);
    }
  }

  private final NodeImpl _root;
  private final Object _requestParam;

  private final RequestWalkListener _walkListener;
}
