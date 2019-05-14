package luj.cache.internal.request.state;

import java.util.List;

public class RequestState {

  public RequestState(List<RequestNode> rootList, Object requestParam) {
    _rootList = rootList;
    _requestParam = requestParam;
  }

  public List<RequestNode> getRootList() {
    return _rootList;
  }

  public Object getRequestParam() {
    return _requestParam;
  }

  private final List<RequestNode> _rootList;

  private final Object _requestParam;
}
