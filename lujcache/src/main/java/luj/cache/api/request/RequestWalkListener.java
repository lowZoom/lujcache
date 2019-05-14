package luj.cache.api.request;

import java.util.function.BiConsumer;

public interface RequestWalkListener {

  interface Context {

    Class<?> getDataType();

    <T> T getDataId();

    BiConsumer<Object, Object> getFieldSetter();

    <T> T getRequestParam();
  }

  void onWalk(Context ctx);
}
