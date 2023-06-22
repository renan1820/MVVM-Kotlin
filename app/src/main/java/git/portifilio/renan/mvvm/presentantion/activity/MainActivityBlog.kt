package git.portifilio.renan.mvvm.presentantion.activity

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import git.portifilio.renan.mvvm.*
import git.portifilio.renan.mvvm.factory.MainViewModelFactory
import git.portifilio.renan.mvvm.model.Blog
import git.portifilio.renan.mvvm.presentantion.adapter.NoteRecyclerAdapter
import git.portifilio.renan.mvvm.viewmodel.MainViewModel

class MainActivityBlog : AppCompatActivity() {
    private var viewManager = LinearLayoutManager(this)
    private lateinit var viewModel: MainViewModel
    private lateinit var mainrecycler: RecyclerView
    private lateinit var but: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_blog)
        mainrecycler = findViewById(R.id.recycler)
        val factory = MainViewModelFactory()
        viewModel = ViewModelProvider(this,factory).get(MainViewModel::class.java)
        but = findViewById(R.id.button)
        but.setOnClickListener {
            addData()
        }

        initialiseAdapter()
    }
    private fun initialiseAdapter(){
        mainrecycler.layoutManager = viewManager
        observeData()
    }

    fun observeData(){
        viewModel.lst.observe(this, Observer{
            mainrecycler.adapter= NoteRecyclerAdapter(viewModel, it, this)
        })
    }

    @SuppressLint("NotifyDataSetChanged")
    fun addData(){
        val txtplce = findViewById<EditText>(R.id.titletxt)
        val title = txtplce.text.toString()
        if(title.isBlank()){
            Toast.makeText(this,"Preencha com um nome",Toast.LENGTH_LONG).show()
        }else{
            val blog= Blog(title)
            viewModel.add(blog)
            txtplce.text.clear()
            mainrecycler.adapter?.notifyDataSetChanged()
        }
    }
}