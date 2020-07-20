package io.denison.transitionbug.change

import android.view.View
import android.view.ViewGroup
import androidx.transition.Transition
import com.bluelinelabs.conductor.changehandler.androidxtransition.TransitionChangeHandler
import com.google.android.material.transition.MaterialFadeThrough

class FadeThroughChangeHandler : TransitionChangeHandler() {
  override fun getTransition(container: ViewGroup, from: View?, to: View?, isPush: Boolean): Transition = MaterialFadeThrough()
}
