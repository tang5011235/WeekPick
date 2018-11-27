package com.example.tang5.weekpick;

import android.content.Context;
import android.view.ViewGroup;

import com.bigkoo.pickerview.listener.OnTimeSelectChangeListener;
import com.bigkoo.pickerview.listener.OnTimeSelectListener;
import com.contrarywind.view.WheelView;

import java.util.Calendar;

/**
 * @author：thf on 2018/8/1 0001 10:14
 * <p>
 * 邮箱：tang5011235@163.com
 * <p>
 * name:android
 * <p>
 * version:
 * @description:
 */
public class OwnWeekPickerViewBuilder {
	private OwnPickerOptions mOwnPickerOptions;
	private int year;
	private int weekOfYear;

	//Required
	public OwnWeekPickerViewBuilder(Context context, OnTimeSelectListener listener) {
		mOwnPickerOptions = new OwnPickerOptions(OwnPickerOptions.TYPE_PICKER_TIME);
		mOwnPickerOptions.context = context;
		mOwnPickerOptions.timeSelectListener = listener;
		mOwnPickerOptions.layoutRes = R.layout.view_week_picker;
	}

	//Option
	public OwnWeekPickerViewBuilder setGravity(int gravity) {
		mOwnPickerOptions.textGravity = gravity;
		return this;
	}

	public OwnWeekPickerViewBuilder setCancelText(String textContentCancel) {
		mOwnPickerOptions.textContentCancel = textContentCancel;
		return this;
	}

	public OwnWeekPickerViewBuilder setCancelColor(int textColorCancel) {
		mOwnPickerOptions.textColorCancel = textColorCancel;
		return this;
	}

	/**
	 * ViewGroup 类型的容器
	 *
	 * @param decorView 选择器会被添加到此容器中
	 * @return PeriodPickerViewBuilder
	 */
	public OwnWeekPickerViewBuilder setDecorView(ViewGroup decorView) {
		mOwnPickerOptions.decorView = decorView;
		return this;
	}

	public OwnWeekPickerViewBuilder setBgColor(int bgColorWheel) {
		mOwnPickerOptions.bgColorWheel = bgColorWheel;
		return this;
	}

	public OwnWeekPickerViewBuilder setSubCalSize(int textSizeSubmitCancel) {
		mOwnPickerOptions.textSizeSubmitCancel = textSizeSubmitCancel;
		return this;
	}

	public OwnWeekPickerViewBuilder setContentTextSize(int textSizeContent) {
		mOwnPickerOptions.textSizeContent = textSizeContent;
		return this;
	}

	/**
	 * 因为系统Calendar的月份是从0-11的,所以如果是调用Calendar的set方法来设置时间,月份的范围也要是从0-11
	 *
	 * @param date
	 * @return PeriodPickerViewBuilder
	 */
	public OwnWeekPickerViewBuilder setDate(Calendar date) {
		mOwnPickerOptions.date = date;
		return this;
	}


	/**
	 * 设置起始时间
	 * 因为系统Calendar的月份是从0-11的,所以如果是调用Calendar的set方法来设置时间,月份的范围也要是从0-11
	 */

	public OwnWeekPickerViewBuilder setRangDate(Calendar startDate, Calendar endDate) {
		mOwnPickerOptions.startDate = startDate;
		mOwnPickerOptions.endDate = endDate;
		return this;
	}


	/**
	 * 设置分割线的颜色
	 *
	 * @param dividerColor
	 */
	public OwnWeekPickerViewBuilder setDividerColor(int dividerColor) {
		mOwnPickerOptions.dividerColor = dividerColor;
		return this;
	}

	/**
	 * 设置分割线的类型
	 *
	 * @param dividerType
	 */
	public OwnWeekPickerViewBuilder setDividerType(WheelView.DividerType dividerType) {
		mOwnPickerOptions.dividerType = dividerType;
		return this;
	}

	/**
	 * //显示时的外部背景色颜色,默认是灰色
	 *
	 * @param backgroundId
	 */

	public OwnWeekPickerViewBuilder setBackgroundId(int backgroundId) {
		mOwnPickerOptions.backgroundId = backgroundId;
		return this;
	}

	/**
	 * 设置分割线之间的文字的颜色
	 *
	 * @param textColorCenter
	 */
	public OwnWeekPickerViewBuilder setTextColorCenter(int textColorCenter) {
		mOwnPickerOptions.textColorCenter = textColorCenter;
		return this;
	}

	/**
	 * 设置分割线以外文字的颜色
	 *
	 * @param textColorOut
	 */
	public OwnWeekPickerViewBuilder setTextColorOut(int textColorOut) {
		mOwnPickerOptions.textColorOut = textColorOut;
		return this;
	}

	public OwnWeekPickerViewBuilder isCyclic(boolean cyclic) {
		mOwnPickerOptions.cyclic = cyclic;
		return this;
	}

	public OwnWeekPickerViewBuilder setOutSideCancelable(boolean cancelable) {
		mOwnPickerOptions.cancelable = cancelable;
		return this;
	}

	/**
	 * @param listener 切换item项滚动停止时，实时回调监听。
	 * @return
	 */
	public OwnWeekPickerViewBuilder setTimeSelectChangeListener(OnTimeSelectChangeListener listener) {
		mOwnPickerOptions.timeSelectChangeListener = listener;
		return this;
	}

	public OwnWeekPickerViewBuilder setWeekOfYear(int weekOfYear) {
		this.weekOfYear = weekOfYear;
		return this;
	}

	public OwnWeekPickerViewBuilder setYear(int year) {
		this.year = year;
		return this;
	}

	public OwnWeekPickerViewOwn build() {
		return new OwnWeekPickerViewOwn(mOwnPickerOptions,year,weekOfYear);
	}
}
