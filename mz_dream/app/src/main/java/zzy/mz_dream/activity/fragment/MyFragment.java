package zzy.mz_dream.activity.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import zzy.mz_dream.R;

/**
 * Author: mz_dream  PC:MZ
 * Time: 2017/3/31 10:08
 * Email: 826680069@qq.com
 * Instruction: activity中访问fragment
 */
public class MyFragment extends FragmentActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragmentmain_fragment);

        Button btnMain = (Button) findViewById(R.id.btnMain);
        btnMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TitleFragment titleFragment = (TitleFragment) getSupportFragmentManager().findFragmentById(R.id.ft_title);
                String info = titleFragment.MsgTitle();
                Toast.makeText(MyFragment.this, info, Toast.LENGTH_SHORT).show();

            }
        });
    }

    public String MsgInfo() {

        return "MyFragment中消息";
    }
}
