package luj.cache.example;

import luj.cache.api.CacheSession;
import luj.cache.api.LujCache;
import luj.cache.example.core.spring.ExampleInjectConf;
import luj.cache.example.module.player.control.login.PlayerLoginLoad;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

final class Main {

  public static void main(String[] args) {
    try (GenericApplicationContext ctx = new AnnotationConfigApplicationContext(ExampleInjectConf.class)) {
      new Main().start(ctx);
    }
  }

  void start(ApplicationContext appContext) {
    CacheSession lujcache = LujCache.start(appContext);

    new PlayerLoginLoad(lujcache).onLoad();
  }
}
