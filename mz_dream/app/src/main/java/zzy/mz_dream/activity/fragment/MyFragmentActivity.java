package zzy.mz_dream.activity.fragment;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import zzy.mz_dream.R;
import zzy.mz_dream.databinding.FragmentActivityBinding;

/**
 * Author: mz_dream  PC:MZ
 * Time: 2017/3/30 10:17
 * Email: 826680069@qq.com
 * Instruction: activity中访问fragment
 */
public class MyFragmentActivity extends FragmentActivity {
    private static final String TAG = "MyFragmentActivity";

    FragmentActivityBinding mBinding;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mBinding = DataBindingUtil.setContentView(this, R.layout.fragment_activity);

        mBinding.btnFrag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TitleFragment titleFragment = (TitleFragment) getSupportFragmentManager().findFragmentById(R.id.frTitle);
                String str = titleFragment.MsgTitle();
                Log.e(TAG, "onClick: " + str);
                Toast.makeText(MyFragmentActivity.this, str, Toast.LENGTH_SHORT).show();


            }
        });

    }



}
