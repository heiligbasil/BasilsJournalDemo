package com.lambdaschool.basilsjournal

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class DetailsActivity : AppCompatActivity() {

    companion object {
        const val DATE_KEY = "ENTRY_DATE_KEY"

        const val RATING_KEY = "ENTRY_RATING_NUMBER"

        const val TEXT_KEY = "ENTRY_TEXT"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        date_text_view.text = Date().toString()
        day_rating_bar.max = 4
        text_entry
    }


    /**
     * Take care of popping the fragment back stack or finishing the activity
     * as appropriate.
     */
    override fun onBackPressed() {
        val date = date_text_view.text
        val rating = day_rating_bar.progress
        val text = text_entry.text

        val resultIntent = Intent()
        resultIntent.putExtra(DATE_KEY, date)
        resultIntent.putExtra(RATING_KEY, rating)
        resultIntent.putExtra(TEXT_KEY, text)

        setResult(Activity.RESULT_OK, resultIntent)
        finish() // This destroys the activity
    }
}
