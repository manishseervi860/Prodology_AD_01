package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    Button one,two,three,four,five,six,seven,eight,nine,zero,add,sub,multi,div,equal,clear,point,mod;
    TextView insert,result;
    StringBuilder inputStringBuilder = new StringBuilder();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        one = findViewById(R.id.one);
        two = findViewById(R.id.two);
        three = findViewById(R.id.three);
        four = findViewById(R.id.four);
        five = findViewById(R.id.five);
        six = findViewById(R.id.six);
        seven = findViewById(R.id.seven);
        eight = findViewById(R.id.eight);
        nine = findViewById(R.id.nine);
        zero = findViewById(R.id.zero);
        add = findViewById(R.id.add);
        sub = findViewById(R.id.sub);
        multi = findViewById(R.id.multi);
        div = findViewById(R.id.div);
        equal = findViewById(R.id.equals);
        clear = findViewById(R.id.clear_text);
        point = findViewById(R.id.point);
        mod = findViewById(R.id.mod);
        insert = findViewById(R.id.insert);
        result = findViewById(R.id.result);

        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insert.setText(insert.getText()+"1");
            }
        });

        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insert.setText(insert.getText()+"2");
            }
        });

        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insert.setText(insert.getText()+"3");
            }
        });

        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insert.setText(insert.getText()+"4");
            }
        });

       five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insert.setText(insert.getText()+"5");
            }
        });

       six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insert.setText(insert.getText()+"6");
            }
        });


       seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insert.setText(insert.getText()+"7");
            }
        });

       eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insert.setText(insert.getText()+"8");
            }
        });

       nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insert.setText(insert.getText()+"9");
            }
        });

       zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insert.setText(insert.getText()+"0");
            }
        });

       add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insert.setText(insert.getText()+"+");
            }
        });

       sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insert.setText(insert.getText()+"-");
            }
        });


       multi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insert.setText(insert.getText()+"*");
            }
        });


       div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insert.setText(insert.getText()+"÷");
            }
        });

       mod.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insert.setText(insert.getText()+"%");
            }
        });

       point.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               insert.setText(insert.getText()+".");
           }
       });

       clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insert.setText("");
            }
        });

       equal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String expression = insert.getText().toString();
                try {
                    double res = evaluateExpression(expression);
                    result.setText(String.valueOf(res));
                } catch (Exception e) {
                    result.setText("Error");
                    e.printStackTrace();
                }
            }
       });

    }
    private double evaluateExpression(String expression) {
        try {
            // Replace ÷ with / and remove any leading/trailing whitespace
            expression = expression.replaceAll("÷", "/").trim();

            // Split the expression into operands and operators
            String[] tokens = expression.split("[-+*/%]");

            // If there are no operators, return the single operand as the result
            if (tokens.length == 1) {
                return Double.parseDouble(tokens[0]);
            }

            double result = Double.parseDouble(tokens[0]);

            for (int i = 1; i < tokens.length; i++) {
                String operator = expression.replaceAll("[0-9.]", "").substring(i - 1, i);
                double operand = Double.parseDouble(tokens[i]);

                switch (operator) {
                    case "+":
                        result += operand;
                        break;
                    case "-":
                        result -= operand;
                        break;
                    case "*":
                        result *= operand;
                        break;
                    case "/":
                        result /= operand;
                        break;
                    case "%":
                        result %= operand;
                        break;
                }
            }

            return result;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }


}