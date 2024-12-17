package com.dicoding2.submissionandroidsederhana

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.dicoding2.submissionandroidsederhana.adapter.ListArticleAdapter
import com.dicoding2.submissionandroidsederhana.databinding.ActivityMainBinding
import com.dicoding2.submissionandroidsederhana.model.Article

class MainActivity : AppCompatActivity() {
    private val list = ArrayList<Article>()
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.rvArticle.setHasFixedSize(true)

        list.addAll(getListArticles())
        showRecyclerList()
    }

    private fun showRecyclerList() {
        binding.rvArticle.layoutManager = LinearLayoutManager(this)
        val listArticleAdapter = ListArticleAdapter(list)
        binding.rvArticle.adapter = listArticleAdapter

        listArticleAdapter.setOnItemClickCallback(object : ListArticleAdapter.OnItemClickCallback {
            override fun onItemClicked(data: Article) {
                changePage(data)
            }
        })
    }

    private fun getListArticles(): ArrayList<Article> {
        val dataName = resources.getStringArray(R.array.data_name)
        val dataDescription = resources.getStringArray(R.array.data_description)
        val dataPath = resources.getStringArray(R.array.data_path)
        val dataElement = resources.getStringArray(R.array.data_element)
        val dataPhoto = resources.obtainTypedArray(R.array.data_photo)

        val dataRelicPhoto1 = resources.obtainTypedArray(R.array.data_relic_image_1)
        val dataRelicPhoto2 = resources.obtainTypedArray(R.array.data_relic_image_2)
        val dataRelicPhoto3 = resources.obtainTypedArray(R.array.data_relic_image_3)

        val dataTextPhoto1 = resources.getStringArray(R.array.data_relic_text_1)
        val dataTextPhoto2 = resources.getStringArray(R.array.data_relic_text_2)
        val dataTextPhoto3 = resources.getStringArray(R.array.data_relic_text_3)

        val listHero = ArrayList<Article>()
        for (i in dataName.indices) {
            val articles = Article(
                dataName[i],
                dataDescription[i],
                dataPhoto.getResourceId(i,-1),
                dataPath[i],
                dataElement[i],
                dataTextPhoto1[i],
                dataRelicPhoto1.getResourceId(i,-1),
                dataTextPhoto2[i],
                dataRelicPhoto2.getResourceId(i,-1),
                dataTextPhoto3[i],
                dataRelicPhoto3.getResourceId(i,-1),
            )
            listHero.add(articles)
        }
        return listHero
    }

    private fun changePage(data: Article){
        val movePage = Intent(this@MainActivity,DetailActivity::class.java)
        movePage.putExtra(DetailActivity.EXTRA_DATA, data)
        startActivity(movePage)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.about -> {
                val movePage = Intent(this@MainActivity, AboutActivity::class.java)
                startActivity(movePage)
            }
        }
        return super.onOptionsItemSelected(item)
    }
}