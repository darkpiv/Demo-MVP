package darkpiv.me.myapplication.bussiness.main;
/*
 * Created by darkpiv on 12/10/17.
 */

import darkpiv.me.myapplication.base.ExecuteListener;
import darkpiv.me.myapplication.data.model.User;
import darkpiv.me.myapplication.data.repository.UserApiImpl;

public class MainPresenter implements MainPresenterAction {

  private UserApiImpl userApiImpl;
  private MainView mainView;

  public MainPresenter(MainView mainView) {
    userApiImpl = new UserApiImpl();
    this.mainView = mainView;
  }

  @Override
  public void terminate() {
    mainView = null;
  }

  @Override
  public void getData() {
    userApiImpl.getData(new ExecuteListener<User>() {
      @Override
      public void onExecuted(User data) {
        mainView.setData(data);
      }

      @Override
      public void onError(Throwable throwable) {
        mainView.onFailed(throwable);
      }
    });


  }
}
