package zzy.mz_dream.fragment;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.view.WindowManager;

import zzy.mz_dream.R;

/**
 * Author: mz_dream  PC:MZ
 * Time: 2017/3/31 16:01
 * Email: 826680069@qq.com
 * Instruction:管理者
 * <p>
 * 实例1：Fragment与它所依附的Activity的通信
 * 步骤：
 * a、Fragment类中定义一个接口。
 * b、Activity内进行接口实现。
 * c、Fragment在onAttach()函数里面捕获接口实现，并且调用接口方法和Activity通信。
 */
public class MyFragmentone extends FragmentActivity implements MenuFragment.MenuItem {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        //设置全屏
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.myfragment_fragment);
    }

    //2、activity中接口实现
    @Override
    public void onSelect(int position) {
        String msg = "";
        if (position == 0) {
            msg = "Android是一种基于Linux的自由及开放源代码的操作系统，主要使用于移动设备，如智能手机和平板电脑，由Google公司和开放手机联盟领导及开发。";
        }
        if (position == 1) {
            msg = "iOS是由苹果公司开发的移动操作系统。苹果公司最早于2007年1月9日的Macworld大会上公布这个系统，" +
                    "最初是设计给iPhone使用的，后来陆续套用到iPod touch、iPad以及Apple TV等产品上";
        }
        if (position == 2) {
            msg = "Windows Phone（简称：WP）是微软发布的一款手机操作系统。它将微软旗下的Xbox Live游戏、Xbox Music音乐与独特的视频体验集成至手机中。";
        }

        ContentFragment fragment = (ContentFragment) getSupportFragmentManager().findFragmentById(R.id.ftContent);
        fragment.ShowMsg(msg);

    }

    /**
     * 横屏
     *
     * 修改Activity的onResume方法
     */
    @Override
    protected void onResume() {

        if (getRequestedOrientation() != ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE) {
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        }

        super.onResume();
    }
}
