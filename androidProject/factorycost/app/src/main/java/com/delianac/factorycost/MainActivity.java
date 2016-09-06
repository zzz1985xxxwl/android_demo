package com.delianac.factorycost;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init(){
       this.getSupportActionBar().hide();

    }

    public void gotoInquiry(View view){
        Toast.makeText(this,"去询价",Toast.LENGTH_SHORT).show();
        startActivity(new Intent("com.delianac.factorycost.InquiryActivity"));
    }
    public void gotoInquiryHistory(View view){
        Toast.makeText(this,"历史",Toast.LENGTH_SHORT).show();
    }
    public void gotoPoint(View view){
        Toast.makeText(this,"返点",Toast.LENGTH_SHORT).show();
    }
}
