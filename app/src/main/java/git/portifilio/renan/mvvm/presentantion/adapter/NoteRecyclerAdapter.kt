package git.portifilio.renan.mvvm.presentantion.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import git.portifilio.renan.mvvm.model.Blog
import git.portifilio.renan.mvvm.R
import git.portifilio.renan.mvvm.presentantion.compose.NoteDetails
import git.portifilio.renan.mvvm.viewmodel.MainViewModel


class NoteRecyclerAdapter(val viewModel: MainViewModel, val arrayList: ArrayList<Blog>, private val context: Context): RecyclerView.Adapter<NoteRecyclerAdapter.NotesViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int,
    ): NotesViewHolder {
        return NotesViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item,parent,false))
    }

    override fun onBindViewHolder(holder: NotesViewHolder, position: Int) {
        holder.bind(arrayList[position])
    }

    override fun getItemCount(): Int {
        if(arrayList.size==0){
            Toast.makeText(context,"Item Removido",Toast.LENGTH_LONG).show()
        }
        return arrayList.size
    }


    inner  class NotesViewHolder(private val binding: View) : RecyclerView.ViewHolder(binding) {
        fun bind(blog: Blog){
            binding.findViewById<TextView>(R.id.title).text = blog.title
            binding.findViewById<Button>(R.id.delete).setOnClickListener {
                viewModel.removeList(blog)
                notifyItemRemoved(arrayList.indexOf(blog))
            }
            binding.findViewById<ConstraintLayout>(R.id.constraint).setOnClickListener{
                context.startActivity(Intent(context,NoteDetails::class.java))
            }
        }

    }

}