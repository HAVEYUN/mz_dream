a、Fragment类中定义一个接口。
b、Activity内进行接口实现。
c、Fragment在onAttach()函数里面捕获接口实现，并且调用接口方法和Activity通信。
    
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
    
