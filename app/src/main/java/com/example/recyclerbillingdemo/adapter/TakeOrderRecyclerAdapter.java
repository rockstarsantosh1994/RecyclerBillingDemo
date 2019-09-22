package com.example.recyclerbillingdemo.adapter;

import android.app.Dialog;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recyclerbillingdemo.R;
import com.example.recyclerbillingdemo.pojo.TakeOrderModel;

import java.util.ArrayList;

public class TakeOrderRecyclerAdapter extends RecyclerView.Adapter<TakeOrderRecyclerAdapter.TakeOrderViewHolder> {

    public Context context;
    public ArrayList<TakeOrderModel> takeOrderArrayListModel;
    TakeOrderModel takeOrderModel;
    public Dialog dialog;

    public TakeOrderRecyclerAdapter(Context context, ArrayList<TakeOrderModel> takeOrderArrayListModel) {
        this.context = context;
        this.takeOrderArrayListModel = takeOrderArrayListModel;
    }


    @NonNull
    @Override
    public TakeOrderViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.custom_takeorder_row, parent, false);
        return new TakeOrderViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull final TakeOrderViewHolder holder, final int position) {

        final TakeOrderModel packageModel = takeOrderArrayListModel.get(position);

        holder.tvCode.setText(packageModel.getCode());
        holder.tvMenu.setText(packageModel.getMenu());
        holder.tvQuantity.setText(packageModel.getQuantity());
        holder.tvServesIn.setText(packageModel.getServesin());
        holder.tvRate.setText(packageModel.getRate());
        holder.tvAmount.setText(packageModel.getAmount());

        holder.ivEditMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                /*holder.tvCode.setText(packageModel.getCode());
                holder.tvMenu.setText(packageModel.getMenu());
                holder.tvQuantity.setText(packageModel.getQuantity());
                holder.tvServesIn.setText(packageModel.getServesin());
                holder.tvRate.setText(packageModel.getRate());
                holder.tvAmount.setText(packageModel.getAmount());*/

                dialog = new Dialog(context);
                dialog.setContentView(R.layout.custom_acceptmenu);
                dialog.setTitle("Edit Order");

                //LinearLayout Intialisation....
                LinearLayout ll_menu = dialog.findViewById(R.id.ll_data);

                final EditText etCode = dialog.findViewById(R.id.et_code);
                final EditText etMenu = dialog.findViewById(R.id.et_menu);
                final EditText etQuantity = dialog.findViewById(R.id.et_qty);
                final EditText etServesIn = dialog.findViewById(R.id.et_ServesIn);
                final EditText etRate = dialog.findViewById(R.id.et_rate);
                final EditText etAmount = dialog.findViewById(R.id.et_amount);
                Button btnSubmitFood = dialog.findViewById(R.id.btn_menu);

                etCode.setText(packageModel.getCode());
                etMenu.setText(packageModel.getMenu());
                etQuantity.setText(packageModel.getQuantity());
                etServesIn.setText(packageModel.getServesin());
                etRate.setText(packageModel.getRate());
                etAmount.setText(packageModel.getAmount());

                // if button is clicked, close the custom dialog
                btnSubmitFood.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        holder.tvCode.setText(etCode.getText().toString());
                        holder.tvMenu.setText(etMenu.getText().toString());
                        holder.tvQuantity.setText(etQuantity.getText().toString());
                        holder.tvServesIn.setText(etServesIn.getText().toString());
                        holder.tvRate.setText(etRate.getText().toString());
                        holder.tvAmount.setText(etAmount.getText().toString());

                        notifyDataSetChanged();

                        dialog.dismiss();
                    }
                });

                dialog.show();
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


        Log.e("mytag", "onBindViewHolder: " + takeOrderArrayListModel.size());
    }


    public void customDialog() {
        // custom dialog
        dialog = new Dialog(context);
        dialog.setContentView(R.layout.custom_acceptmenu);
        dialog.setTitle("Title...");


        //LinearLayout Intialisation....
        LinearLayout ll_menu = dialog.findViewById(R.id.ll_data);

        EditText etCode = dialog.findViewById(R.id.et_code);
        EditText etMenu = dialog.findViewById(R.id.et_menu);
        EditText etQuantity = dialog.findViewById(R.id.et_qty);
        EditText etServesIn = dialog.findViewById(R.id.et_ServesIn);
        EditText etRate = dialog.findViewById(R.id.et_rate);
        EditText etAmount = dialog.findViewById(R.id.et_amount);
        Button btnSubmitFood = dialog.findViewById(R.id.btn_menu);
        // if button is clicked, close the custom dialog
        btnSubmitFood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                dialog.dismiss();
            }
        });

        dialog.show();
    }

    @Override
    public int getItemCount() {
        return takeOrderArrayListModel.size();
    }

    public class TakeOrderViewHolder extends RecyclerView.ViewHolder {

        public TextView tvCode, tvMenu, tvQuantity, tvServesIn, tvRate, tvAmount;

        public ImageView ivEditMenu, ivDeleteMenu;

        public TakeOrderViewHolder(@NonNull View itemView) {

            super(itemView);
            tvCode = itemView.findViewById(R.id.tv_code);
            tvMenu = itemView.findViewById(R.id.tv_menu);
            tvQuantity = itemView.findViewById(R.id.tv_quantity);
            tvServesIn = itemView.findViewById(R.id.tv_servesin);
            tvRate = itemView.findViewById(R.id.tv_rate);
            tvAmount = itemView.findViewById(R.id.tv_amount);
            ivEditMenu = itemView.findViewById(R.id.iv_edit);
            ivDeleteMenu = itemView.findViewById(R.id.iv_delete);
        }
    }
}
