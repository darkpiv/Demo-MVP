package darkpiv.me.myapplication.data.repository;
/*
 * Created by darkpiv on 12/10/17.
 */

import android.util.Log;
import darkpiv.me.myapplication.base.ExecuteListener;
import darkpiv.me.myapplication.base.RetrofitClient;
import darkpiv.me.myapplication.data.model.User;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.concurrent.TimeUnit;

public class UserApiImpl {

  private UserApi userApi;

  public UserApiImpl() {
    userApi = RetrofitClient.getInstance().create(UserApi.class);
  }

  public void getData(final ExecuteListener<User> ls) {
    userApi.call()
      .delay(2000, TimeUnit.MILLISECONDS)
      .observeOn(AndroidSchedulers.mainThread())
      .subscribeOn(Schedulers.io())
      .subscribe(new Consumer<User>() {
        @Override
        public void accept(User user) throws Exception {
          ls.onExecuted(user);
          Log.d("XXX",user.getName());
        }
      }, new Consumer<Throwable>() {
        @Override
        public void accept(Throwable throwable) throws Exception {
          ls.onError(throwable);
          Log.e("XXX",throwable.getMessage());
        }
      });

  }
}
