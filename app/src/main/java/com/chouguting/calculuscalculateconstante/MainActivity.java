package com.chouguting.calculuscalculateconstante;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {


    double accuracy=1;
    double calculateNum=0;
    int imageIndex=0;
    int isAreaMethod = 0;
    Double limResult = 1.0;
    int isLimitMethod = 0;
    long limitCurrent = 1;

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
            // 橫
            headImage.setVisibility(View.GONE);
        } else {
            //直
            headImage.setVisibility(View.VISIBLE);
        }
    }


    //面積算法
    public void nextNum(View view) throws InterruptedException {

        TextView accNum = findViewById(R.id.accuracyNum);
        TextView theNum = findViewById(R.id.nemberText);
        TextView method = findViewById(R.id.methodName);
        TextView timesText = findViewById(R.id.timesTimeText);
        Button limB = findViewById(R.id.limitButton);
        ImageView headImage = findViewById(R.id.headerImage);
        Button nextB= findViewById(R.id.nextButton);
        headImage.setImageResource(R.drawable.area);
        method.setText("面積算法");
        timesText.setText("精度:");
        limB.setText("極限算法");


        isLimitMethod = 0;
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


    //階乘算法
    public void nextProductNum(View view) {
        Button limB = findViewById(R.id.limitButton);
        Button nextB= findViewById(R.id.nextButton);
        TextView timesText = findViewById(R.id.timesTimeText);
        ImageView headImage = findViewById(R.id.headerImage);
        TextView method = findViewById(R.id.methodName);
        TextView accNum = findViewById(R.id.accuracyNum);
        TextView theNum = findViewById(R.id.nemberText);

        headImage.setImageResource(R.drawable.factorial);
        nextB.setText("面積算法");
        limB.setText("極限算法");
        timesText.setText("次數:");

        method.setText("階乘算法");
        isAreaMethod=0;
        isLimitMethod = 0;

        accNum.setText("10000 iteration");


        double e = 1;
        double f = 1;
        for (int i = 1; i <= 10000; i++) {
            f = f * (1.0 / i);
            if (f == 0) break;
            e += f;
        }
        theNum.setText(Double.toString(e));

    }


    //極限算法
    public void limitNum(View view) {
        Button nextB = findViewById(R.id.nextButton);
        Button limB = findViewById(R.id.limitButton);
        TextView timesText = findViewById(R.id.timesTimeText);
        TextView accNum = findViewById(R.id.accuracyNum);
        TextView theNum = findViewById(R.id.nemberText);
        TextView method = findViewById(R.id.methodName);
        ImageView headImage = findViewById(R.id.headerImage);
        headImage.setImageResource(R.drawable.limit);
        nextB.setText("面積算法");
        limB.setText("極限算法");
        timesText.setText("極限次數:");
        method.setText("極限算法");
        isAreaMethod = 0;
        if (isLimitMethod == 0) {
            accNum.setText(String.valueOf(limitCurrent));
            limB.setText("下一個");
            isLimitMethod = 1;
        } else {
            limitCurrent = limitCurrent * 10;
            accNum.setText(String.valueOf(limitCurrent));
            limResult = Math.pow((1 + (1.0 / limitCurrent)), limitCurrent);
        }
        theNum.setText(Double.toString(limResult));
    }


    //重設按鈕
    public void resetNum(View view) {
        ImageView headImage = findViewById(R.id.headerImage);
        Button limB = findViewById(R.id.limitButton);
        Button nextB = findViewById(R.id.nextButton);
        TextView accNum = findViewById(R.id.accuracyNum);
        TextView method = findViewById(R.id.methodName);
        TextView timesText = findViewById(R.id.timesTimeText);
        TextView theNum = findViewById(R.id.nemberText);
        nextB.setText("面積算法");
        limB.setText("極限算法");
        timesText.setText("精度:");
        imageIndex++;
        isAreaMethod = 0;
        isLimitMethod = 0;
        limitCurrent = 1;
        if (imageIndex == 6) imageIndex = 0;
        limitCurrent = 1;
        limResult = 1.0;
        headImage.setImageResource(headers[imageIndex]);
        accuracy = 1;
        accNum.setText("--");
        method.setText("請選擇算法");
        calculateNum = 0;
        theNum.setText("--");
    }
}
