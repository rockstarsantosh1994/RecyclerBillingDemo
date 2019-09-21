package com.example.recyclerbillingdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
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
//        tvTotalAmount=findViewById(R.id.tv_totalamount);

        //RecyclerView Intialisation....
        rvMenu=findViewById(R.id.rv_menu);

        //Button Intialisation.....
        btnOpenTray=findViewById(R.id.btn_openfood);
        btnSubmitFood=findViewById(R.id.btn_menu);
    //    btnTakeOrder=findViewById(R.id.btn_takeorder);

        //LinearLayout Intialisation....
        ll_menu=findViewById(R.id.ll_data);

        // Arraylist Intialising
        takeOrderArrayList =new ArrayList<>();

        takeOrderModel=new TakeOrderModel();

        //creating objects of OnClickListener Events....
        btnOpenTray.setOnClickListener(this);
        btnSubmitFood.setOnClickListener(this);
//        btnTakeOrder.setOnClickListener(this);

        etServesIn.setText("Plate");
        etRate.setText("15");

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

                break;

        }
    }
}
