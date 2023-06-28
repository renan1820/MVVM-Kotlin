package git.portifilio.renan.mvvm.presentantion.activity

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
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
        viewModel = ViewModelProvider(this,factory)[MainViewModel::class.java]
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

    private fun observeData(){
        viewModel.lst.observe(this){ list ->
            mainrecycler.adapter = NoteRecyclerAdapter(viewModel, list, this)
        }
    }

    private fun addData(){
        val txtplce = findViewById<EditText>(R.id.titletxt)
        val title = txtplce.text.toString()
        if(title.isBlank()){
            Toast.makeText(this,"Preencha com um nome",Toast.LENGTH_LONG).show()
        }else{
            val blog= Blog(title)
            viewModel.addList(blog)
            txtplce.text.clear()
            mainrecycler.let { it.adapter?.notifyItemInserted(viewModel.getSizeList())}
        }
    }

    fun navigate(intent: Intent){
        startActivity(intent)
    }
}