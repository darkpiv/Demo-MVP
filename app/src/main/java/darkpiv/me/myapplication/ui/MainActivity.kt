package darkpiv.me.myapplication.ui

/*
 * Created by darkpiv on 12/10/17.
 */

import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.v7.app.AppCompatActivity
import android.widget.TextView
import android.widget.Toast
import darkpiv.me.myapplication.R
import darkpiv.me.myapplication.bussiness.main.MainPresenter
import darkpiv.me.myapplication.bussiness.main.MainPresenterAction
import darkpiv.me.myapplication.bussiness.main.MainView
import darkpiv.me.myapplication.data.model.User


class MainActivity : AppCompatActivity(), MainView {

  private var action: MainPresenterAction? = null
  private var name: TextView? = null
  private var age: TextView? = null
  private var fab: FloatingActionButton? = null

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)
    initView()
  }

  override fun initView() {
    action = MainPresenter(this)
    name = findViewById(R.id.tvName)
    age = findViewById(R.id.tvAge)
    fab = findViewById(R.id.fab)

    fab!!.setOnClickListener { getData() }
  }

  override fun getData() {
    action!!.getData()
  }

  override fun setData(user: User) {
    name!!.text = user.name
    age!!.text = user.age
  }

  override fun onFailed(throwable: Throwable) {
    Toast.makeText(this, "Failed roi em, check internet di cu", Toast.LENGTH_SHORT).show()
  }

  override fun onDestroy() {
    super.onDestroy()
    if (!isChangingConfigurations) {
      action!!.terminate()
    }
  }
}
