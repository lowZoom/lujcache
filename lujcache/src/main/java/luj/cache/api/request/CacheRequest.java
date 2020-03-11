package luj.cache.api.request;

import java.util.function.BiConsumer;

public interface CacheRequest {

  interface Node {

    <T1, T2> Node addChild(Class<T2> dataType, Object dataId, BiConsumer<T1, T2> resultFieldSetter);
  }

  @Deprecated
  <T1, T2> void addNode(Class<T2> dataType, Object dataId, BiConsumer<T1, T2> resultFieldSetter);

  Node getRoot();

  void walk();
}
