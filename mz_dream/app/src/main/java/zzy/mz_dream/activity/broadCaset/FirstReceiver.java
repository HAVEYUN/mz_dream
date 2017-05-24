package zzy.mz_dream.activity.broadCaset;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * 1、第一个广播接收者。
 * onReceive函数不做耗时操作 参考值：10s
 * Created by MZ on 2017/5/24.
 */

public class FirstReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {

        String msg = intent.getStringExtra("msg");
        Log.i("FirstReceiver:", msg);

        //试图终止广播
        //abortBroadcast();
    }
}
