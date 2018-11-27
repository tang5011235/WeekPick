package com.example.tang5.weekpick;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.contrarywind.listener.OnItemSelectedListener;
import com.contrarywind.view.WheelView;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * @author：thf on 2018/8/1 0001 14:26
 * <p>
 * 邮箱：tang5011235@163.com
 * <p>
 * name:android
 * <p>
 * version:
 * @description:
 */
public class OwnWeekPickerViewOwn extends OwnBasePickerView implements View.OnClickListener {
	private WheelView mWvPeriodOfTime;
	private WheelView mWvWeek;
	private TextView mTvCancle;
	private TextView mTvSure;
	private TextView mTvDate;
	private int year;
	private int weekOfYear;

	public OwnWeekPickerViewOwn(OwnPickerOptions ownPickerOptions) {
		super(ownPickerOptions.context);
		mOwnPickerOptions = ownPickerOptions;
		initView(ownPickerOptions.context);
	}

	public OwnWeekPickerViewOwn(OwnPickerOptions ownPickerOptions, int year, int weekOfYear) {
		super(ownPickerOptions.context);
		mOwnPickerOptions = ownPickerOptions;
		this.year = year;
		this.weekOfYear = weekOfYear;
		initView(ownPickerOptions.context);
	}

	private void initView(Context context) {
		setDialogOutSideCancelable();
		initViews();
		initAnim();

		if (mOwnPickerOptions.customListener == null) {
			LayoutInflater.from(context).inflate(mOwnPickerOptions.layoutRes, contentContainer);

			mTvSure = (TextView) findViewById(R.id.tv_sure);
			mTvCancle = (TextView) findViewById(R.id.tv_cancel);
			mTvDate = (TextView) findViewById(R.id.tv_date);

			//设置颜色
			mTvSure.setTextColor(mOwnPickerOptions.textColorConfirm);
			mTvCancle.setTextColor(mOwnPickerOptions.textColorCancel);
			mTvDate.setTextColor(mOwnPickerOptions.textColorTitle);

			//设置大小
			mTvSure.setTextSize(mOwnPickerOptions.textSizeSubmitCancel);
			mTvCancle.setTextSize(mOwnPickerOptions.textSizeSubmitCancel);
			mTvDate.setTextSize(mOwnPickerOptions.textSizeTitle);

			mTvSure.setOnClickListener(this);
			mTvCancle.setOnClickListener(this);
		} else {
			mOwnPickerOptions.customListener.customLayout(LayoutInflater.from(context).inflate(mOwnPickerOptions.layoutRes, contentContainer));
		}
		LinearLayout timePickerView = (LinearLayout) findViewById(R.id.timepicker);
		timePickerView.setBackgroundColor(mOwnPickerOptions.bgColorWheel);
		initWheelTime(timePickerView);
	}

	private String currentDayOfWeekCn;
	private int currentDayOfWeekNum;
	private String currentAmOrPmCn;
	/**
	 * 0 为上午  1为下午
	 */
	private int currentAmOrPmNum;
	private String[] dates = new String[7];

	private void initWheelTime(LinearLayout timePickerView) {
		GregorianCalendar calendar1 = (GregorianCalendar) GregorianCalendar.getInstance();
		mWvWeek = (WheelView) findViewById(R.id.wv_week);
		mWvPeriodOfTime = (WheelView) findViewById(R.id.wv_period_of_time);

		mWvPeriodOfTime.setCyclic(false);
		mWvWeek.setCyclic(false);

		calendar1.setFirstDayOfWeek(Calendar.MONDAY);
		calendar1.setMinimalDaysInFirstWeek(7);
		calendar1.set(Calendar.YEAR, year);
		for (int i = 2; i <= 8; i++) {
			if (i == 8) {
				calendar1.set(Calendar.DAY_OF_WEEK, 1);
			} else {//星期天
				calendar1.set(Calendar.DAY_OF_WEEK, i);
			}
			calendar1.set(Calendar.WEEK_OF_YEAR, weekOfYear);
			weekDays[i - 2] = weekDays[i - 2] + "(" + (calendar1.get(Calendar.MONTH) + 1) + "-" + calendar1.get(Calendar.DAY_OF_MONTH) + ")";
		}
		DataWheelAdapter weekAdapter = new DataWheelAdapter(weekDays);
		DataWheelAdapter periodAdapter = new DataWheelAdapter(periodOfTime);
		mWvWeek.setAdapter(weekAdapter);
		mWvPeriodOfTime.setAdapter(periodAdapter);

		Calendar calendar = Calendar.getInstance();
		calendar.setMinimalDaysInFirstWeek(7);
		calendar.setFirstDayOfWeek(Calendar.MONDAY);
		calendar.getTimeInMillis();
		currentDayOfWeekNum = getDayOfWeekInChina(calendar);
		currentAmOrPmNum = calendar.get(Calendar.AM_PM);

		mWvWeek.setOnItemSelectedListener(new OnItemSelectedListener() {
			@Override
			public void onItemSelected(int index) {
				currentDayOfWeekCn = weekDays[index];
				currentDayOfWeekNum = index;
			}
		});

		mWvPeriodOfTime.setOnItemSelectedListener(new OnItemSelectedListener() {
			@Override
			public void onItemSelected(int index) {
				currentAmOrPmCn = periodOfTime[index];
				currentAmOrPmNum = index;
				mTvSure.setTag(currentAmOrPmCn);
			}
		});

		mWvWeek.setCurrentItem(currentDayOfWeekNum);
		mWvPeriodOfTime.setCurrentItem(currentAmOrPmNum);

		mTvDate.setText(String.format("第%s周", calendar1.get(Calendar.WEEK_OF_YEAR)));
	}


	private String[] weekDays = {"星期一", "星期二", "星期三", "星期四", "星期五", "星期六", "星期日"};
	private String[] periodOfTime = new String[]{"上午", "下午"};

	private Calendar selectCalendar = Calendar.getInstance();

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
			case R.id.tv_sure:
				if (mOwnPickerOptions.timeSelectListener != null) {
					selectCalendar.setFirstDayOfWeek(Calendar.MONDAY);
					selectCalendar.setMinimalDaysInFirstWeek(7);
					selectCalendar.set(Calendar.YEAR, year);
					selectCalendar.set(Calendar.DAY_OF_WEEK, getDayOfWeekInUs(currentDayOfWeekNum));
					selectCalendar.set(Calendar.WEEK_OF_YEAR, weekOfYear);
					selectCalendar.set(Calendar.AM_PM, currentAmOrPmNum);
					mOwnPickerOptions.timeSelectListener.onTimeSelect(selectCalendar.getTime(), v);
				}
				break;
			default:
				break;
		}
		dismiss();
	}

	private int getDayOfWeekInChina(Calendar calendar) {
		int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK) - 2;
		if (dayOfWeek == -1) {
			//当前为周日
			dayOfWeek = 6;
		}
		return dayOfWeek;
	}

	private int getDayOfWeekInUs(int day) {
		int dayOfWeek = day + 2;
		if (dayOfWeek == 8) {
			//当前为周日
			dayOfWeek = 1;
		}
		return dayOfWeek;
	}

	public void setWeekDay(int week, int period) {
		mWvWeek.setCurrentItem(week);
		currentDayOfWeekNum = week;
		if (period != -1) {
			mWvPeriodOfTime.setCurrentItem(period);
			currentAmOrPmNum = period;
		}
	}
}
