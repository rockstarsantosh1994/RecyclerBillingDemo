package com.example.recyclerbillingdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.recyclerbillingdemo.adapter.TakeOrderRecyclerAdapter;
import com.example.recyclerbillingdemo.pojo.TakeOrderArrayList;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{



    public EditText etTableno,etWaitername,etCode,etMenu,etQuantity,etServesIn,etRate,etAmount;
    public TextView tvTotalAmount;
    public Button btnOpenTray,btnSubmitFood,btnTakeOrder;
    public RecyclerView rvMenu;
    public LinearLayout ll_menu;
    public TakeOrderRecyclerAdapter takeOrderRecyclerAdapter;
    public ArrayList<TakeOrderArrayList> takeOrderArrayList;
    public TakeOrderArrayList setDataToArrayList;
    public static String TAG="MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Basic Intialisation......
        init();
    }


    public void init(){

        //EditText Intialisation.....
        etTableno=findViewById(R.id.et_tableno);
        etWaitername=findViewById(R.id.et_waitername);
        etCode=findViewById(R.id.et_code);
        etMenu=findViewById(R.id.et_menu);
        etQuantity=findViewById(R.id.et_qty);
        etServesIn=findViewById(R.id.et_ServesIn);
        etRate=findViewById(R.id.et_rate);
        etAmount=findViewById(R.id.et_amount);

        //TextView Intialisation.....
        tvTotalAmount=findViewById(R.id.tv_totalamount);

        //RecyclerView Intialisation....
        rvMenu=findViewById(R.id.rv_menu);

        //Button Intialisation.....
        btnOpenTray=findViewById(R.id.btn_openfood);
        btnSubmitFood=findViewById(R.id.btn_menu);
        btnTakeOrder=findViewById(R.id.btn_takeorder);

        //LinearLayout Intialisation....
        ll_menu=findViewById(R.id.ll_data);

        // Arraylist Intialising
        takeOrderArrayList=new ArrayList<>();



        //creating objects of OnClickListener Events....
        btnOpenTray.setOnClickListener(this);
        btnSubmitFood.setOnClickListener(this);
        btnTakeOrder.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.btn_openfood:
                    if(ll_menu.getVisibility()==View.GONE){
                        ll_menu.setVisibility(View.VISIBLE);
                    }
                    else ll_menu.setVisibility(View.GONE);
                    break;

            case R.id.btn_menu:
/*

                setDataToArrayList.setCode(etCode.getText().toString());
                setDataToArrayList.setMenu(etMenu.getText().toString());
                setDataToArrayList.setQuantity(etQuantity.getText().toString());
                setDataToArrayList.setServesin(etServesIn.getText().toString());
                setDataToArrayList.setRate(etRate.getText().toString());
                setDataToArrayList.setAmount(etAmount.getText().toString());

*/              setDataToArrayList=new TakeOrderArrayList(etCode.getText().toString(),etMenu.getText().toString(),
                    etQuantity.getText().toString(),etServesIn.getText().toString(),etRate.getText().toString(),
                        etAmount.getText().toString());

                takeOrderArrayList.add(setDataToArrayList);

                Toast.makeText(this, "Size"+takeOrderArrayList.size(), Toast.LENGTH_SHORT).show();
                Log.e(TAG, "onClick: "+takeOrderArrayList );

                Log.e(TAG, "onClick: "+takeOrderArrayList.toString());
                takeOrderRecyclerAdapter=new TakeOrderRecyclerAdapter(MainActivity.this,takeOrderArrayList);
                rvMenu.setAdapter(takeOrderRecyclerAdapter);

                break;

        }
    }
}
