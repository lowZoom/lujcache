package luj.cache.api.request;

import java.util.Collection;
import java.util.function.BiConsumer;
import java.util.function.Function;

public interface RequestWalkListener {

  interface Context {

    Class<?> getDataType();

    <T> T getDataId();

    Function<Object, Collection<Comparable<?>>> getDataIdGetter();

    BiConsumer<Object, Object> getFieldSetter();

    <T> T getRequestParam();

    <T> T getParentReturn();
  }

  Object onWalk(Context ctx);
}
