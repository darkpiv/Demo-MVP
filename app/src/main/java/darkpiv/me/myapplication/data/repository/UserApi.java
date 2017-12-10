package darkpiv.me.myapplication.data.repository;
/*
 * Created by darkpiv on 12/10/17.
 */

import darkpiv.me.myapplication.data.model.User;
import io.reactivex.Observable;
import retrofit2.http.GET;

public interface UserApi {

  @GET("v2/5a2cfdab320000190e6fa803")
  Observable<User> call();
}
