package com.example.tang5.weekpick;

import android.content.Context;
import android.graphics.Typeface;
import android.view.ViewGroup;

import com.bigkoo.pickerview.listener.CustomListener;
import com.contrarywind.view.WheelView;

/**
 * Created by xiaosongzeem on 2018/3/20.
 */

public class OwnOptionsPickerBuilder {

    //配置类
    private OwnPickerOptions mOwnPickerOptions;


    //Required
    public OwnOptionsPickerBuilder(Context context, OwnOnOptionsSelectListener listener) {
        mOwnPickerOptions = new OwnPickerOptions(OwnPickerOptions.TYPE_PICKER_OPTIONS);
        mOwnPickerOptions.context = context;
        mOwnPickerOptions.optionsSelectListener = listener;
    }

    //Option
    public OwnOptionsPickerBuilder setSubmitText(String textContentConfirm) {
        mOwnPickerOptions.textContentConfirm = textContentConfirm;
        return this;
    }

    public OwnOptionsPickerBuilder setCancelText(String textContentCancel) {
        mOwnPickerOptions.textContentCancel = textContentCancel;
        return this;
    }

    public OwnOptionsPickerBuilder setTitleText(String textContentTitle) {
        mOwnPickerOptions.textContentTitle = textContentTitle;
        return this;
    }

    public OwnOptionsPickerBuilder isDialog(boolean isDialog) {
        mOwnPickerOptions.isDialog = isDialog;
        return this;
    }

    public OwnOptionsPickerBuilder setSubmitColor(int textColorConfirm) {
        mOwnPickerOptions.textColorConfirm = textColorConfirm;
        return this;
    }

    public OwnOptionsPickerBuilder setCancelColor(int textColorCancel) {
        mOwnPickerOptions.textColorCancel = textColorCancel;
        return this;
    }

    /**
     * 显示时的外部背景色颜色,默认是灰色
     *
     * @param backgroundId color resId.
     * @return
     */
    public OwnOptionsPickerBuilder setBackgroundId(int backgroundId) {
        mOwnPickerOptions.backgroundId = backgroundId;
        return this;
    }

    /**
     * ViewGroup 类型
     * 设置PickerView的显示容器
     *
     * @param decorView Parent View.
     * @return
     */
    public OwnOptionsPickerBuilder setDecorView(ViewGroup decorView) {
        mOwnPickerOptions.decorView = decorView;
        return this;
    }

    public OwnOptionsPickerBuilder setLayoutRes(int res, CustomListener listener) {
        mOwnPickerOptions.layoutRes = res;
        mOwnPickerOptions.customListener = listener;
        return this;
    }

    public OwnOptionsPickerBuilder setBgColor(int bgColorWheel) {
        mOwnPickerOptions.bgColorWheel = bgColorWheel;
        return this;
    }

    public OwnOptionsPickerBuilder setTitleBgColor(int bgColorTitle) {
        mOwnPickerOptions.bgColorTitle = bgColorTitle;
        return this;
    }

    public OwnOptionsPickerBuilder setTitleColor(int textColorTitle) {
        mOwnPickerOptions.textColorTitle = textColorTitle;
        return this;
    }

    public OwnOptionsPickerBuilder setSubCalSize(int textSizeSubmitCancel) {
        mOwnPickerOptions.textSizeSubmitCancel = textSizeSubmitCancel;
        return this;
    }

    public OwnOptionsPickerBuilder setTitleSize(int textSizeTitle) {
        mOwnPickerOptions.textSizeTitle = textSizeTitle;
        return this;
    }

    public OwnOptionsPickerBuilder setContentTextSize(int textSizeContent) {
        mOwnPickerOptions.textSizeContent = textSizeContent;
        return this;
    }

    public OwnOptionsPickerBuilder setOutSideCancelable(boolean cancelable) {
        mOwnPickerOptions.cancelable = cancelable;
        return this;
    }


    public OwnOptionsPickerBuilder setLabels(String label1, String label2, String label3, String label4) {
        mOwnPickerOptions.label1 = label1;
        mOwnPickerOptions.label2 = label2;
        mOwnPickerOptions.label3 = label3;
        mOwnPickerOptions.label4 = label4;
        return this;
    }

