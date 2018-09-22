package com.example.ryandiwdjj.login_test2;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.List;

public class RecycleAdapter extends RecyclerView.Adapter<RecycleAdapter.MyViewHolder>{

    public List<MatKulDAO> matKulDAOList;

    public RecycleAdapter(List<MatKulDAO> matkulDAOList) { this.matKulDAOList=matkulDAOList; }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        public TextView name;
        public ImageView nthumbnail;

        public MyViewHolder(View itemView)
        {
            super(itemView);
            name=itemView.findViewById(R.id.title);
            nthumbnail=itemView.findViewById(R.id.thumbnail);
        }
    }

    @Override
    public RecycleAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView= LayoutInflater.from(parent.getContext())
                .inflate(R.layout.layout_nav_home, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(RecycleAdapter.MyViewHolder holder, int position) {
        MatKulDAO mDAO=matKulDAOList.get(position);
        holder.name.setText(mDAO.getName());
    }

    public int getItemCount()
    {
        return matKulDAOList.size();
    }
}
