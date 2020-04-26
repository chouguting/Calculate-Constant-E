package com.chouguting.calculuscalculateconstante;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    double accuracy=1;
    double calculateNum=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView theNum=(TextView)findViewById(R.id.nemberText);
        TextView accNum=(TextView)findViewById(R.id.accuracyNum);
        accNum.setText(Double.toString(accuracy));
        theNum.setText(Double.toString(calculateNum));
    }

    public void nextNum(View view) {
        TextView accNum=(TextView)findViewById(R.id.accuracyNum);
        TextView theNum=(TextView)findViewById(R.id.nemberText);
        double sum=0;
        accuracy=accuracy*0.1;
        accNum.setText(Double.toString(accuracy));
        double indexTop=1;
        double indexDown=1;
        while (true){
            sum=sum+(1/indexTop)*accuracy;
            indexTop=indexTop+accuracy;
            if(sum>=1){
                break;
            }
        }
        sum=0;
        while (true){
            indexDown=indexDown+accuracy;
            sum=sum+(1/indexDown)*accuracy;
            if(sum>=1){
                break;
            }
        }
        calculateNum=(indexTop+indexDown)/2;
        theNum.setText(String.format("%.10f",calculateNum));
    }

    public void resetNum(View view) {
        accuracy=1;
        TextView accNum=(TextView)findViewById(R.id.accuracyNum);
        accNum.setText(Double.toString(accuracy));
        calculateNum=0;
        TextView theNum=(TextView)findViewById(R.id.nemberText);
        theNum.setText(Double.toString(calculateNum));
    }
}
