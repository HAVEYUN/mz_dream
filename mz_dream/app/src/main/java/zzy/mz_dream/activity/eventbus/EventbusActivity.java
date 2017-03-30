package zzy.mz_dream.activity.eventbus;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import org.greenrobot.eventbus.EventBus;

import zzy.mz_dream.R;
import zzy.mz_dream.databinding.EventbusActivityBinding;
import zzy.mz_dream.model.MsgeventModel;

/**
 * Author: mz_dream  PC:MZ
 * Time: 2017/3/28 14:15
 * Email: 826680069@qq.com
 * Instruction: please enter class instruction here
 */
public class EventbusActivity extends AppCompatActivity {

    EventbusActivityBinding mBinding;
    MsgeventModel mMsgeventModel = new MsgeventModel("loveshowonline",1010);

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mBinding = DataBindingUtil.setContentView(this, R.layout.eventbus_activity);

        mBinding.btnEvent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EventBus.getDefault().postSticky(mMsgeventModel);
                Intent intent = new Intent(EventbusActivity.this, ReceiveMsgActivity.class);
                startActivity(intent);


            }
        });

    }

    public void onClick(View view) {
        finish();

    }

}
