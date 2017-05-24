package zzy.mz_dream.activity.broadCaset;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import zzy.mz_dream.R;

/**
 * Created by MZ on 2017/5/24.
 */

public class SendBroadCast extends Activity{
    private static final String BROADCAST_ACTION = "com.zhidi.MY_BROADCAST";
    Button btBroad;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.normalbroadcast);

        btBroad = (Button) findViewById(R.id.btBroad);

        btBroad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //发送广播sendBroadcast
                Intent intent = new Intent(BROADCAST_ACTION);
                intent.putExtra("msg", "嗨，我是智递科技广播");
                sendBroadcast(intent);
                
            }
        });
    }
}
