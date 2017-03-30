package zzy.mz_dream.activity.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import zzy.mz_dream.R;

/**
 * Author: mz_dream  PC:MZ
 * Time: 2017/3/30 17:01
 * Email: 826680069@qq.com
 * Instruction: fragment中访问activity
 */
public class TitleFragment extends Fragment {
    private static final String TAG = "TitleFragment";
    View mView;
    ImageView ivAdd;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.titlefragment_fragmnt, null);

        ivAdd = (ImageView) mView.findViewById(R.id.ivAdd);
        ivAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MyFragmentActivity fragmentActivity = (MyFragmentActivity) getActivity();

                String msg = fragmentActivity.MsgFragment();
                Log.e(TAG, "onClick: " + msg);
                Toast.makeText(getActivity(), msg, Toast.LENGTH_SHORT).show();


            }
        });
        return mView;

    }


    public String FragmentMsg() {
        return "TitleFragment中消息";

    }
}
