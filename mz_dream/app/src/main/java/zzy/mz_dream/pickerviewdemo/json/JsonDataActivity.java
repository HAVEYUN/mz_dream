package zzy.mz_dream.pickerviewdemo.json;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import zzy.mz_dream.R;

/**
 * Author: mz_dream  PC:MZ
 * Time: 2017/4/18 16:59
 * Email: 826680069@qq.com
 * Instruction: please enter class instruction here
 */
public class JsonDataActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_json_data);

        initView();

    }

    private void initView() {
        findViewById(R.id.btn_data).setOnClickListener(this);
        findViewById(R.id.btn_show).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_data:

                  break;
            case R.id.btn_show:

                break;

        }

    }

    /**
     * 打印文本提示
     * @param msg
     */
    private void showToast(String msg) {
        Toast.makeText(JsonDataActivity.this, msg, Toast.LENGTH_SHORT).show();
    }
}
