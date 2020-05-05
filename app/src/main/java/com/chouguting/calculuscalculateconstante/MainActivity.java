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
            R.drawable.header6,
            R.drawable.header7
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

    double indexTop = 1;
    double indexDown = 1;
    int isFactorial = 0;
    double calE = 1;
    long factorialTime = 1;

    //面積算法
    public void nextNum(View view) throws InterruptedException {

        TextView accNum = findViewById(R.id.accuracyNum);
        TextView theNum = findViewById(R.id.nemberText);
        TextView method = findViewById(R.id.methodName);
        TextView upperText = findViewById(R.id.upper);
        TextView lowerText = findViewById(R.id.lower);
        TextView timesText = findViewById(R.id.timesTimeText);
        Button limB = findViewById(R.id.limitButton);
        ImageView headImage = findViewById(R.id.headerImage);
        Button nextB= findViewById(R.id.nextButton);
        Button productB = findViewById(R.id.productButton);
        headImage.setImageResource(R.drawable.area);
        method.setText("面積算法");
        timesText.setText("精度:");
        limB.setText("極限算法");
        productB.setText("階乘算法");

        isFactorial = 0;
        isLimitMethod = 0;
        if(isAreaMethod==0){
            accNum.setText(Double.toString(accuracy));
            upperText.setText(Double.toString(indexDown));
            lowerText.setText(Double.toString(indexTop));
            nextB.setText("下一個");
            isAreaMethod=1;
        }else {
            double sum = 0;
            accuracy = accuracy * 0.1;
            accNum.setText(Double.toString(accuracy));
            indexTop = 1;
            indexDown = 1;
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

        upperText.setText(Double.toString(indexDown));
        lowerText.setText(Double.toString(indexTop));
        theNum.setText(Double.toString(calculateNum));
    }

    //階乘算法
    public void nextProductNum(View view) {
        Button limB = findViewById(R.id.limitButton);
        Button nextB= findViewById(R.id.nextButton);
        Button productB = findViewById(R.id.productButton);
        TextView timesText = findViewById(R.id.timesTimeText);
        ImageView headImage = findViewById(R.id.headerImage);
        TextView method = findViewById(R.id.methodName);
        TextView accNum = findViewById(R.id.accuracyNum);
        TextView theNum = findViewById(R.id.nemberText);

        TextView upperText = findViewById(R.id.upper);
        TextView lowerText = findViewById(R.id.lower);
        upperText.setText("--");
        lowerText.setText("--");

        headImage.setImageResource(R.drawable.factorial);
        nextB.setText("面積算法");
        limB.setText("極限算法");
        timesText.setText("次數:");

        method.setText("階乘算法");
        isAreaMethod=0;
        isLimitMethod = 0;

        if (isFactorial == 0) {
            isFactorial = 1;
            productB.setText("下一個");
            theNum.setText(Double.toString(calE));
            accNum.setText(String.valueOf(factorialTime));
        } else {
            factorialTime = factorialTime + 1;
            accNum.setText(String.valueOf(factorialTime));
            double e = 1;
            double f = 1;
            for (int i = 1; i <= factorialTime; i++) {
                f = f * (1.0 / i);
                if (f == 0) break;
                e += f;
            }
            calE = e;
            theNum.setText(Double.toString(calE));
        }


    }


    //極限算法
    public void limitNum(View view) {
        Button nextB = findViewById(R.id.nextButton);
        Button limB = findViewById(R.id.limitButton);
        TextView timesText = findViewById(R.id.timesTimeText);
        TextView accNum = findViewById(R.id.accuracyNum);
        TextView theNum = findViewById(R.id.nemberText);
        TextView method = findViewById(R.id.methodName);
        Button productB = findViewById(R.id.productButton);
        ImageView headImage = findViewById(R.id.headerImage);
        headImage.setImageResource(R.drawable.limit);
        TextView upperText = findViewById(R.id.upper);
        TextView lowerText = findViewById(R.id.lower);
        upperText.setText("--");
        lowerText.setText("--");
        nextB.setText("面積算法");
        limB.setText("極限算法");
        timesText.setText("極限次數:");
        method.setText("極限算法");
        productB.setText("階乘算法");
        isFactorial = 0;
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
        Button productB = findViewById(R.id.productButton);
        TextView upperText = findViewById(R.id.upper);
        TextView lowerText = findViewById(R.id.lower);
        upperText.setText("--");
        lowerText.setText("--");
        nextB.setText("面積算法");
        productB.setText("階乘算法");
        limB.setText("極限算法");
        timesText.setText("精度:");
        imageIndex++;
        isAreaMethod = 0;
        isLimitMethod = 0;
        isFactorial = 0;
        calE = 1;
        factorialTime = 1;
        limitCurrent = 1;
        if (imageIndex == 7) imageIndex = 0;
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
