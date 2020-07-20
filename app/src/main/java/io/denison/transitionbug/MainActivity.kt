package io.denison.transitionbug

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bluelinelabs.conductor.Conductor
import com.bluelinelabs.conductor.Router
import com.bluelinelabs.conductor.RouterTransaction
import io.denison.transitionbug.change.FadeThroughChangeHandler
import io.denison.transitionbug.screen.HomeController
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

  private lateinit var router: Router

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)

    router = Conductor.attachRouter(this, container, savedInstanceState)
    if (!router.hasRootController())
      router.setRoot(RouterTransaction.with(HomeController()))
  }

  override fun onBackPressed() {
    if (!router.handleBack()) super.onBackPressed()
  }
}
