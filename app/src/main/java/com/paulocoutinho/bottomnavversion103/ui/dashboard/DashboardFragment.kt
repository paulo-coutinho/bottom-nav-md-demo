package com.paulocoutinho.bottomnavversion103.ui.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.paulocoutinho.bottomnavversion103.R

class DashboardFragment : Fragment() {
    private var dashboardViewModel: DashboardViewModel? = null
    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?, savedInstanceState: Bundle?): View? {
        dashboardViewModel = ViewModelProvider(this).get(DashboardViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_dashboard, container, false)
        val textView = root.findViewById<TextView>(R.id.text_dashboard)
        dashboardViewModel?.text?.observe(viewLifecycleOwner, { s -> textView.text = s })
        return root
    }
}