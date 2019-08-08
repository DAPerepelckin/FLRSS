package com.schoolproject.dap.FLRSS;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collection;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.CustomViewHolder>{

    private ArrayList<Work> worksList = new ArrayList<>();

    public void setItems(Collection<Work> works){
        worksList.addAll(works);
        notifyDataSetChanged();
    }

    public void clearItems(){
        worksList.clear();
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recycler_view_item,viewGroup,false);
        return new CustomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder customViewHolder, int position) {
        customViewHolder.bind(worksList.get(position));
    }

    @Override
    public int getItemCount() {
        return worksList.size();
    }

    class CustomViewHolder extends RecyclerView.ViewHolder{
        private TextView tittle;
        private TextView price;
        private TextView body;
        private TextView date;


        CustomViewHolder(@NonNull View itemView) {
            super(itemView);
            tittle = itemView.findViewById(R.id.tittle);
            price = itemView.findViewById(R.id.price);
            body = itemView.findViewById(R.id.body);
            date = itemView.findViewById(R.id.date);


        }

        void bind(Work work) {
            tittle.setText(work.getTitle());
            price.setText(work.getPrice());
            body.setText(work.getBody());
            date.setText(work.getDate());
        }
    }



}
