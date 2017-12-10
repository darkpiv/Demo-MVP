package darkpiv.me.myapplication.base;
/*
 * Created by darkpiv on 12/10/17.
 */

public interface ExecuteListener<T extends BaseModel> {

  void onExecuted(T data);

  void onError(Throwable throwable);

}