    /**
     * 设置Item 的间距倍数，用于控制 Item 高度间隔
     *
     * @param lineSpacingMultiplier 浮点型，1.0-4.0f 之间有效,超过则取极值。
     */
    public OwnOptionsPickerBuilder setLineSpacingMultiplier(float lineSpacingMultiplier) {
        mOwnPickerOptions.lineSpacingMultiplier = lineSpacingMultiplier;
        return this;
    }

    /**
     * Set item divider line type color.
     *
     * @param dividerColor color resId.
     */
    public OwnOptionsPickerBuilder setDividerColor(int dividerColor) {
        mOwnPickerOptions.dividerColor = dividerColor;
        return this;
    }

    /**
     * Set item divider line type.
     *
     * @param dividerType enum Type {@link WheelView.DividerType}
     */
    public OwnOptionsPickerBuilder setDividerType(WheelView.DividerType dividerType) {
        mOwnPickerOptions.dividerType = dividerType;
        return this;
    }

    /**
     * Set the textColor of selected item.
     *
     * @param textColorCenter color res.
     */
    public OwnOptionsPickerBuilder setTextColorCenter(int textColorCenter) {
        mOwnPickerOptions.textColorCenter = textColorCenter;
        return this;
    }

    /**
     * Set the textColor of outside item.
     *
     * @param textColorOut color resId.
     */
    public OwnOptionsPickerBuilder setTextColorOut(int textColorOut) {
        mOwnPickerOptions.textColorOut = textColorOut;
        return this;
    }

    public OwnOptionsPickerBuilder setTypeface(Typeface font) {
        mOwnPickerOptions.font = font;
        return this;
    }

    public OwnOptionsPickerBuilder setCyclic(boolean cyclic1, boolean cyclic2, boolean cyclic3, boolean cyclic4) {
        mOwnPickerOptions.cyclic1 = cyclic1;
        mOwnPickerOptions.cyclic2 = cyclic2;
        mOwnPickerOptions.cyclic3 = cyclic3;
        mOwnPickerOptions.cyclic4 = cyclic4;
        return this;
    }

    public OwnOptionsPickerBuilder setSelectOptions(int option1) {
        mOwnPickerOptions.option1 = option1;
        return this;
    }

    public OwnOptionsPickerBuilder setSelectOptions(int option1, int option2) {
        mOwnPickerOptions.option1 = option1;
        mOwnPickerOptions.option2 = option2;
        return this;
    }

    public OwnOptionsPickerBuilder setSelectOptions(int option1, int option2, int option3) {
        mOwnPickerOptions.option1 = option1;
        mOwnPickerOptions.option2 = option2;
        mOwnPickerOptions.option3 = option3;
        return this;
    }

    public OwnOptionsPickerBuilder setSelectOptions(int option1, int option2, int option3, int option4) {
        mOwnPickerOptions.option1 = option1;
        mOwnPickerOptions.option2 = option2;
        mOwnPickerOptions.option3 = option3;
        mOwnPickerOptions.option4 = option4;
        return this;
    }

    public OwnOptionsPickerBuilder setTextXOffset(int xoffset_one, int xoffset_two, int xoffset_three, int xoffset_four) {
        mOwnPickerOptions.x_offset_one = xoffset_one;
        mOwnPickerOptions.x_offset_two = xoffset_two;
        mOwnPickerOptions.x_offset_three = xoffset_three;
        mOwnPickerOptions.x_offset_four = xoffset_four;
        return this;
    }

    public OwnOptionsPickerBuilder isCenterLabel(boolean isCenterLabel) {
        mOwnPickerOptions.isCenterLabel = isCenterLabel;
        return this;
    }

    /**
     * 切换选项时，是否还原第一项
     *
     * @param isRestoreItem true：还原； false: 保持上一个选项
     * @return TimePickerBuilder
     */
    public OwnOptionsPickerBuilder isRestoreItem(boolean isRestoreItem) {
        mOwnPickerOptions.isRestoreItem = isRestoreItem;
        return this;
    }

    /**
     * @param listener 切换item项滚动停止时，实时回调监听。
     * @return
     */
    public OwnOptionsPickerBuilder setOptionsSelectChangeListener(OwnOnOptionsSelectChangeListener listener) {
        mOwnPickerOptions.optionsSelectChangeListener = listener;
        return this;
    }


    public <T> OwnOptionsPickerViewOwn<T> build() {
        return new OwnOptionsPickerViewOwn<>(mOwnPickerOptions);
    }
}
