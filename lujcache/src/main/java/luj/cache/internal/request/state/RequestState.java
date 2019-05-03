package luj.cache.internal.request.state;

import java.util.List;

public class RequestState {

  public RequestState(List<RequestNode> rootList) {
    _rootList = rootList;
  }

  public List<RequestNode> getRootList() {
    return _rootList;
  }

  private final List<RequestNode> _rootList;
}
