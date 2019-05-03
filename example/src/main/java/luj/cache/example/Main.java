package luj.cache.example;

import luj.cache.api.CacheSession;
import luj.cache.api.LujCache;
import luj.cache.example.core.spring.ExampleInjectConf;
import luj.cache.example.module.player.control.login.PlayerLoginLoad;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

final class Main {

  public static void main(String[] args) {
    try (AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext()) {
      ctx.register(ExampleInjectConf.class);
      ctx.refresh();

      new Main().start(ctx);
    }
  }

  void start(ApplicationContext appContext) {
    CacheSession lujcache = LujCache.start(appContext);

    new PlayerLoginLoad(lujcache).onLoad();
  }
}
