package zzy.mz_dream.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import zzy.mz_dream.R;

/**
 * Author: mz_dream  PC:MZ
 * Time: 2017/3/31 15:43
 * Email: 826680069@qq.com
 * Instruction: fragment与他依附的activity通信
 */
public class MenuFragment extends Fragment {
    private String[] array = new String[]{"android", "ios", "wephone"};

    View mView;
    ListView lvMenu;

    MenuItem mMenuItem;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        mView = inflater.inflate(R.layout.listviewfragment_fragment, null);

        lvMenu = (ListView) mView.findViewById(R.id.lvMenu);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, array);
        lvMenu.setAdapter(adapter);

        //具体实现方法在MyFragmentone中实现
        lvMenu.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> view, View view1, int position, long l) {
                mMenuItem.onSelect(position);
            }
        });

        return mView;
    }

    //1、fragment中定义一个接口
    public interface MenuItem {
        public void onSelect(int position);

    }

    //3、捕获接口实现
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        try {
            mMenuItem = (MenuItem) activity;
        } catch (Exception e) {

//            e.printStackTrace();
            throw new ClassCastException(activity.toString() + "没有实现OnMenuItemSelectedListener接口");
        }
    }
}
