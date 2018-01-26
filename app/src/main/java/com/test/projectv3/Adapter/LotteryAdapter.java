package com.test.projectv3.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.test.projectv3.Model.LotteryModel;

import java.util.List;

public class LotteryAdapter extends RecyclerView.Adapter<LotteryAdapter.ViewHolder> {

    public List<LotteryModel> data;

    public LotteryAdapter(){}
    public void setData(List<LotteryModel> data){
        this.data = data;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View wordView = inflater.inflate(android.support.v4.R.layout.item_lottery, parent, false);
        ViewHolder viewHolder = new ViewHolder(wordView, context);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(LotteryAdapter.ViewHolder holder, int position) {
        LotteryModel lotteryModel = data.get(position);
        holder.lotteryText.setText(lotteryModel.getLottery_num());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        public Context context;
        public TextView lotteryText;
        public ViewHolder(View itemView, final Context context){
            super(itemView);
            this.context = context;
            lotteryText = (TextView) findViewById(R.id.textView);
        }
    }
}
