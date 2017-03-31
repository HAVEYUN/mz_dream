package zzy.mz_dream.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import zzy.mz_dream.R;

/**
 * Author: mz_dream  PC:MZ
 * Time: 2017/3/31 16:16
 * Email: 826680069@qq.com
 * Instruction: please enter class instruction here
 */
public class ContentFragment extends Fragment {
    View mView;
    TextView tvContent;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.content_fragment, null);

        tvContent = (TextView) mView.findViewById(R.id.tvContent);
        return mView;
    }

    public void ShowMsg(String msg) {
        tvContent.setText(msg);

    }

}
