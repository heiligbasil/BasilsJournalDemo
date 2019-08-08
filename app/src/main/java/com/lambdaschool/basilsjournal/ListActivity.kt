package com.lambdaschool.basilsjournal

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity;

import kotlinx.android.synthetic.main.activity_list.*

class ListActivity : AppCompatActivity() {
    companion object {
        const val NEW_ENTRY_REQUEST = 36352
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)
        setSupportActionBar(toolbar)

        fab.setOnClickListener { view ->
            val intent = Intent(this, DetailsActivity::class.java)
            startActivityForResult(intent, NEW_ENTRY_REQUEST)
        }
    }

    /**
     * Dispatch incoming result to the correct fragment.
     */
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (resultCode == Activity.RESULT_OK) {
            when (requestCode) {
                NEW_ENTRY_REQUEST -> {
                    val date = data?.getStringExtra(DetailsActivity.DATE_KEY) ?: "Jan 1, 1970"
                    val rating = data?.getIntExtra(DetailsActivity.RATING_KEY, 0)
                    val text = data?.getStringExtra(DetailsActivity.TEXT_KEY) ?: "No Text"

                    Toast.makeText(this, "$date - $rating - $text", Toast.LENGTH_SHORT).show()
                }
            }
        }
        super.onActivityResult(requestCode, resultCode, data)
    }
}
