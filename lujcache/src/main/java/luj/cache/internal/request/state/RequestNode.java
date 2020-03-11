package luj.cache.internal.request.state;

import java.util.function.BiConsumer;

@Deprecated
public class RequestNode {

  public RequestNode(Class<?> dataType, Object dataId, BiConsumer<Object, Object> fieldSetter) {
    _dataType = dataType;
    _dataId = dataId;
    _fieldSetter = fieldSetter;
  }

  public Class<?> getDataType() {
    return _dataType;
  }

  public Object getDataId() {
    return _dataId;
  }

  public BiConsumer<Object, Object> getFieldSetter() {
    return _fieldSetter;
  }

  private final Class<?> _dataType;
  private final Object _dataId;

  private final BiConsumer<Object, Object> _fieldSetter;
}
