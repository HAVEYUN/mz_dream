package zzy.mz_dream.activity;

import android.app.Activity;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Toast;

import zzy.mz_dream.R;
import zzy.mz_dream.databinding.ActivityDatabindingBinding;
import zzy.mz_dream.model.User;

/**
 * Author: mz_dream  PC:MZ
 * Time: 2017/3/23 16:35
 * Email: 826680069@qq.com
 * Instruction:dataBinding的使用
 *
 * 变量绑定：
 * 相比以前使用的xml，根节点由具体的某个layout（比如LinearLayout ）变成了layout，
 * 里面包括了data节点和传统的视图。这里的data节点就像是连接 View 和 Modle 的桥梁
 * <p>
 * 事件绑定：（方法引用、监听器绑定）
 */
public class DatabindingActivity extends Activity {
    ActivityDatabindingBinding mBinding;

    User mUser = new User("zzyClick", 10);

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_databinding);
        mBinding.tvPassword.setText("10-->1010");//1、databinding
        mBinding.setPresenter(new presenter());

    }

    //事件绑定
    public class presenter {

        //2、方法引用onTextChanged
        public void onTextChanged(CharSequence s, int start, int count, int after) {
            mUser.setName(s.toString());
            mBinding.setUser(mUser);
        }

        //2.2返回
        public void onClick(View view) {
            finish();
        }

        //3、监听器绑定，未完成...
        public void onClicklistenerBing(User user) {
            Toast.makeText(DatabindingActivity.this, user.getAge(), Toast.LENGTH_SHORT).show();

        }


    }

}
