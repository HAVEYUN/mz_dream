package zzy.mz_dream;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import zzy.mz_dream.activity.DatabindingActivity;
import zzy.mz_dream.activity.OkhttpActivity;
import zzy.mz_dream.activity.eventbus.EventbusActivity;
import zzy.mz_dream.activity.fragment.MyFragmentActivity;
import zzy.mz_dream.activity.intent.IntentActivity;
import zzy.mz_dream.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding mBinding;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        mBinding.setPresenter(new presenter());

    }

    public class presenter {

        //方法引用onClick
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.btnInto:
                    intent = new Intent();
                    intent.setClass(MainActivity.this, DatabindingActivity.class);
                    startActivity(intent);
                    break;

                case R.id.btnOkhttp:
                    intent = new Intent();
                    intent.setClass(MainActivity.this, OkhttpActivity.class);
                    startActivity(intent);
                    break;

                case R.id.btnIntent:
                    intent = new Intent();
                    intent.setClass(MainActivity.this, IntentActivity.class);
                    startActivity(intent);

                    break;

                case R.id.btnEvent:
                  intent = new Intent();
                    intent.setClass(MainActivity.this, EventbusActivity.class);
                    startActivity(intent);
                    break;

                case R.id.btnFrag:
                    intent = new Intent();
                    intent.setClass(MainActivity.this, MyFragmentActivity.class);
                    startActivity(intent);
                    break;
            }


        }

    }

}