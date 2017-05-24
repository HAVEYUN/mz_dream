package zzy.mz_dream.activity.broadCaset;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import static android.content.ContentValues.TAG;

/**
 * 3、第三个接收者
 * onReceive函数不做耗时操作 参考值：10s
 * Created by MZ on 2017/5/24.
 */

public class ThirstReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        String str = intent.getStringExtra("msg");
        Log.i(TAG, "onReceive: "+str);
    }
}
