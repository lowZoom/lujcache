package luj.cache.example.core.lujcache;

import luj.cache.api.request.RequestWalkListener;
import luj.cache.example.core.data.ExampleDataManager;
import org.springframework.stereotype.Component;

@Component
final class OnLujcacheWalk implements RequestWalkListener {

  /**
   * @see ExampleDataManager
   */
  @Override
  public Object onWalk(Context ctx) {
    Class<?> dataType = ctx.getDataType();
    Long dataId = ctx.getDataId();

    Object data = ExampleDataManager.SINGLETON.findData(dataType, dataId);
    ctx.getFieldSetter().accept(null, data);

    return null;
  }
}
