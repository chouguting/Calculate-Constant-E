package com.chouguting.calculuscalculateconstante;

import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.math.MathUtils;

import java.util.stream.IntStream;

public class MainActivity extends AppCompatActivity {


    double accuracy=1;
    double calculateNum=0;
    int imageIndex=0;

    private static final Integer[] headers = {
            R.drawable.header,
            R.drawable.header2,
            R.drawable.header3,
            R.drawable.header4,
            R.drawable.header5,
            R.drawable.header6
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView theNum= findViewById(R.id.nemberText);
        TextView accNum= findViewById(R.id.accuracyNum);
        accNum.setText("--");
        theNum.setText("--");
        int orientation = getResources().getConfiguration().orientation;
        ImageView headImage= findViewById(R.id.headerImage);
        if (orientation == Configuration.ORIENTATION_LANDSCAPE) {
            // In landscape

            headImage.setVisibility(View.GONE);
        } else {
            // In portrait
            headImage.setVisibility(View.VISIBLE);
        }
    }

    int isAreaMethod=0;
    public void nextNum(View view) {
        TextView accNum = findViewById(R.id.accuracyNum);
        TextView theNum = findViewById(R.id.nemberText);
        TextView method = findViewById(R.id.methodName);
        method.setText("面積算法");
        Button nextB= findViewById(R.id.nextButton);

        if(isAreaMethod==0){
            accNum.setText(Double.toString(accuracy));
            nextB.setText("下一個");
            isAreaMethod=1;
        }else {
            double sum = 0;
            accuracy = accuracy * 0.1;
            accNum.setText(Double.toString(accuracy));
            double indexTop = 1;
            double indexDown = 1;
            while (true) {
                sum = sum + (1 / indexTop) * accuracy;
                indexTop = indexTop + accuracy;
                if (sum >= 1) {
                    break;
                }
            }
            sum = 0;
            while (true) {
                indexDown = indexDown + accuracy;
                sum = sum + (1 / indexDown) * accuracy;
                if (sum >= 1) {
                    break;
                }
            }
            calculateNum = (indexTop + indexDown) / 2;
        }
        theNum.setText(Double.toString(calculateNum));
    }

    public void resetNum(View view) {
        ImageView headImage= findViewById(R.id.headerImage);
        Button nextB= findViewById(R.id.nextButton);
        TextView accNum= findViewById(R.id.accuracyNum);
        TextView method = findViewById(R.id.methodName);
        TextView theNum= findViewById(R.id.nemberText);
        nextB.setText("面積算法");
        imageIndex++;
        isAreaMethod=0;
        if(imageIndex==6)imageIndex=0;
        headImage.setImageResource(headers[imageIndex]);
        accuracy=1;
        accNum.setText("--");
        method.setText("請選擇算法");
        calculateNum=0;

        theNum.setText("--");
    }



    public  double Euler() {
        double e=1;
        double f=1;
        for ( int i=1; i <= 10000; i++) {
            f = f * (1.0 / i);
            if ( f == 0 ) break;
            e +=  f;
        }
        return e;
    }

    public void nextProductNum(View view) {
        Button nextB= findViewById(R.id.nextButton);
        nextB.setText("面積算法");
        TextView method = findViewById(R.id.methodName);
        method.setText("階乘算法");
        isAreaMethod=0;
        TextView accNum= findViewById(R.id.accuracyNum);

        accNum.setText("10000 iteration");
        TextView theNum= findViewById(R.id.nemberText);
        theNum.setText(Double.toString(Euler()));

    }
}
