package com.comlu.navinsandroidtutorial.srm_billingapp;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class ReturnResultActivity extends AppCompatActivity implements OnClickListener {
   double val1,val2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_return_result);
        TextView tv1=(TextView)findViewById(R.id.textView2);
        TextView tv2=(TextView)findViewById(R.id.textView4);
        ImageButton imb1=(ImageButton)findViewById(R.id.imageButton);
        imb1.setOnClickListener(this);
        ImageButton imb2=(ImageButton)findViewById(R.id.imageButton1);
        imb2.setOnClickListener(this);
        ImageButton imb3=(ImageButton)findViewById(R.id.imageButton2);
        imb3.setOnClickListener(this);
        ImageButton imb4=(ImageButton)findViewById(R.id.imageButton3);
        imb4.setOnClickListener(this);
        Bundle bundle = getIntent().getExtras();
        tv1.setText(""+bundle.getDouble("value1"));
        tv2.setText(""+bundle.getDouble("value2"));
         val1=bundle.getDouble("value1");
        val2=bundle.getDouble("value2");

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_return_result, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {

        if (v.getId() == R.id.imageButton) {
            setResult(RESULT_OK, calculate(val1, val2, '+'));

            //finish();
        } else if (v.getId() == R.id.imageButton1) {
            setResult(RESULT_OK, calculate(val1,val2,'-'));
            //finish();


        }
        else if (v.getId() == R.id.imageButton2) {
            setResult(RESULT_OK, calculate(val1,val2,'/'));
            //finish();

        }
        else if (v.getId() == R.id.imageButton3) {
            setResult(RESULT_OK, calculate(val1,val2,'*'));
            //finish();

        }
        finish();
    }
    Intent calculate(double v,double v1,char op)
    {
        Intent data = new Intent();
        Double result=0.0;
        switch(op) {
            case '+':  result = val1 + val2;
                     break;
            case '-':  result = val1 - val2;
                break;
            case '/':  result = val1 / val2;
                break;
            case '*':  result = val1 * val2;
                break;
        }

        data.setData(Uri.parse(result.toString()));

        return data;

    }
}
