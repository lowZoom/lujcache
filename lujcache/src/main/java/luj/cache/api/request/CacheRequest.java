package luj.cache.api.request;

import java.util.function.BiConsumer;
import java.util.function.Function;

public interface CacheRequest {

  interface Node {

    <T1, T2> Node addChild(Class<T2> dataType, BiConsumer<T1, T2> resultFieldSetter, Object op);

    @Deprecated
    <T1, T2> Node addChild(Class<T2> dataType, Object dataId, BiConsumer<T1, T2> resultFieldSetter);

    @Deprecated
    <T1, T2> Node addChild(Function<?, ?> idGetter, Class<T2> dataType, BiConsumer<T1, T2> resultFieldSetter);
  }

  Node getRoot();

  void walk(RequestWalkListener listener);
}
