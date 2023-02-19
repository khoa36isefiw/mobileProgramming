package hcmute.edu.vn.calculator;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.button.MaterialButton;

import java.util.concurrent.ExecutionException;


public class MainActivity extends AppCompatActivity {

    TextView resultTV, solutionTV;
    MaterialButton btnC, btnBracket;
    MaterialButton btnDivide, btnMul, btnPlus, btnMinus, btnEuquals;
    MaterialButton btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btn0;
    MaterialButton btnAC, btnDot;

    String process;
    Boolean checkBracket = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        resultTV = findViewById(R.id.resultTextView);
        solutionTV = findViewById(R.id.solutionTextView);

        btn0 = findViewById(R.id.button_0);
        btn1 = findViewById(R.id.button_1);
        btn2 = findViewById(R.id.button_2);
        btn3 = findViewById(R.id.button_3);
        btn4 = findViewById(R.id.button_4);
        btn5 = findViewById(R.id.button_5);
        btn6 = findViewById(R.id.button_6);
        btn7 = findViewById(R.id.button_7);
        btn8 = findViewById(R.id.button_8);
        btn9 = findViewById(R.id.button_9);
        btnDot = findViewById(R.id.button_dot);
        btnPlus = findViewById(R.id.button_add);
        btnMinus = findViewById(R.id.button_substract);
        btnMul = findViewById(R.id.button_multiply);
        btnDivide = findViewById(R.id.button_divide);
        btnEuquals = findViewById(R.id.button_equal);
        btnAC = findViewById(R.id.button_AC);
        btnC = findViewById(R.id.button_c);
        btnBracket = findViewById(R.id.button_open_bracket);
//        btnBrackClose = findViewById(R.id.button_close_bracket);



        //onClick listener
        btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resultTV.setText(resultTV.getText()+"0");
            }
        });
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resultTV.setText(resultTV.getText()+"1");
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resultTV.setText(resultTV.getText()+"2");
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resultTV.setText(resultTV.getText()+"3");
            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resultTV.setText(resultTV.getText()+"4");
            }
        });
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resultTV.setText(resultTV.getText()+"5");
            }
        });
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resultTV.setText(resultTV.getText()+"6");
            }
        });
        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resultTV.setText(resultTV.getText()+"7");
            }
        });
        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resultTV.setText(resultTV.getText()+"8");
            }
        });
        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resultTV.setText(resultTV.getText()+"9");
            }
        });
        btnDot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resultTV.setText(resultTV.getText()+".");
            }
        });

//        btnBrackOpen.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                resultTV.setText(resultTV.getText()+"(");
//            }
//        });

//        btnBrackOpen.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                resultTV.setText(resultTV.getText()+"(");
//                Toast.makeText(MainActivity.this, "Please choose ')'", Toast.LENGTH_LONG).show();
//
////                if(!btnBrackClose.isCheckable()) {
////                    btnEuquals.setEnabled(false);
////                }
//
//
////                if (checkBracket){
////                    process = resultTV.getText().toString();
////                    resultTV.setText(process + ")");
////                    checkBracket = true;
////                }
////                else{
////                    process = resultTV.getText().toString();
////                    resultTV.setText(process + "(");
////                    checkBracket = true;
////                }
//            }
//        });
//
//        btnBrackClose.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                resultTV.setText(resultTV.getText()+")");
//                Toast.makeText(MainActivity.this, "Please choose '('", Toast.LENGTH_LONG).show();
//
//                if (!btnBrackOpen.isCheckable() ) {
//                    btnEuquals.setEnabled(false);
//                }
//                else {
//                    btnEuquals.setEnabled(true);
//                }
//            }
//        });


