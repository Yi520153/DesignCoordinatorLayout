package com.lcl.designcoordinatorlayout;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by lcl on 2016/12/13.
 */

public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewAdapter.MyViewHolder> {

    private Context context;
    private List<String> list;
    private MyRecyclerViewItemClick myRecyclerViewItemClick;

    public MyRecyclerViewAdapter(Context context,List<String> list) {
        this.context = context;
        this.list=list;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.item_my_recycler_view, null);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        holder.content.setText(list.get(holder.getAdapterPosition()));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(myRecyclerViewItemClick!=null){
                    myRecyclerViewItemClick.onItemClick(v,holder.getAdapterPosition());
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return list!=null?list.size():0;
    }

    public void setMyRecyclerViewItemClick(MyRecyclerViewItemClick myRecyclerViewItemClick) {
        this.myRecyclerViewItemClick = myRecyclerViewItemClick;
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        private TextView content;
        private View itemView;

        public MyViewHolder(View itemView) {
            super(itemView);
            content = (TextView) itemView.findViewById(R.id.content);
            this.itemView=itemView;
        }
    }
}
