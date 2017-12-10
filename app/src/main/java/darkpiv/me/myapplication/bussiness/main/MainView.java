package darkpiv.me.myapplication.bussiness.main;
/*
 * Created by darkpiv on 12/10/17.
 */

import darkpiv.me.myapplication.base.BaseView;
import darkpiv.me.myapplication.data.model.User;

public interface MainView extends BaseView {
  void initView();

  void getData();

  void setData(User user);

  void onFailed(Throwable throwable);

}
