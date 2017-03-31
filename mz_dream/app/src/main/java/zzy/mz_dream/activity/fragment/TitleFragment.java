package zzy.mz_dream.activity.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import zzy.mz_dream.R;

/**
 * Author: mz_dream  PC:MZ
 * Time: 2017/3/31 10:09
 * Email: 826680069@qq.com
 * Instruction: fragment中访问activity
 */
public class TitleFragment extends Fragment {
    View mView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        mView = inflater.inflate(R.layout.fragmenttitle_fragment, null);
        Button btnAdd = (Button) mView.findViewById(R.id.btnAdd);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MyFragment myFragment = (MyFragment) getActivity();
                String str = myFragment.MsgInfo();
                Toast.makeText(myFragment, str, Toast.LENGTH_SHORT).show();

            }
        });

        return mView;
    }

    public String MsgTitle() {
        return "Titlefragment中消息";
    }
}
