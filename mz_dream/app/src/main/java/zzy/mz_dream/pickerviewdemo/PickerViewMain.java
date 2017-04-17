package zzy.mz_dream.pickerviewdemo;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.bigkoo.pickerview.TimePickerView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import zzy.mz_dream.R;

/**
 * Author: mz_dream  PC:MZ
 * Time: 2017/4/14 15:54
 * Email: 826680069@qq.com
 * Instruction:时间选择器
 */
public class PickerViewMain extends AppCompatActivity implements View.OnClickListener {

    private Button btnPview,btnCustumTime,btnCustumTime2;

    private TimePickerView pvTime;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pickerview_main);

        btnPview = (Button) findViewById(R.id.btnPview);
        btnCustumTime = (Button) findViewById(R.id.btnCustumTime);
        btnCustumTime2 = (Button) findViewById(R.id.btnCustumTime2);

        btnPview.setOnClickListener(this);
        btnCustumTime.setOnClickListener(this);
        btnCustumTime2.setOnClickListener(this);

        initTimePicker();


    }

    @Override
    public void onClick(View view) {

        if (view.getId() == R.id.btnPview && pvTime != null) {
            pvTime.show(view);//弹出时间选择器，传递参数过去，回调的时候则可以绑定此view

        }else if(view.getId()==R.id.btnCustumTime){
            Intent intent = new Intent();
            intent.setClass(PickerViewMain.this, CustomTimePicker.class);
            startActivity(intent);
        }else if(view.getId()==R.id.btnCustumTime2){
            Intent intent = new Intent();
            intent.setClass(PickerViewMain.this, ConditionsSelector.class);
            startActivity(intent);
        }
    }

    private void initTimePicker() {
        //控制时间范围(如果不设置范围，则使用默认时间1900-2100年，此段代码可注释)
        //因为系统Calendar的月份是从0-11的,所以如果是调用Calendar的set方法来设置时间,月份的范围也要是从0-11
        Calendar selectedDate = Calendar.getInstance();
        Calendar startDate = Calendar.getInstance();
        startDate.set(2013, 0, 14);

        Calendar endDate = Calendar.getInstance();
        endDate.set(2019, 11, 28);
        //时间选择器
        pvTime = new TimePickerView.Builder(this, new TimePickerView.OnTimeSelectListener() {
            @Override
            public void onTimeSelect(Date date, View v) {//选中事件回调

                 /*btnPview.setText(getTime(date));*/
                Button btn = (Button) v;
                btn.setText(getTime(date));


            }
        })
                .setType(TimePickerView.Type.YEAR_MONTH_DAY)
                .setLabel("", "", "", "", "", "")//设置空字符串以隐藏单位提示
                .setDividerColor(Color.DKGRAY)
                .setContentSize(20)//字体大小
                .setDate(selectedDate)//默认当前时间
                .setRangDate(startDate, endDate)
                .build();


    }


    private String getTime(Date date) {//可根据需要自行截取数据显示
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return format.format(date);
    }
}
