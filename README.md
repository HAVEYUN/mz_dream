# mz_dream
myMream

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
    
    
 实例1：Fragment与它所依附的Activity的通信
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
    
    
