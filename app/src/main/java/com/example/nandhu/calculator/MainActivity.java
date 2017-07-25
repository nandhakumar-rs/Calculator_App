package com.example.nandhu.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    TextView text;
    String showString = "";
    String leftString = "",rightString = "";
int result=0;
Operation operate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button one = (Button) findViewById(R.id.one);
        Button two = (Button) findViewById(R.id.two);
        Button three = (Button) findViewById(R.id.three);
        Button four = (Button) findViewById(R.id.four);
        Button five = (Button) findViewById(R.id.five);
        Button six = (Button) findViewById(R.id.six);
        Button seven = (Button) findViewById(R.id.seven);
        Button eight = (Button) findViewById(R.id.eight);
        Button nine = (Button) findViewById(R.id.nine);
        Button zero = (Button) findViewById(R.id.zero);
        Button clear = (Button) findViewById(R.id.clear);
        ImageButton mul = (ImageButton) findViewById(R.id.mul);
        ImageButton div = (ImageButton) findViewById(R.id.div);
        ImageButton add = (ImageButton) findViewById(R.id.add);
        ImageButton sub = (ImageButton) findViewById(R.id.sub);
        ImageButton equal = (ImageButton) findViewById(R.id.equal);

        text = (TextView) findViewById(R.id.result);
        text.setText("");
        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
pressNumber(1);
            }
        });
        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pressNumber(2);
            }
        });

        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pressNumber(3);
            }
        });

        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pressNumber(4);
            }
        });

        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pressNumber(5);
            }
        });

        six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pressNumber(6);
            }
        });

        seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pressNumber(7);
            }
        });

        eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pressNumber(8);
            }
        });

        nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pressNumber(9);
            }
        });

        zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pressNumber(0);
            }
        });

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setOperation(Operation.ADD);
            }
        });

        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
setOperation(Operation.SUB);
            }
        });

        mul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
setOperation(Operation.MULTIPY);
            }
        });

        div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
setOperation(Operation.DIVIDE);
            }
        });

        equal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
setOperation(Operation.EQUAL);
            }
        });

        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showString = "";
                operate = null;
                result =0;
                leftString ="";
                rightString = "";
                text.setText(showString);
            }
        });

    }

public  void  setOperation(Operation op){
    if (operate != null) {

        if (showString != "") {
            rightString = showString;
            showString = "";

            switch (operate) {
                case ADD:
                    result = Integer.parseInt(leftString) + Integer.parseInt(rightString);
                    break;
                case SUB:
                    result = Integer.parseInt(leftString) - Integer.parseInt(rightString);
                    break;
                case MULTIPY:
                    result = Integer.parseInt(leftString) * Integer.parseInt(rightString);
                    break;
                case DIVIDE:
                    result = Integer.parseInt(leftString) / Integer.parseInt(rightString);
                    break;
            }

            leftString = String.valueOf(result);
            text.setText(leftString);
        }


    } else {
        leftString = showString;
        showString = "";
    }

    operate = op;
}

    public void pressNumber(int number) {
        showString += String.valueOf(number);
        text.setText(showString);
    }
    public  enum  Operation {
        ADD,SUB,MULTIPY,DIVIDE,EQUAL
    }
}
