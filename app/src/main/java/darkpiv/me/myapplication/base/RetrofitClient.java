package darkpiv.me.myapplication.base;
/*
 * Created by darkpiv on 12/10/17.
 */

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {

  private static Retrofit instance;

  public static Retrofit getInstance() {
    if (instance == null) {
      instance = new Retrofit.Builder()
        .baseUrl("http://www.mocky.io/")
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .build();
    }
    return instance;
  }

}
