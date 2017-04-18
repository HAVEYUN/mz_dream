package zzy.mz_dream.pickerviewdemo.bean;

import com.bigkoo.pickerview.model.IPickerViewData;

/**
 * Author: mz_dream  PC:MZ
 * Time: 2017/4/17 17:20
 * Email: 826680069@qq.com
 * Instruction: 功能
 */
public class CardBean implements IPickerViewData {
    int id;

    String cardNo;

    public CardBean(int id, String cardNo) {
        this.id = id;
        this.cardNo = cardNo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    @Override
    public String getPickerViewText() {
        return cardNo;
    }
}
