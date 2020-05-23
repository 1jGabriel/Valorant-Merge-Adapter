package io.jgabriel

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.MergeAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupDataInRecyclerView()
    }

    private fun setupDataInRecyclerView() {
        recyclerView.layoutManager = LinearLayoutManager(this)
        val adapter = MergeAdapter()
        adapter.addAdapter(HeaderAdapter().apply {
            listOf(Header())
        })

        DataSource.getCharacters().forEach {
            adapter.addAdapter(PersonageAdapter().apply {
                swapData(listOf(it))
            })

            adapter.addAdapter(SpellAdapter().apply {
                swapData(it.spells)
            })
        }
        adapter.addAdapter(BannerAdapter().apply {
            swapData(listOf(DataSource.getBanner()))
        })

        recyclerView.adapter = adapter
    }
}
