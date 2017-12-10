package darkpiv.me.myapplication.data.model;
/*
 * Created by darkpiv on 12/10/17.
 */

import darkpiv.me.myapplication.base.BaseModel;

public class User extends BaseModel {

  private String name;
  private String age;

  public User(String name, String age) {
    this.name = name;
    this.age = age;
  }

  public User() {
    // Empty contructor
  }

  public String getName() {
    return name;
  }

  public String getAge() {
    return age;
  }
}
