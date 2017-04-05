package zzy.mz_dream.calculatorDemo;

import android.app.Activity;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import zzy.mz_dream.R;
import zzy.mz_dream.databinding.ColculatorActivityBinding;

/**
 * Created by MZ on 2017/4/4.
 * 内容：计算器
 * 知识点：自定义选择器
 *
 */

public class ColculatorActivity extends Activity implements View.OnClickListener {

    ColculatorActivityBinding mBinding;
    boolean clear_flag;//清空标示


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.colculator_activity);
        initView();


    }

    public void initView() {
        mBinding.etInput.setOnClickListener(this);
        mBinding.btn0.setOnClickListener(this);
        mBinding.btn1.setOnClickListener(this);
        mBinding.btn2.setOnClickListener(this);
        mBinding.btn3.setOnClickListener(this);
        mBinding.btn4.setOnClickListener(this);
        mBinding.btn5.setOnClickListener(this);
        mBinding.btn6.setOnClickListener(this);
        mBinding.btn7.setOnClickListener(this);
        mBinding.btn8.setOnClickListener(this);
        mBinding.btn9.setOnClickListener(this);
        mBinding.btnPlus.setOnClickListener(this);//加
        mBinding.btnJian.setOnClickListener(this);//减
        mBinding.btnMultiply.setOnClickListener(this);//乘
        mBinding.btnDivide.setOnClickListener(this);//除
        mBinding.btnEqual.setOnClickListener(this);//等
        mBinding.btnPoint.setOnClickListener(this);//点
        mBinding.btnClear.setOnClickListener(this);//清除
        mBinding.btndel.setOnClickListener(this);//取消


    }

    @Override
    public void onClick(View v) {

        String str = mBinding.etInput.getText().toString();

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
                    clear_flag = false;
                    str = "";
                    mBinding.etInput.setText("");

                }
                mBinding.etInput.setText(str + ((Button) v).getText());
                break;

            case R.id.btn_plus:
            case R.id.btn_jian:
            case R.id.btnMultiply:
            case R.id.btnDivide:
                if (clear_flag) {
                    clear_flag = false;
                    str = "";
                    mBinding.etInput.setText("");

                }
                mBinding.etInput.setText(str + " " + ((Button) v).getText() + " ");
                break;
            case R.id.btnClear:
                clear_flag = false;
                str = "";
                mBinding.etInput.setText("");
                break;

            case R.id.btndel:
                if (clear_flag) {
                    clear_flag = false;
                    str = "";

                    mBinding.etInput.setText("");

                } else if (str != null && !str.equals("")) {
                    mBinding.etInput.setText(str.subSequence(0, str.length() - 1));

                }

                break;
            case R.id.btnEqual:
                getResult();


            default:
                break;
        }

    }

    /**
     * 运算结果
     */
    public void getResult() {
        String exp = mBinding.etInput.getText().toString();

        if (exp == null || exp.equals("")) {
            return;

        }
        if (!exp.contains(" ")) {//如果没有空格直接返回（只按数字键）
            return;
        }
//标识flag
        if (clear_flag) {
            clear_flag = false;
            return;

        }

        clear_flag = true;

        double result = 0;
        String s1 = exp.substring(0, exp.indexOf(" "));//运算符前面的字符串
        String op = exp.substring(exp.indexOf(" ") + 1, exp.indexOf(" ") + 2);//运算符
        String s2 = exp.substring(exp.indexOf(" ") + 3);//运算符后面字符串
//-----------------1 s1,s2都不为空
        if (!s1.equals("") && !s2.equals("")) {

            double d1 = Double.parseDouble(s1);
            double d2 = Double.parseDouble(s2);

            if (op.equals("+")) {
                result = d1 + d2;
            } else if (op.equals("-")) {
                result = d1 - d2;

            } else if (op.equals("X")) {
                result = d1 * d2;

            } else if (op.equals("÷")) {
                if (d1 == 0) {
                    result = 0;


                } else {
                    result = d1 / d2;

                }

            }

            if (!s1.contains(".") && !s2.contains(".") && !op.equals("÷")) {
                int r = (int) result;
                mBinding.etInput.setText(r + "");

            } else {
                mBinding.etInput.setText(result + "");

            }

        } else if (!s1.equals("") && s2.equals("")) {
            mBinding.etInput.setText(exp);
//  ------------------------2 ：s1为空 s2不为空
        } else if (s1.equals("") && !s2.equals("")) {

            double d2 = Double.parseDouble(s2);

            if (op.equals("+")) {
                result = 0 + d2;
            } else if (op.equals("-")) {
                result = 0 - d2;

            } else if (op.equals("X")) {
                result = 0;//0

            } else if (op.equals("÷")) {

                result = 0;

            }

            if (!s2.contains(".")) {
                int r = (int) result;
                mBinding.etInput.setText(r + "");

            } else {
                mBinding.etInput.setText(result + "");

            }
//------------------3：s1 s2都为空
        } else {
            mBinding.etInput.setText("");

        }

    }
}
