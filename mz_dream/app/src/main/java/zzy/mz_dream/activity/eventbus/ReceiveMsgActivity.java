package zzy.mz_dream.activity.eventbus;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import zzy.mz_dream.R;
import zzy.mz_dream.databinding.EventActivityBinding;
import zzy.mz_dream.model.MsgeventModel;

/**
 * Author: mz_dream  PC:MZ
 * Time: 2017/3/28 15:53
 * Email: 826680069@qq.com
 * Instruction: please enter class instruction here
 */
public class ReceiveMsgActivity extends AppCompatActivity {
    EventActivityBinding mBinding;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.event_activity);

        mBinding.btnEventmsg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                EventBus.getDefault().register(ReceiveMsgActivity.this);

            }
        });

    }


    @Subscribe(threadMode = ThreadMode.MAIN, sticky = true)
    public void Msgregeste(MsgeventModel msgeventModel) {
        mBinding.tvContent.setText(msgeventModel.getName() + msgeventModel.getAge());
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        EventBus.getDefault().unregister(this);
    }
}
