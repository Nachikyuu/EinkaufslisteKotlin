package com.example.einkaufsliste

import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import android.graphics.Paint.STRIKE_THRU_TEXT_FLAG
import android.widget.TextView

// Adapter für die Recycler View, die die einzelnen Elemente der Liste darstellt

class TodoAdapter (
    private val todos: MutableList<Todo>
) : RecyclerView.Adapter<TodoAdapter.TodoViewHolder>() {

    class TodoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    // Erstellen des ViewHolders für jedes Element in der Liste, Layout aus selbsterstellter xml-Datei in res/layout
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): TodoAdapter.TodoViewHolder {
        return TodoViewHolder (
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_todo,
                parent,
                false

            )
        )
    }
// Hinzufügen eines neuen Todos zur Liste
    fun addTodo(todo: Todo) {
        todos.add(todo)
        notifyItemInserted( todos.size - 1)

    }
// Löschen aller erledigten Todos aus der Liste
    fun deleteDoneTodos() {
        todos.removeAll { todo ->
            todo.isChecked
        }
        notifyDataSetChanged()

    }
// streicht den Text aus, wenn ein Todo erledigt ist
    private fun toggleStrikeThrough(tvTodoTitle: TextView, isChecked: Boolean) {
        if(isChecked) {
            tvTodoTitle.pointFlags = tvTodoTitle.pointFlags or STRIKE_THRU_TEXT_FLAG
        } else {
            tvTodoTitle.pointFlags = tvTodoTitle.pointFlags and STRIKE_THRU_TEXT_FLAG.inv()
        }
    }
// Bindung der Daten mit den Elementen
    override fun onBindViewHolder(holder: TodoAdapter.TodoViewHolder, position: Int) {
        val curTodo = todos[position]
        holder.itemView.apply {
            tvTodo.text = curTodo.title
            cbDone.isChecked = curTodo.isChecked
            toggleStrikeThrough(tvTodoTitle, curTodo.isChecked)
            cbDone.setOnCheckedChangedListener { buttonView, isChecked ->
                toggleStrikeThrough(tvTodoTitle, isChecked)
                curTodo.isChecked = !curTodo.isChecked
            }
        }
    }

// Anzahl der Einträge, damit der Recycler View weiß, wieviele Elemente er darstellen soll
    override fun getItemCount(): Int {
        return todos.size
    }
}