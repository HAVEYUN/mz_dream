package zzy.mz_dream.activity.intent;

import android.app.Activity;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;

import zzy.mz_dream.R;
import zzy.mz_dream.databinding.IntentBaseUsageBinding;

/**
 * Author: mz_dream  PC:MZ
 * Time: 2017/3/24 14:51
 * Email: 826680069@qq.com
 * Instruction: please enter class instruction here
 */
public class IntentActivity extends Activity {
    IntentBaseUsageBinding mBinding;
    String data = new String("岁月从不败美人");
    private static final String TAG = "IntentActivity";

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.intent_base_usage);
        initView();
    }


    public void IntentUsage(View view) {
        Intent intent = new Intent();
        intent.putExtra("data_array", data);
        intent.setClass(IntentActivity.this, ReceiveBaseActivity.class);
        startActivity(intent);

    }
//    ------------------------------ 华丽分割线 ------------------------------------------------------


    public void initView() {
        mBinding.btnIntent2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(IntentActivity.this, ReceivebackValueActivity.class);
                startActivityForResult(intent, 1);
            }
        });

    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);

        Log.e(TAG, "onActivityResult: " + data);


        switch (requestCode) {
            case 1:
                if (resultCode == RESULT_OK) {

                    String dataStringExtra = data.getStringExtra("data_backvalue");
                    mBinding.tvContent.setText(dataStringExtra);

                }

                break;
        }
    }
}
