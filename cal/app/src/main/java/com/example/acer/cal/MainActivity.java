package com.example.acer.cal;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button btn_0 ;
    Button btn_1;
    Button btn_2;
    Button btn_3 ;
    Button btn_4 ;
    Button btn_5 ;
    Button btn_6 ;  //数字按钮
    Button btn_7 ;
    Button btn_8 ;
    Button btn_9 ;
    Button btn_point ;  //小数点按钮
    Button btn_clear ;
    Button btn_del ;
    Button btn_pluse ;
    Button btn_minus ;
    Button btn_multiply ;
    Button btn_divide ;
    Button btn_equle ;
    EditText et_input ;
    boolean clear_flag ;//清空标识
    String ch1=null;
    String ch2=null;
    String ch3=null;
    int i=0;
    int j=0;
    int k=0;
    int m=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_0 = (Button) findViewById(R.id.btn_0) ;
        btn_1 = (Button) findViewById(R.id.btn_1) ;
        btn_2 = (Button) findViewById(R.id.btn_2) ;
        btn_3 = (Button) findViewById(R.id.btn_3) ;
        btn_4 = (Button) findViewById(R.id.btn_4) ;
        btn_5 = (Button) findViewById(R.id.btn_5) ;
        btn_6 = (Button) findViewById(R.id.btn_6) ;
        btn_7 = (Button) findViewById(R.id.btn_7) ;
        btn_8 = (Button) findViewById(R.id.btn_8) ;
        btn_9 = (Button) findViewById(R.id.btn_9) ;
        btn_point = (Button) findViewById(R.id.btn_point) ;
        btn_clear = (Button) findViewById(R.id.btn_clear) ;
        btn_del = (Button) findViewById(R.id.btn_del) ;
        btn_pluse = (Button) findViewById(R.id.btn_plus) ;
        btn_minus = (Button) findViewById(R.id.btn_minus) ;
        btn_multiply = (Button) findViewById(R.id.btn_multiply) ;
        btn_divide = (Button) findViewById(R.id.btn_divide) ;
        btn_equle = (Button) findViewById(R.id.btn_equal) ;
//以上实例化按钮
        et_input = (EditText) findViewById(R.id.et_input);  //实例化之后的显示屏

        btn_0.setOnClickListener(this);
        btn_1.setOnClickListener(this);
        btn_2.setOnClickListener(this);
        btn_3.setOnClickListener(this);
        btn_4.setOnClickListener(this);
        btn_5.setOnClickListener(this);
        btn_6.setOnClickListener(this);
        btn_7.setOnClickListener(this);
        btn_8.setOnClickListener(this);
        btn_9.setOnClickListener(this);
        btn_point.setOnClickListener(this);
        btn_clear.setOnClickListener(this);
        btn_del.setOnClickListener(this);
        btn_pluse.setOnClickListener(this);
        btn_minus.setOnClickListener(this);
        btn_multiply.setOnClickListener(this);
        btn_divide.setOnClickListener(this);
        btn_equle.setOnClickListener(this);
        //设置以上按钮的点击事件


    }

    @Override
    public void onClick(View v) {
        String str = et_input.getText().toString();
        switch (v.getId()) {
            case R.id.btn_0:
            case R.id.btn_1:
            case R.id.btn_2:
            case R.id.btn_3:
            case R.id.btn_4:
            case R.id.btn_5:
            case R.id.btn_6:
            case R.id.btn_7:
            case R.id.btn_8:
            case R.id.btn_9:
            case R.id.btn_point:
                if (clear_flag) {
                    clear_flag =false ;
                    str ="" ;
                    et_input.setText("");
                }
                et_input.setText(str + ((Button)v).getText());
                i=i+1;
                k=k+1;
                break ;
            case R.id.btn_plus:
            case R.id.btn_minus:
            case R.id.btn_multiply:
            case R.id.btn_divide:
                if (clear_flag) {
                    clear_flag =false ;
                    str ="" ;
                    et_input.setText("");
                }
                et_input.setText(str + ((Button)v).getText()+"");
                if (i != 0) {
                    j = i;
                    i = 0;
                }else{
                    m=m+1;
                }
                break;
            case R.id.btn_del:
                if (clear_flag) {
                    clear_flag =false ;
                    str ="" ;
                    et_input.setText("");
                }else if (str!=null&&!str.equals("")){
                    et_input.setText(str.substring(0,str.length()-1));
                }
                break;
            case R.id.btn_clear:
                clear_flag =false ;
                str ="" ;
                et_input.setText("");
            case R.id.btn_equal:
                getResult();
                break ;

        }
    }
    /* 单独的调用运算结果
    *
    *
    * */
    private void getResult(){
        String exp = et_input.getText().toString();
        if (exp == null||exp.equals("")){
            return;
        }
       /* if(!exp.contains(" ")) {
            return;
        }*/
        if (clear_flag){
            clear_flag = false ;
            return;

        }
        clear_flag = true ;
        double result = 0 ;
        try{
            if (k > j && m == 0 && i != 0) {
                ch1 = exp.substring(0, j); //运算符前面的字符串
                ch2 = exp.substring(j, j + 1);
                ch3 = exp.substring(j + 1);
                double d1 = Double.parseDouble(ch1);
                double d2 = Double.parseDouble(ch3);
                if (ch2.equals("+")) {
                    result = d1 + d2;
                    et_input.setText(result + "");
                } else if (ch2.equals("-")) {
                    result = d1 - d2;
                    et_input.setText(result + "");
                } else if (ch2.equals("*")) {
                    result = d1 * d2;
                    et_input.setText(result + "");
                } else if (ch2.equals("/")) {
                    result = d1 / d2;
                    et_input.setText(result + "");
                }
            } else if (k == j && i == 0 && m == 0) {
                ch1 = exp.substring(0, j);
                double d1 = Double.parseDouble(ch1);
                result = d1;
                et_input.setText(result + "");

            } else if (m != 0 && i == k && j == 0) {
                ch1 = exp.substring(0, m);
                ch2 = exp.substring(m);
                double d2 = Double.parseDouble(ch2);

                if (ch3.equals("＋")) {
                    result = 0 + d2;
                    et_input.setText(result + "");
                } else if (ch3.equals("-")) {
                    result = 0 - d2;
                    et_input.setText(result + "");
                } else if (ch3.equals("*")) {
                    result = 0;
                    et_input.setText(result + "");
                } else if (ch3.equals("/")) {
                    result = 0;
                    et_input.setText(result + "");
                }
            } else if (k == i && i != 0 && m == 0 && j == 0) {
                ch1 = exp;
                double d1 = Double.parseDouble(ch1);
                ;
                result = d1;
                et_input.setText(result + "");
            }else {
                et_input.setText("");

            }
        }catch(IllegalArgumentException ex){//传递非法参数异常。s1  s2
        }catch (ArrayIndexOutOfBoundsException ex){
        }catch (ArithmeticException ex){//算术运算异常
        }catch (ArrayStoreException  ex){//向数组中存放与声明类型不兼容对象异常
        }catch (NegativeArraySizeException ex){//创建一个大小为负数的数组错误异常
        }catch (UnsupportedOperationException ex){//不支持的操作异常
        }catch (IndexOutOfBoundsException ex){//下标越界异常  符号
        }
        i = 0;
        j = 0;
        k = 0;
        m=0;
    }
}