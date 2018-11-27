package com.example.tang5.weekpick;


import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.List;

/**
 * 条件选择器
 * Created by Sai on 15/11/22.
 */
public class OwnOptionsPickerViewOwn<T> extends OwnBasePickerView implements View.OnClickListener {

    private OwnWheelOptions mOwnWheelOptions;

    private static final String TAG_SUBMIT = "submit";
    private static final String TAG_CANCEL = "cancel";


    public OwnOptionsPickerViewOwn(OwnPickerOptions ownPickerOptions) {
        super(ownPickerOptions.context);
        mOwnPickerOptions = ownPickerOptions;
        initView(ownPickerOptions.context);
    }

    private void initView(Context context) {
        setDialogOutSideCancelable();
        initViews();
        initAnim();
        initEvents();
        if (mOwnPickerOptions.customListener == null) {
            LayoutInflater.from(context).inflate(mOwnPickerOptions.layoutRes, contentContainer);

            //顶部标题
            TextView tvTitle = (TextView) findViewById(R.id.tvTitle);
            RelativeLayout rv_top_bar = (RelativeLayout) findViewById(R.id.rv_topbar);

            //确定和取消按钮
            Button btnSubmit = (Button) findViewById(R.id.btnSubmit);
            Button btnCancel = (Button) findViewById(R.id.btnCancel);

            btnSubmit.setTag(TAG_SUBMIT);
            btnCancel.setTag(TAG_CANCEL);
            btnSubmit.setOnClickListener(this);
            btnCancel.setOnClickListener(this);

            //设置文字
            btnSubmit.setText(TextUtils.isEmpty(mOwnPickerOptions.textContentConfirm) ? context.getResources().getString(R.string.pickerview_submit) : mOwnPickerOptions.textContentConfirm);
            btnCancel.setText(TextUtils.isEmpty(mOwnPickerOptions.textContentCancel) ? context.getResources().getString(R.string.pickerview_cancel) : mOwnPickerOptions.textContentCancel);
            tvTitle.setText(TextUtils.isEmpty(mOwnPickerOptions.textContentTitle) ? "" : mOwnPickerOptions.textContentTitle);//默认为空

            //设置color
            btnSubmit.setTextColor(mOwnPickerOptions.textColorConfirm);
            btnCancel.setTextColor(mOwnPickerOptions.textColorCancel);
            tvTitle.setTextColor(mOwnPickerOptions.textColorTitle);
            rv_top_bar.setBackgroundColor(mOwnPickerOptions.bgColorTitle);

            //设置文字大小
            btnSubmit.setTextSize(mOwnPickerOptions.textSizeSubmitCancel);
            btnCancel.setTextSize(mOwnPickerOptions.textSizeSubmitCancel);
            tvTitle.setTextSize(mOwnPickerOptions.textSizeTitle);
        } else {
            mOwnPickerOptions.customListener.customLayout(LayoutInflater.from(context).inflate(mOwnPickerOptions.layoutRes, contentContainer));
        }

        // ----滚轮布局
        final LinearLayout optionsPicker = (LinearLayout) findViewById(R.id.optionspicker);
        optionsPicker.setBackgroundColor(mOwnPickerOptions.bgColorWheel);

        mOwnWheelOptions = new OwnWheelOptions(optionsPicker, mOwnPickerOptions.isRestoreItem);
        if (mOwnPickerOptions.optionsSelectChangeListener != null) {
            mOwnWheelOptions.setOptionsSelectChangeListener(mOwnPickerOptions.optionsSelectChangeListener);
        }

        mOwnWheelOptions.setTextContentSize(mOwnPickerOptions.textSizeContent);
        mOwnWheelOptions.setLabels(mOwnPickerOptions.label1, mOwnPickerOptions.label2, mOwnPickerOptions.label3, mOwnPickerOptions.label4);
        mOwnWheelOptions.setTextXOffset(mOwnPickerOptions.x_offset_one, mOwnPickerOptions.x_offset_two, mOwnPickerOptions.x_offset_three, mOwnPickerOptions.x_offset_four);
        mOwnWheelOptions.setCyclic(mOwnPickerOptions.cyclic1, mOwnPickerOptions.cyclic2, mOwnPickerOptions.cyclic3, mOwnPickerOptions.cyclic4);
        mOwnWheelOptions.setTypeface(mOwnPickerOptions.font);

        setOutSideCancelable(mOwnPickerOptions.cancelable);

        mOwnWheelOptions.setDividerColor(mOwnPickerOptions.dividerColor);
        mOwnWheelOptions.setDividerType(mOwnPickerOptions.dividerType);
        mOwnWheelOptions.setLineSpacingMultiplier(mOwnPickerOptions.lineSpacingMultiplier);
        mOwnWheelOptions.setTextColorOut(mOwnPickerOptions.textColorOut);
        mOwnWheelOptions.setTextColorCenter(mOwnPickerOptions.textColorCenter);
        mOwnWheelOptions.isCenterLabel(mOwnPickerOptions.isCenterLabel);
    }

