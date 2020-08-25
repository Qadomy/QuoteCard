package com.qadomy.quotecard

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.qadomy.quotecard.R.layout.activity_main
import com.qadomy.quotecard.adapter.QuoteCardAdapter
import com.qadomy.quotecard.databinding.ActivityMainBinding
import com.qadomy.quotecard.model.Quote

class MainActivity : AppCompatActivity() {

    // quotes list
    private var quotesList: MutableList<Quote> = ArrayList()

    // adapter
    private lateinit var adapter: QuoteCardAdapter


    /**
     * onCreate
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // data  binding
        val binding: ActivityMainBinding = DataBindingUtil.setContentView(this, activity_main)

        // init adapter
        adapter = QuoteCardAdapter(baseContext, quotesList)


        createQuotes()

//        // init view model
//        viewModel = ViewModelProvider(requireActivity()).get(QuoteCardsViewModel::class.java)

        // set adapter
        binding.cardsView.adapter = adapter
    }

    // method for create fake quotes to display in cards
    private fun createQuotes() {
        quotesList.add(Quote("Frank Zappa", getString(R.string.quote4), R.drawable.quote4))
        quotesList.add(Quote("Albert Einstein", getString(R.string.quote3), R.drawable.quote3))
        quotesList.add(Quote("Bernard M. Baruch", getString(R.string.quote5), R.drawable.quote5))
        quotesList.add(Quote("Oscar Wilde", getString(R.string.quote2), R.drawable.quote2))
        quotesList.add(Quote("Marcus Cicero", getString(R.string.quote6), R.drawable.quote6))
        quotesList.add(Quote("Marilyn Monroe", getString(R.string.quote1), R.drawable.quote1))
        quotesList.add(Quote("Dr. Seuss", getString(R.string.quote7), R.drawable.quote7))
        quotesList.add(Quote("Mae West", getString(R.string.quote8), R.drawable.quote8))
        quotesList.add(Quote("Mahatma Gandhi", getString(R.string.quote9), R.drawable.quote9))
        quotesList.add(Quote("Robert Frost", getString(R.string.quote10), R.drawable.quote10))
        quotesList.add(Quote("J.K. Rowling", getString(R.string.quote11), R.drawable.quote11))
    }
}