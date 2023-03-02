package hcmute.edu.vn.calculator;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.button.MaterialButton;

import java.util.concurrent.ExecutionException;
import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;



public class MainActivity extends AppCompatActivity {

    TextView resultTV, solutionTV;
    MaterialButton btnC, btnBracket;
    MaterialButton btnDivide, btnMul, btnPlus, btnMinus, btnEuquals, btnPercent;
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
        String total="";
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
        btnPercent = findViewById(R.id.button_square);




        // xét sự kiện - onClick listener cho từng button; Các button sẽ có chức năng khác nhau
        btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resultTV.setText(resultTV.getText()+"0");
                btnDot.setEnabled(true);
                btnMul.setEnabled(true);
                btnDivide.setEnabled(true);
            }
        });
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resultTV.setText(resultTV.getText()+"1");
                btnDot.setEnabled(true);
                btnMul.setEnabled(true);
                btnDivide.setEnabled(true);
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resultTV.setText(resultTV.getText()+"2");
                btnDot.setEnabled(true);
                btnMul.setEnabled(true);
                btnDivide.setEnabled(true);
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resultTV.setText(resultTV.getText()+"3"); // số 3 xuất hiện trên màn hình
                btnDot.setEnabled(true);
                btnMul.setEnabled(true);
                btnDivide.setEnabled(true);
            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resultTV.setText(resultTV.getText()+"4");
                btnDot.setEnabled(true);
                btnMul.setEnabled(true);
                btnDivide.setEnabled(true);
            }
        });
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resultTV.setText(resultTV.getText()+"5");
                btnDot.setEnabled(true);
                btnMul.setEnabled(true);
                btnDivide.setEnabled(true);
            }
        });
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resultTV.setText(resultTV.getText()+"6");
                btnDot.setEnabled(true);
                btnMul.setEnabled(true);
                btnDivide.setEnabled(true);
            }
        });
        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resultTV.setText(resultTV.getText()+"7");
                btnDot.setEnabled(true);
                btnMul.setEnabled(true);
                btnDivide.setEnabled(true);

            }
        });
        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resultTV.setText(resultTV.getText()+"8");
                btnDot.setEnabled(true);
                btnMul.setEnabled(true);
                btnDivide.setEnabled(true);

            }
        });
        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resultTV.setText(resultTV.getText()+"9");
                btnDot.setEnabled(true);
                btnMul.setEnabled(true);
                btnDivide.setEnabled(true);
            }
        });
        btnDot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resultTV.setText(resultTV.getText() + ".");
                btnDot.setEnabled(false);

            }
        });

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


        btnPercent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resultTV.setText(resultTV.getText()+"%");
                resultTV.setTextColor(Color.parseColor("#e21212"));



            }
        });

        //Operator
        btnPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                resultTV.setText(resultTV.getText()+"+");
                resultTV.setTextColor(Color.parseColor("#e21212"));

                btnDot.setEnabled(false);
                btnDivide.setEnabled(false);
                btnMul.setEnabled(false);
                //btnPercent.setEnabled(false);
            }
        });
        btnMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resultTV.setText(resultTV.getText()+"-");
                resultTV.setTextColor(Color.parseColor("#e21212"));

                btnDot.setEnabled(false);
                btnDivide.setEnabled(false);
                btnMul.setEnabled(false);
                //btnPercent.setEnabled(false);
            }
        });
        btnMul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resultTV.setText(resultTV.getText()+"×");
                resultTV.setTextColor(Color.parseColor("#e21212"));

                btnDot.setEnabled(false);
                btnDivide.setEnabled(false);

                btnMul.setEnabled(false);
                //btnPercent.setEnabled(false);
            }
        });
        btnDivide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resultTV.setText(resultTV.getText()+"÷");
                resultTV.setTextColor(Color.parseColor("#e21212"));

                btnDot.setEnabled(false);
                btnDivide.setEnabled(false);
                btnMul.setEnabled(false);
                //btnPercent.setEnabled(false);

            }
        });



        btnEuquals.setOnClickListener(new View.OnClickListener() {      // xử lý phép toán trả lại cho người dùng
            @Override
            public void onClick(View view) {
                try {
                    btnEuquals.setEnabled(true);
                    String val = resultTV.getText().toString();
                    checkDot();
                    String replacedstr = val.replace('÷', '/').replace('×', '*');

                    if (replacedstr.charAt(replacedstr.length() - 1) == '-'
                            || replacedstr.charAt(replacedstr.length() - 1) == '+'
                            || replacedstr.charAt(replacedstr.length() - 1) == '*'
                            || replacedstr.charAt(replacedstr.length() - 1) == '/') {

                        String a = "Error !!!";
                        resultTV.setText(a);
                    } else {
                        double answer = eval(replacedstr);
                        resultTV.setText(String.valueOf(answer));
                        solutionTV.setText(val);
                    }
                }catch (IllegalArgumentException ie){   // trả về lỗi khi người dùng cố tình nhập sai --> dẫn đến crash apps
                    resultTV.setText("Error !!");
                }
            }
        });
    }


    public void checkDot (){
        int count = 0;
        String val = resultTV.getText().toString();
        if (val.contains(".")) {
            count++;
        }
        if (count > 1)
            btnDot.setEnabled(false);
    };
        // hàm chính được dùng dể xử lý cho button Equal
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

            double parseExpression() {  // dùng để chuyển các toán tử
                double x = parseTerm();
                for (;;) {
                    if      (eat('+')) x += parseTerm(); // addition
                    else if (eat('-')) x -= parseTerm(); // subtraction



                    else return x;
                }
            }

            double parseTerm() {    // xử lý các phép nhân, chia %
                double x = parseFactor();
                for (;;) {
                    if (eat('*'))
                        x *= parseFactor(); // multiplication
                    else if (eat('/'))
                        x /= parseFactor(); // division
                    else if (eat('%'))
                        x /=100;
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

