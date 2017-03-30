package zzy.mz_dream.activity.intent;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import zzy.mz_dream.R;

/**
 * Author: mz_dream  PC:MZ
 * Time: 2017/3/24 15:19
 * Email: 826680069@qq.com
 * Instruction: please enter class instruction here
 */
public class ReceiveBaseActivity extends Activity {
    private static final String TAG = "ReceiveBaseActivity";
    TextView tvContent;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.intent_receive_activity);

        Intent intent = getIntent();
        final String data_array = intent.getStringExtra("data_array");
        Log.e(TAG, "onClick: " + data_array);

        tvContent = (TextView) findViewById(R.id.tvContent);
        Button btnGetContent = (Button) findViewById(R.id.btnGetContent);

        btnGetContent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                tvContent.setText(data_array);

            }
        });


    }
}
