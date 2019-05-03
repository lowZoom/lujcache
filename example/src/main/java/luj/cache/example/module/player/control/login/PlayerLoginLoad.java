package luj.cache.example.module.player.control.login;

import luj.cache.api.CacheSession;
import luj.cache.api.request.CacheRequest;
import luj.cache.example.module.player.data.PlayerDb;

public class PlayerLoginLoad {

  public PlayerLoginLoad(CacheSession lujcache) {
    _lujcache = lujcache;
  }

  public void onLoad() {
    CacheRequest req = _lujcache.createRequest();

    PlayerDb[] playerDb = new PlayerDb[1];
    req.addNode(PlayerDb.class, 101L, (r, f) -> playerDb[0] = f);

    req.walk();
    System.out.println(playerDb[0].playerId());
  }

  private final CacheSession _lujcache;
}
