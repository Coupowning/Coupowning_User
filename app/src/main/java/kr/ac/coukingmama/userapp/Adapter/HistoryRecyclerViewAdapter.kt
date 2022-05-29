package kr.ac.coukingmama.userapp.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.history_list.view.*
import kr.ac.coukingmama.userapp.R
import kr.ac.coukingmama.userapp.data.user.History

import java.text.SimpleDateFormat
import java.util.*

class HistoryRecyclerViewAdapter: RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    var historyList = ArrayList<History>()

    fun setData(loc: Int, history: History) {
        historyList.add(loc, history)
        notifyDataSetChanged()
    }
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.history_list, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return historyList.size
    }
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        var viewHolder = (holder as ViewHolder).itemView
        var currentItem = historyList[position]
        var str_sub = currentItem.date.substring(0 until 10)
        var token = StringTokenizer(str_sub, "-")
        var date = token.nextToken() + "년 "
        date += token.nextToken() + "월 "
        date += token.nextToken() + "일 "

        viewHolder.historyDate.text = date
        viewHolder.historyNum.text = currentItem.amount.toString()
    }
}