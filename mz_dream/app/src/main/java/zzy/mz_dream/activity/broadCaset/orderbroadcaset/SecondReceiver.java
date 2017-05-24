package zzy.mz_dream.activity.broadCaset.orderbroadcaset;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

/**
 * 2、第二个接收者
 * onReceive函数不做耗时操作 参考值：10s
 * Created by MZ on 2017/5/24.
 */

public class SecondReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        /**
         * 用getResultExtras(boolean flag)接收前面的接收器存放的数据。
         * 其中的boolean参数含义为：true代表如果前面的接收器没有存放数据，则自动创建一个空的Bundle对象;
         * false则表示如果前面的接收器如果没有存放任何数据则返回null；
         */
        String msg = getResultExtras(true).getString("msg");
        Log.i("SecondReceiver:", msg);

        //转播
        Bundle bundle = new Bundle();
        bundle.putString("msg", msg + "SecondReceiver->");
        setResultExtras(bundle);

        //试图终止广播
//        abortBroadcast();

    }
}