//        btnBrackClose.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                resultTV.setText(resultTV.getText()+")");
//            }
//        });


        btnBracket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkBracket){
                    process = resultTV.getText().toString();
                    resultTV.setText(process + ")");
                    checkBracket = false;
                }
                else{
                    process = resultTV.getText().toString();
                    resultTV.setText(process + "(");
                    checkBracket = true;
                }
            }
        });


        // AC & Del
        btnAC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resultTV.setText("");
                solutionTV.setText("");
            }
        });

        // button C(Delete) - removes the last Character
        btnC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String val = resultTV.getText().toString();
                if (val.length()>0)
                    val = val.substring(0, val.length() - 1);
                resultTV.setText(val);
            }
        });

        //Operator
        btnPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resultTV.setText(resultTV.getText()+"+");
            }
        });
        btnMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resultTV.setText(resultTV.getText()+"-");
            }
        });
        btnMul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resultTV.setText(resultTV.getText()+"×");
            }
        });
        btnDivide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resultTV.setText(resultTV.getText()+"÷");
            }
        });
        btnEuquals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                if(!btnBrackClose.isClickable()) {
//                    Toast.makeText(MainActivity.this, "Your syntax is wrong", Toast.LENGTH_LONG).show();
//                    btnEuquals.setEnabled(false);
//                }
//                else {
//                    btnEuquals.setEnabled(true);
//
//                }
//                if (!btnBrackClose.isCheckable() || !btnBrackOpen.isCheckable()) {
//
//                    Toast.makeText(MainActivity.this, "Your syntax is wrong", Toast.LENGTH_LONG).show();
//                    btnEuquals.setEnabled(false);
//
//                }
//                else {
//                    btnEuquals.setEnabled(true);
                    String val = resultTV.getText().toString();
                    String replacedstr = val.replace('÷','/').replace('×','*');
                    double answer = eval(replacedstr);
                    resultTV.setText(String.valueOf(answer));
                    solutionTV.setText(val);
//                }
            }
        });
    }

    public static double eval(final String str) {
        return new Object() {
            int pos = -1, ch;

            void nextChar() {
                ch = (++pos < str.length()) ? str.charAt(pos) : -1;
            }

            boolean eat(int charToEat) {
                while (ch == ' ') nextChar();
                if (ch == charToEat) {
                    nextChar();
                    return true;
                }
                return false;
            }

            double parse() {
                nextChar();
                double x = parseExpression();
                if (pos < str.length()) throw new RuntimeException("Unexpected: " + (char)ch);
                return x;
            }

            // Grammar:
            // expression = term | expression `+` term | expression `-` term
            // term = factor | term `*` factor | term `/` factor
            // factor = `+` factor | `-` factor | `(` expression `)`
            //        | number | functionName factor | factor `^` factor

            double parseExpression() {
                double x = parseTerm();
                for (;;) {
                    if      (eat('+')) x += parseTerm(); // addition
                    else if (eat('-')) x -= parseTerm(); // subtraction
                    else return x;
                }
            }

            double parseTerm() {
                double x = parseFactor();
                for (;;) {
                    if (eat('*'))
                        x *= parseFactor(); // multiplication
                    else if (eat('/'))
                        x /= parseFactor(); // division

                    else return x;
                }
            }

            double parseFactor() {
                if (eat('+')) return parseFactor(); // unary plus
                if (eat('-')) return -parseFactor(); // unary minus

                double x;
                int startPos = this.pos;
                if (eat('(')) { // parenthesesx
                    x = parseExpression();
                    eat(')');
                } else if ((ch >= '0' && ch <= '9') || ch == '.') { // numbers
                    while ((ch >= '0' && ch <= '9') || ch == '.') nextChar();
                    x = Double.parseDouble(str.substring(startPos, this.pos));
                } else if (ch >= 'a' && ch <= 'z') { // functions
                    while (ch >= 'a' && ch <= 'z') nextChar();
                    String func = str.substring(startPos, this.pos);
                    x = parseFactor();

                } else {
                    throw new RuntimeException("Unexpected: " + (char)ch);
                }



                return x;
            }
        }.parse();
    }
}

