package zzy.mz_dream.activity.intent;

import android.app.Activity;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import zzy.mz_dream.R;
import zzy.mz_dream.databinding.IntentBackvaluereceiveActivityBinding;

/**
 * Author: mz_dream  PC:MZ
 * Time: 2017/3/24 16:38
 * Email: 826680069@qq.com
 * Instruction: please enter class instruction here
 */
public class ReceivebackValueActivity extends Activity {
    IntentBackvaluereceiveActivityBinding mBinding;

    String data = "大秦帝国崛起-卷一";

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.intent_backvaluereceive_activity);

    }

    public void btnBackvalue(View view) {
        Intent intent = new Intent();
        intent.putExtra("data_backvalue",data );
        setResult(RESULT_OK, intent);
        finish();
    }
}
