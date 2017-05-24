package zzy.mz_dream.activity.broadCaset.orderbroadcaset;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import zzy.mz_dream.R;

/**
 * //有序广播没调试通过 没有打印Log
 * Created by MZ on 2017/5/24.
 */

public class SendBroadCast2 extends Activity{

    private static final String BROADCAST_ACTION2 = "com.zhidi.MY_BROADCAST2";

    private static final String BROADCAST_PERMISSION = "com.zhidi.MY_BROADCAST_PERMISSION";//权限标示

    Button btBroad2;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.orderbroadcast);

        btBroad2 = (Button) findViewById(R.id.btordBroad);

        btBroad2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //发送广播sendBroadcast
                Intent intent = new Intent(BROADCAST_ACTION2);
                intent.putExtra("msg", "嗨，我是智递科技广播");
                sendOrderedBroadcast(intent,BROADCAST_PERMISSION);
            }
        });
    }
}
