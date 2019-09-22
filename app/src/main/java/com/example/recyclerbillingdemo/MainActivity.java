package com.example.recyclerbillingdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.recyclerbillingdemo.adapter.TakeOrderRecyclerAdapter;
import com.example.recyclerbillingdemo.pojo.TakeOrderModel;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{



    public EditText etTableno,etWaitername,etCode,etMenu,etQuantity,etServesIn,etRate,etAmount;
    public TextView tvTotalAmount;
    public Button btnOpenTray,btnSubmitFood,btnTakeOrder;
    public RecyclerView rvMenu;
    public LinearLayout ll_menu;
    public TakeOrderRecyclerAdapter takeOrderRecyclerAdapter;
    public ArrayList<TakeOrderModel> takeOrderArrayList;
    public TakeOrderModel takeOrderModel;
    public static String TAG="MainActivity";
    public Dialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Basic Intialisation......
        init();


    }


    public void init() {

        //EditText Intialisation.....
        etTableno = findViewById(R.id.et_tableno);
        etWaitername = findViewById(R.id.et_waitername);

        //TextView Intialisation.....
//        tvTotalAmount=findViewById(R.id.tv_totalamount);

        //RecyclerView Intialisation....
        rvMenu = findViewById(R.id.rv_menu);

        //Button Intialisation.....
        btnOpenTray = findViewById(R.id.btn_openfood);
        //btnSubmitFood=findViewById(R.id.btn_menu);
        //    btnTakeOrder=findViewById(R.id.btn_takeorder);


        // Arraylist Intialising
        takeOrderArrayList = new ArrayList<>();

        takeOrderModel = new TakeOrderModel();

        //creating objects of OnClickListener Events....
        btnOpenTray.setOnClickListener(this);
        //btnSubmitFood.setOnClickListener(this);
//        btnTakeOrder.setOnClickListener(this);



    }


    public void calculateAmount(){
        //TextWatcher Events occur...
        etQuantity.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                try {
                    if(etQuantity.getText().toString().equals("")){
                        etAmount.getText().clear();
                    }
                    else {
                        int result = ((Integer.parseInt(etQuantity.getText().toString())) * (Integer.parseInt(etRate.getText().toString())));

                        etAmount.setText(String.valueOf(result));
                    }
                }catch (NumberFormatException e){e.printStackTrace();}
            }
        });

    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.btn_openfood:
                customDialog();
                    break;

            case R.id.btn_menu:



                break;

        }
    }

    public void customDialog(){
        // custom dialog
        dialog = new Dialog(this);
        dialog.setContentView(R.layout.custom_acceptmenu);
        dialog.setTitle("Title...");


        //LinearLayout Intialisation....
        ll_menu=dialog.findViewById(R.id.ll_data);

        etCode=dialog.findViewById(R.id.et_code);
        etMenu=dialog.findViewById(R.id.et_menu);
        etQuantity=dialog.findViewById(R.id.et_qty);
        etServesIn=dialog.findViewById(R.id.et_ServesIn);
        etRate=dialog.findViewById(R.id.et_rate);
        etAmount=dialog.findViewById(R.id.et_amount);
        btnSubmitFood=dialog.findViewById(R.id.btn_menu);
        // if button is clicked, close the custom dialog

        //Textwatcher event...
        calculateAmount();

        btnSubmitFood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                takeOrderModel=new TakeOrderModel(etCode.getText().toString(),etMenu.getText().toString(),etQuantity.getText().toString(),etServesIn.getText().toString(),etRate.getText().toString(),etAmount.getText().toString());

                takeOrderArrayList.add(takeOrderModel);

                //Toast.makeText(this, "Size"+ takeOrderArrayList.size(), Toast.LENGTH_SHORT).show();
                Log.e(TAG, "onClick: "+ takeOrderArrayList.size());

                //Log.e(TAG, "onClick: "+ takeOrderModel.toString());

                takeOrderRecyclerAdapter=new TakeOrderRecyclerAdapter(MainActivity.this, takeOrderArrayList);

                rvMenu.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false));
                rvMenu.setAdapter(takeOrderRecyclerAdapter);

                ll_menu.setVisibility(View.GONE);

                takeOrderRecyclerAdapter.notifyDataSetChanged();

                etCode.getText().clear();
                etMenu.getText().clear();
                etServesIn.getText().clear();
                etQuantity.getText().clear();
                etRate.getText().clear();
                etAmount.getText().clear();

                dialog.dismiss();
            }
        });

        dialog.show();
    }


}
