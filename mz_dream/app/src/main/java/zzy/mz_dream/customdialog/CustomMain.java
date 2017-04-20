package zzy.mz_dream.customdialog;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import zzy.mz_dream.R;

/**
 * Author: mz_dream
 * Time: 2017/4/20 11:07
 * Description: Please add a description
 */
public class CustomMain extends AppCompatActivity {

    private Context mContext;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.customdialog_activity);
        mContext = this;
        testDialog();

    }

    /**
     * 测试自定义对话框
     */
    private void testDialog() {
        CustomDialog dialog = new CustomDialog(this, new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.dialog_btn_sure:
                        Toast.makeText(mContext, "重新拍照", Toast.LENGTH_SHORT).show();

                        break;
                }


            }


        });
        dialog.setTitle("温馨提醒");
        dialog.setTvMessage("您确定重新拍照吗");
        dialog.setBtnSure("重新拍照");
        dialog.setBtnCancel("还是算了吧");
        dialog.setbtnSureColor(mContext.getResources().getColor(R.color.colorPrimary));
//        dialog.setBtnSureEnable(false);//无效的确认按钮
//        dialog.setCancelable(false);//设为false 返回键不能退出
        dialog.show();
    }


}
