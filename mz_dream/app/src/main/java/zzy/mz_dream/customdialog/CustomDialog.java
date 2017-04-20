package zzy.mz_dream.customdialog;

import android.app.Dialog;
import android.content.Context;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import zzy.mz_dream.R;

/**
 * Author: mz_dream
 * Time: 2017/4/20 11:14
 * Description: Please add a description
 */
public class CustomDialog extends Dialog {

    private TextView mTvMessage, mTvTitle;
    private Button mBtnCancel, mBtnSure;
    private LinearLayout mLlTitle, mLlContent;
    private Context mContext;
    private View.OnClickListener mListener;

    protected CustomDialog(Context context, View.OnClickListener Listener) {
        super(context, R.style.Alert_Dialog_Style);
        mListener = Listener;
        mContext = context;
        init(context);
    }

    private void init(Context context) {
        View view = View.inflate(context, R.layout.widget_dialog, null);
        setContentView(view);
        init(view);

    }

    private void init(View v) {
        mLlTitle = (LinearLayout) v.findViewById(R.id.ll_title);
        mLlTitle.setVisibility(View.GONE);
        mLlContent = (LinearLayout) v.findViewById(R.id.ll_content);
        mTvTitle = (TextView) v.findViewById(R.id.tv_title);
        mTvMessage = (TextView) v.findViewById(R.id.tv_message);
        mBtnCancel = (Button) v.findViewById(R.id.dialog_btn_cancel);
        mBtnSure = (Button) v.findViewById(R.id.dialog_btn_sure);
        mBtnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
                if (mListener != null) {
                    mListener.onClick(view);

                }

            }
        });
        mBtnSure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
                if (mListener != null) {
                    mListener.onClick(view);

                }

            }
        });

        Window window = getWindow();
        WindowManager.LayoutParams params = window.getAttributes();
        params.gravity = Gravity.CENTER;
        params.alpha = 1.0f;
        params.width = ScreenUtil.getScreenWidth(mContext);
        window.setAttributes(params);

    }

    /**
     * 设置标题
     *
     * @param title
     */
    public void setTitle(String title) {
        mLlTitle.setVisibility(View.VISIBLE);//是否显示：温馨提醒！
        mTvTitle.setText(title);
//        mLlTitle.setBackgroundColor(mContext.getResources().getColor(R.color.red));
        mTvTitle.setBackgroundColor(mContext.getResources().getColor(R.color.colorPrimary));
    }

    /**
     * 设置内容
     *
     * @param message
     */
    public void setTvMessage(String message) {
        mTvMessage.setText(message);

    }

    /**
     * 设置确按钮文字
     *
     * @param sure
     */
    public void setBtnSure(String sure) {
        mBtnSure.setText(sure);
    }

    /**
     * 设置取消按钮文字
     *
     * @param cancle
     */
    public void setBtnCancel(String cancle) {
        mBtnCancel.setText(cancle);
    }

    /**
     * 设置取消按钮的文字
     *
     * @param visible
     */
    public void setBtnCancelVisible(int visible) {
        mBtnCancel.setVisibility(visible);
        if (visible == View.GONE) {
            mBtnSure.setBackgroundResource(R.drawable.selector_ontouch);
        } else {
            mBtnSure.setBackgroundResource(R.drawable.selector_bottom_right_corner);
        }
    }

    /**
     * 设置标题颜色
     *
     * @param color
     */
    public void setTitleColor(int color) {
        mTvTitle.setTextColor(color);

    }

    /**
     * 设置内容的颜色
     *
     * @param color
     */
    public void setMessageColor(int color) {
        mTvMessage.setTextColor(color);

    }

    /**
     * 确认按钮的颜色
     *
     * @param color
     */
    public void setbtnSureColor(int color) {
        mBtnSure.setTextColor(color);

    }

    /**
     * 设置取消按钮的颜色
     *
     * @param color
     */
    public void setBtnCancelColor(int color) {
        mBtnCancel.setTextColor(color);

    }

    /**
     * 设置自定义的view
     *
     * @param contentView
     */
    public void setCustomContentView(View contentView) {//不明白
        mLlContent.removeAllViews();
        mLlContent.addView(contentView);
    }

    /**
     * 设置确认是否有效
     *
     * @param enabled
     */
    public void setBtnSureEnable(boolean enabled) {
        mBtnSure.setEnabled(enabled);
        if (!enabled) {
            mBtnSure.setTextColor(mContext.getResources().getColor(
                    R.color.black));
        }
    }

    /**
     * 设置取消是否有效
     *
     * @param enabled
     */
    public void setBtnCancelEnable(boolean enabled) {
        mBtnCancel.setEnabled(enabled);
        if (!enabled) {
            mBtnCancel.setTextColor(mContext.getResources().getColor(
                    R.color.black));
        }
    }

}
