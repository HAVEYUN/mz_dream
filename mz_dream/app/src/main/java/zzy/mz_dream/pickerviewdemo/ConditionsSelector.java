package zzy.mz_dream.pickerviewdemo;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bigkoo.pickerview.OptionsPickerView;
import com.bigkoo.pickerview.listener.CustomListener;

import java.util.ArrayList;

import zzy.mz_dream.R;
import zzy.mz_dream.pickerviewdemo.bean.CardBean;
import zzy.mz_dream.pickerviewdemo.bean.ProvinceBean;

/**
 * Author: mz_dream  PC:MZ
 * Time: 2017/4/17 16:36
 * Email: 826680069@qq.com
 * Instruction: 条件选择器;自定义条件选择器
 */
public class ConditionsSelector extends AppCompatActivity implements View.OnClickListener {

    private ArrayList<ProvinceBean> options1Items = new ArrayList<>();
    private ArrayList<ArrayList<String>> options2Items = new ArrayList<>();

    private ArrayList<CardBean> cardItem = new ArrayList<>();

    /*条件选择器不联动*/
    private ArrayList<String> food = new ArrayList<>();
    private ArrayList<String> clothes = new ArrayList<>();
    private ArrayList<String> computer = new ArrayList<>();


    private Button btn_Options, btn_CustomOptions, btn_no_linkage;

    private OptionsPickerView pvOptions, pvCustomOptions, pvNoLinkOptions;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.conditions_activity);

        //最好等数据加载完毕再初始化并显示，以免数据量大的时候，还未加载完毕就显示，造成APP崩溃。
        initOptionData();
        initOptionPicker();

        getCardData();
        initCustomOptionPicker();

        getNoLinkData();
        initNoLinkOptions();

        btn_Options = (Button) findViewById(R.id.btn_Options);
        btn_CustomOptions = (Button) findViewById(R.id.btn_CustomOptions);
        btn_no_linkage = (Button) findViewById(R.id.btn_no_linkage);

        btn_Options.setOnClickListener(this);
        btn_CustomOptions.setOnClickListener(this);
        btn_no_linkage.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btn_Options && pvOptions != null) {
            pvOptions.show(); //弹出条件选择器
        } else if (view.getId() == R.id.btn_CustomOptions && pvCustomOptions != null) {
            pvCustomOptions.show();//弹出自定义条件选择器

        } else if (view.getId() == R.id.btn_no_linkage && pvNoLinkOptions != null) {
            pvNoLinkOptions.show();//不联动数据选择器

        }

    }

    private void initOptionPicker() {//条件选择器初始化

        /**
         * 注意 ：如果是三级联动的数据(省市区等)，请参照 JsonDataActivity 类里面的写法。
         */

        pvOptions = new OptionsPickerView.Builder(this, new OptionsPickerView.OnOptionsSelectListener() {
            @Override
            public void onOptionsSelect(int options1, int options2, int options3, View v) {
                //返回的分别是三个级别的选中位置
                String tx = options1Items.get(options1).getPickerViewText()
                        + options2Items.get(options1).get(options2)
                       /* + options3Items.get(options1).get(options2).get(options3).getPickerViewText()*/;
                btn_Options.setText(tx);
            }
        })
                .setTitleText("城市选择")
                .setContentTextSize(20)//设置滚轮文字大小
                .setDividerColor(Color.GREEN)//设置分割线的颜色
                .setSelectOptions(0, 1)//默认选中项
                .setBgColor(Color.BLACK)
                .setTitleBgColor(Color.DKGRAY)
                .setTitleColor(Color.LTGRAY)
                .setCancelColor(Color.YELLOW)
                .setSubmitColor(Color.YELLOW)
                .setTextColorCenter(Color.LTGRAY)
                .isCenterLabel(false) //是否只显示中间选中项的label文字，false则每项item全部都带有label。
                .setLabels("省", "市", "区")
                .build();

        //pvOptions.setSelectOptions(1,1);

        /*pvOptions.setPicker(options1Items);//一级选择器*/
        pvOptions.setPicker(options1Items, options2Items);//二级选择器
        /*pvOptions.setPicker(options1Items, options2Items,options3Items);//三级选择器*/

    }

    private void initOptionData() {

        /**
         * 注意：如果是添加JavaBean实体数据，则实体类需要实现 IPickerViewData 接口，
         * PickerView会通过getPickerViewText方法获取字符串显示出来。
         */

        //选项1
        options1Items.add(new ProvinceBean(0, "广东", "描述部分", "其他数据"));
        options1Items.add(new ProvinceBean(1, "湖南", "描述部分", "其他数据"));
        options1Items.add(new ProvinceBean(2, "广西", "描述部分", "其他数据"));

        //选项2
        ArrayList<String> options2Items_01 = new ArrayList<>();
        options2Items_01.add("广州");
        options2Items_01.add("佛山");
        options2Items_01.add("东莞");
        options2Items_01.add("珠海");
        ArrayList<String> options2Items_02 = new ArrayList<>();
        options2Items_02.add("长沙");
        options2Items_02.add("岳阳");
        options2Items_02.add("株洲");
        options2Items_02.add("衡阳");
        ArrayList<String> options2Items_03 = new ArrayList<>();
        options2Items_03.add("桂林");
        options2Items_03.add("玉林");
        options2Items.add(options2Items_01);
        options2Items.add(options2Items_02);
        options2Items.add(options2Items_03);

        /*--------数据源添加完毕---------*/
    }

    private void initCustomOptionPicker() {
        pvCustomOptions = new OptionsPickerView.Builder(this, new OptionsPickerView.OnOptionsSelectListener() {
            @Override
            public void onOptionsSelect(int options1, int options2, int options3, View v) {
                //返回的分别是三个级别的选中位置
                String tx = cardItem.get(options1).getPickerViewText();
                btn_CustomOptions.setText(tx);
            }
        })
                .setLayoutRes(R.layout.pickerview_custom_options, new CustomListener() {
                    @Override
                    public void customLayout(View v) {
                        final TextView tvSubmit = (TextView) v.findViewById(R.id.tv_finish);
                        final TextView tvAdd = (TextView) v.findViewById(R.id.tv_add);
                        ImageView ivCancel = (ImageView) v.findViewById(R.id.iv_cancel);

                        tvSubmit.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                pvCustomOptions.returnData();

                            }
                        });
                        ivCancel.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                pvCustomOptions.dismiss();

                            }
                        });
                        tvAdd.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                getCardData();//循环添加数据
                                pvCustomOptions.setPicker(cardItem);//点击添加立刻更新了
                            }
                        });
                    }
                })
                .isDialog(true)
                .build();

        pvCustomOptions.setPicker(cardItem);//添加数据

    }


    public void getCardData() {
        for (int i = 0; i < 5; i++) {
            cardItem.add(new CardBean(i, "怎么说" + i));

        }
    }

    public void initNoLinkOptions() {
        pvNoLinkOptions = new OptionsPickerView.Builder(this, new OptionsPickerView.OnOptionsSelectListener() {
            @Override
            public void onOptionsSelect(int options1, int options2, int options3, View v) {

//                String st = food.get(options1) + clothes.get(options2) + computer.get(options3);

            }
        }).setTitleText("不联动")
                .build();
        pvNoLinkOptions.setNPicker(food, clothes, computer);

    }

    private void getNoLinkData() {
        food.add("KFC");
        food.add("MacDonald");
        food.add("Pizza hut");

        clothes.add("Nike");
        clothes.add("Adidas");
        clothes.add("Anima");

        computer.add("ASUS");
        computer.add("Lenovo");
        computer.add("Apple");
        computer.add("HP");
    }

}
