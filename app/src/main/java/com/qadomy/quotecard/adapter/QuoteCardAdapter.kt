package com.qadomy.quotecard.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.viewpager.widget.PagerAdapter
import com.qadomy.quotecard.R
import com.qadomy.quotecard.model.Quote
import com.qadomy.quotecard.utils.Common

class QuoteCardAdapter(
    private var context: Context,
    private var quoteList: List<Quote>
) : PagerAdapter() {

    override fun isViewFromObject(view: View, p1: Any)=  view == p1

    override fun getCount() = quoteList.size

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as View)
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        // inflate layout
        val view = LayoutInflater.from(context)
            .inflate(R.layout.layout_card_view, container, false)

        // init views
        val quoteImage = view.findViewById<View>(R.id.quotes_image) as ImageView
        val quoteDesc = view.findViewById<View>(R.id.quotes_description) as TextView
        val quoteName = view.findViewById<View>(R.id.quotes_name) as TextView

        val acceptButton = view.findViewById<View>(R.id.accept_button) as Button
        val rejectButton = view.findViewById<View>(R.id.reject_button) as Button


        // set data in views
        quoteImage.setImageResource(quoteList[position].image)
        quoteDesc.text = quoteList[position].description
        quoteName.text = quoteList[position].name


        // when click on accept button
        acceptButton.setOnClickListener {

            // create notification for display the quote description
            Common.showNotification(
                context,
                1,
                "${quoteList[position].name}",
                quoteList[position].description
            )
        }

        // when click on reject button
        rejectButton.setOnClickListener {

            // clear notification
            Common.hideNotification(context)
        }


        // add view
        container.addView(view)
        return view
    }

}

