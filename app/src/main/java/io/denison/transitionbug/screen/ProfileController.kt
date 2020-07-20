package io.denison.transitionbug.screen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bluelinelabs.conductor.Controller
import com.bluelinelabs.conductor.Router
import io.denison.transitionbug.R
import kotlinx.android.synthetic.main.home.view.*
import kotlin.random.Random

class ProfileController : Controller() {
  override fun onCreateView(inflater: LayoutInflater, container: ViewGroup, savedViewState: Bundle?): View =
    inflater.inflate(R.layout.profile, container, false).apply { setup() }

  private fun View.setup() {
    pager.adapter = PagerAdapter(router)
    recycler.adapter = ListAdapter()
    recycler.layoutManager = LinearLayoutManager(context)
  }

  private class PagerAdapter(private val router: Router) : RecyclerView.Adapter<PagerAdapter.PagerViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PagerViewHolder =
      PagerViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.section_pager, parent, false)
      )

    override fun onBindViewHolder(holder: PagerViewHolder, position: Int) {
      holder.text.text = when (position) {
        0    -> "Profile 1"
        1    -> "Profile 2"
        else -> "Profile 3"
      }
    }

    override fun getItemCount(): Int = 3

    private class PagerViewHolder(view: View) : RecyclerView.ViewHolder(view) {
      val text: TextView = view.findViewById(R.id.text)
    }
  }

  private class ListAdapter : RecyclerView.Adapter<ListAdapter.ListViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder =
      ListViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.section_list, parent, false)
      )

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
      holder.number.text = Random.nextInt().toString()
    }

    override fun getItemCount(): Int = 30

    private class ListViewHolder(view: View) : RecyclerView.ViewHolder(view) {
      val number: TextView = view.findViewById(R.id.number)
    }
  }
}
