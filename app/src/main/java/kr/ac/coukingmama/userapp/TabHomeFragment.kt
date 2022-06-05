package kr.ac.coukingmama.userapp

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_tab_home.view.*
import kr.ac.coukingmama.userapp.Adapter.HomeRecyclerViewAdapter
import kr.ac.coukingmama.userapp.data.user.*


class TabHomeFragment : Fragment() {
    private lateinit var userViewModel: UserViewModel
    var userId: String? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        userId = arguments?.getString("userId").toString()

        val view = inflater.inflate(R.layout.fragment_tab_home, container, false)
        val adapter = HomeRecyclerViewAdapter()
        val recyclerView = view.recyclerview

        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        val userRepository = UserRepository()
        val userViewModelFactory = UserViewModelFactory(userRepository)

        userViewModel = ViewModelProvider(this, userViewModelFactory).get(UserViewModel::class.java)
        userViewModel.getUser("${userId}")
        userViewModel.myResponse.observe(viewLifecycleOwner, Observer {
            it.body()!!.storeList.forEach {
                adapter.setData(0, it)
            }
        })

        adapter.setOnItemClickListener(object : HomeRecyclerViewAdapter.OnItemClickListener {
            override fun onItemClick(v: View, data: StoreList, pos: Int) {
                val intent = Intent(activity, StampDetailActivity::class.java)
                intent.putExtra("storelist", data)
                Log.d("stamp", data.toString())
                startActivity(intent)
            }
        })
        return view
    }
}