package zzy.mz_dream.activity;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.Window;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import zzy.mz_dream.R;
import zzy.mz_dream.databinding.OkhttpActivityBinding;

/**
 * Author: mz_dream  PC:MZ
 * Time: 2017/3/24 11:44
 * Email: 826680069@qq.com
 * Instruction: Okhttp基础使用
 */
public class OkhttpActivity extends AppCompatActivity {
    private static final String TAG = "OkhttpActivity";
    OkhttpActivityBinding mBinding;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.okhttp_activity);

        mBinding.setPresenter(new Presenter());


    }

    public class Presenter {
        public void onClick(View view) {
            finish();
        }
    }

    public void DataGet(View view) {
        //1、全局执行者:拿到okhttpClient
        OkHttpClient okHttpClient = new OkHttpClient();

        //2、创建Request
        Request.Builder builder = new Request.Builder();
        Request request = builder.get().url("http://www.imooc.com/course/landingpagephp?from=phpkecheng").build();

        //3、将request封装成call
        Call call = okHttpClient.newCall(request);

        //4、执行call
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();

            }

            @Override
            public void onResponse(Call call, final Response response) throws IOException {
                final String string = response.body().string();
                Log.i(TAG, "onResponse: " + string);

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        mBinding.tvContent.setText(string);

                    }
                });


            }
        });

    }

}
