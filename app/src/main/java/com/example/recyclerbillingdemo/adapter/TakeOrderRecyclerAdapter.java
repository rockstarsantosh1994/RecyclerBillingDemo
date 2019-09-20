package com.example.recyclerbillingdemo.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recyclerbillingdemo.R;
import com.example.recyclerbillingdemo.pojo.TakeOrderModel;

import java.util.ArrayList;

public class TakeOrderRecyclerAdapter extends RecyclerView.Adapter<TakeOrderRecyclerAdapter.TakeOrderViewHolder>{

    public Context context;
    public ArrayList<TakeOrderModel> takeOrderArrayListModel;


    public TakeOrderRecyclerAdapter(Context context, ArrayList<TakeOrderModel> takeOrderArrayListModel) {
        this.context = context;
        this.takeOrderArrayListModel = takeOrderArrayListModel;
    }


    @NonNull
    @Override
    public TakeOrderViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
        View view=inflater.inflate(R.layout.custom_takeorder_row,parent,false);
        return new TakeOrderViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull TakeOrderViewHolder holder, int position) {
        holder.tvCode.setText(takeOrderArrayListModel.get(position).getCode());
        holder.tvMenu.setText(takeOrderArrayListModel.get(position).getMenu());
        holder.tvQuantity.setText(takeOrderArrayListModel.get(position).getQuantity());
        holder.tvServesIn.setText(takeOrderArrayListModel.get(position).getServesin());
        holder.tvRate.setText(takeOrderArrayListModel.get(position).getRate());
        holder.tvAmount.setText(takeOrderArrayListModel.get(position).getAmount());

        Log.e("mytag", "onBindViewHolder: "+takeOrderArrayListModel.size() );
    }

    @Override
    public int getItemCount() {
        return takeOrderArrayListModel.size();
    }

    public class TakeOrderViewHolder extends RecyclerView.ViewHolder{

        public TextView tvCode,tvMenu,tvQuantity,tvServesIn,tvRate,tvAmount;

        public TakeOrderViewHolder(@NonNull View itemView) {

            super(itemView);
            tvCode=itemView.findViewById(R.id.tv_code);
            tvMenu=itemView.findViewById(R.id.tv_menu);
            tvQuantity=itemView.findViewById(R.id.tv_quantity);
            tvServesIn=itemView.findViewById(R.id.tv_servesin);
            tvRate=itemView.findViewById(R.id.tv_rate);
            tvAmount=itemView.findViewById(R.id.tv_amount);
        }
    }
}
