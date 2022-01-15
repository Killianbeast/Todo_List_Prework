package com.example.todolistprework;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

// Takes data and displays onto the recycler view
public class TasksAdapter extends RecyclerView.Adapter<TasksAdapter.ViewHolder> {

    public interface OnLongClickListener {
        void onItemLongClicked(int position);
    }

    List<String> tasks;
    OnLongClickListener longClickListener;

    public TasksAdapter(List<String> tasks, OnLongClickListener longClickListener) {
        this.tasks = tasks;
        this.longClickListener = longClickListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View todoView = LayoutInflater.from(parent.getContext()).inflate(android.R.layout.simple_list_item_1, parent, false);
        return new ViewHolder(todoView);
    }

    @Override
    // Binds data to a particular viewHolder
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
    // Grab item at position then bind item to view holder
        String task = tasks.get(position);
        holder.bind(task);
    }

    @Override
    public int getItemCount() {
        return tasks.size();
    }

    // Container
    class ViewHolder extends RecyclerView.ViewHolder {

        TextView txtItem;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtItem = itemView.findViewById(android.R.id.text1);
        }
        // Update view inside view holder with data
        public void bind(String task) {
            txtItem.setText(task);
            txtItem.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View view) {
                    longClickListener.onItemLongClicked(getAdapterPosition());
                    return true;
                }
            });
        }
    }
}