    /**
     * 动态设置标题
     *
     * @param text 标题文本内容
     */
    public void setTitleText(String text) {
        TextView tvTitle = (TextView) findViewById(R.id.tvTitle);
        if (tvTitle != null) {
            tvTitle.setText(text);
        }
    }

    /**
     * 设置默认选中项
     *
     * @param option1
     */
    public void setSelectOptions(int option1) {
        mOwnPickerOptions.option1 = option1;
        reSetCurrentItems();
    }


    public void setSelectOptions(int option1, int option2) {
        mOwnPickerOptions.option1 = option1;
        mOwnPickerOptions.option2 = option2;
        reSetCurrentItems();
    }

    public void setSelectOptions(int option1, int option2, int option3) {
        mOwnPickerOptions.option1 = option1;
        mOwnPickerOptions.option2 = option2;
        mOwnPickerOptions.option3 = option3;
        reSetCurrentItems();
    }

    private void reSetCurrentItems() {
        if (mOwnWheelOptions != null) {
            mOwnWheelOptions.setCurrentItems(mOwnPickerOptions.option1, mOwnPickerOptions.option2, mOwnPickerOptions.option3, mOwnPickerOptions.option4);
        }
    }

    public void setPicker(List<T> optionsItems) {
        this.setPicker(optionsItems, null, null);
    }

    public void setPicker(List<T> options1Items, List<List<T>> options2Items) {
        this.setPicker(options1Items, options2Items, null);
    }

    public void setPicker(List<T> options1Items,
                          List<List<T>> options2Items,
                          List<List<List<T>>> options3Items) {

        mOwnWheelOptions.setPicker(options1Items, options2Items, options3Items, null);
        reSetCurrentItems();
    }

    public void setPicker(List<T> options1Items,
                          List<List<T>> options2Items,
                          List<List<List<T>>> options3Items,
                          List<List<List<List<T>>>> options4Items) {

        mOwnWheelOptions.setPicker(options1Items, options2Items, options3Items, options4Items);
        reSetCurrentItems();
    }


    //不联动情况下调用
    public void setNPicker(List<T> options1Items,
                           List<T> options2Items,
                           List<T> options3Items,
                           List<T> options4Items) {

        mOwnWheelOptions.setLinkage(false);
        mOwnWheelOptions.setNPicker(options1Items, options2Items, options3Items, options4Items);
        reSetCurrentItems();
    }

    @Override
    public void onClick(View v) {
        String tag = (String) v.getTag();
        if (tag.equals(TAG_SUBMIT)) {
            returnData();
        }
        dismiss();
    }

    //抽离接口回调的方法
    public void returnData() {
        if (mOwnPickerOptions.optionsSelectListener != null) {
            int[] optionsCurrentItems = mOwnWheelOptions.getCurrentItems();
            mOwnPickerOptions.optionsSelectListener.onOptionsSelect(optionsCurrentItems[0], optionsCurrentItems[1], optionsCurrentItems[2],optionsCurrentItems[3], clickView);
        }
    }


    @Override
    public boolean isDialog() {
        return mOwnPickerOptions.isDialog;
    }
}
