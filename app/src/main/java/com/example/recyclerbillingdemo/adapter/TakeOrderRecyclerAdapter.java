package com.example.recyclerbillingdemo.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
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
    public void onBindViewHolder(@NonNull TakeOrderViewHolder holder, final int position) {

        TakeOrderModel packageModel = takeOrderArrayListModel.get(position);

        holder.tvCode.setText(packageModel.getCode());
        holder.tvMenu.setText(packageModel.getMenu());
        holder.tvQuantity.setText(packageModel.getQuantity());
        holder.tvServesIn.setText(packageModel.getServesin());
        holder.tvRate.setText(packageModel.getRate());
        holder.tvAmount.setText(packageModel.getAmount());

        holder.ivEditMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        holder.ivDeleteMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                takeOrderArrayListModel.remove(position);
                notifyItemRemoved(position);
                notifyItemRangeChanged(position, takeOrderArrayListModel.size());
            }
        });


        Log.e("mytag", "onBindViewHolder: "+takeOrderArrayListModel.size() );
    }

    @Override
    public int getItemCount() {
        return takeOrderArrayListModel.size();
    }

    public class TakeOrderViewHolder extends RecyclerView.ViewHolder{

        public TextView tvCode,tvMenu,tvQuantity,tvServesIn,tvRate,tvAmount;

        public ImageView ivEditMenu,ivDeleteMenu;

        public TakeOrderViewHolder(@NonNull View itemView) {

            super(itemView);
            tvCode=itemView.findViewById(R.id.tv_code);
            tvMenu=itemView.findViewById(R.id.tv_menu);
            tvQuantity=itemView.findViewById(R.id.tv_quantity);
            tvServesIn=itemView.findViewById(R.id.tv_servesin);
            tvRate=itemView.findViewById(R.id.tv_rate);
            tvAmount=itemView.findViewById(R.id.tv_amount);
            ivEditMenu=itemView.findViewById(R.id.iv_edit);
            ivDeleteMenu=itemView.findViewById(R.id.iv_delete);
        }
    }
}
