package com.example.tang5.weekpick;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.google.gson.Gson;
import com.jakewharton.rxbinding.view.RxView;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;

public class MainActivity extends AppCompatActivity {

    private OwnWeekPickerViewOwn mBuild;
    private List<String> mOptions1Items;
    private List<List<String>> mOptions2Items;
    private List<List<List<String>>> mOptions3Items;
    private List<List<List<List<String>>>> mOptions4Items;
    private OwnOptionsPickerViewOwn mPvOptions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*mBuild = new OwnWeekPickerViewBuilder(this, new OnTimeSelectListener() {
            @Override
            public void onTimeSelect(Date date, View v) {

            }
        })
                .build();*/

        //返回的分别是三个级别的选中位置
/* String tx = options1Items.get(options1).getPickerViewText()
         + options2Items.get(options1).get(option2)
         + options3Items.get(options1).get(option2).get(options3).getPickerViewText();
 tvOptions.setText(tx);*/
        mPvOptions = new OwnOptionsPickerBuilder(MainActivity.this, new OwnOnOptionsSelectListener() {
            @Override
            public void onOptionsSelect(int options1, int options2, int options3, int options4, View v) {
                //返回的分别是三个级别的选中位置
               /* String tx = options1Items.get(options1).getPickerViewText()
                        + options2Items.get(options1).get(option2)
                        + options3Items.get(options1).get(option2).get(options3).getPickerViewText();
                tvOptions.setText(tx);*/
                String s;
                if (options2 == -1) {
                    s = mOptions1Items.get(options1);
                } else if (options3 == -1) {
                    s = mOptions1Items.get(options1) +
                            mOptions2Items.get(options1).get(options2);
                } else if (options4 == -1) {
                    s = mOptions1Items.get(options1) +
                            mOptions2Items.get(options1).get(options2) +
                            mOptions3Items.get(options1).get(options2).get(options3);
                } else {
                    s = mOptions1Items.get(options1) +
                            mOptions2Items.get(options1).get(options2) +
                            mOptions3Items.get(options1).get(options2).get(options3) +
                            mOptions4Items.get(options1).get(options2).get(options3).get(options4);
                }
                Toast.makeText(MainActivity.this, s, Toast.LENGTH_SHORT).show();
            }
        })
                .setOptionsSelectChangeListener(new OwnOnOptionsSelectChangeListener() {
                    @Override
                    public void onOptionsSelectChanged(int options1, int options2, int options3, int options4) {
                        Log.e("setOptionr", "onOptionsSelectChanged: " + options1 + " " + options2 + " " + options3 + " " + options4);

                        if (options1 <= mOptions1Items.size() - 1) {
                            if (options2 <= mOptions2Items.get(options1).size() - 1) {
                                if (options3 <= mOptions3Items.get(options1).get(options2).size() - 1) {
                                    if (options4 <= mOptions4Items.get(options1).get(options2).get(options3).size() - 1) {
                                        mPvOptions.setTitleText(mOptions1Items.get(options1) +
                                                mOptions2Items.get(options1).get(options2) +
                                                mOptions3Items.get(options1).get(options2).get(options3) +
                                                mOptions4Items.get(options1).get(options2).get(options3).get(options4));
                                    }
                                }
                            }
                        }
                    }
                }).build();
        mOptions4Items = new ArrayList<>();

        mOptions1Items = new ArrayList<>();
        mOptions2Items = new ArrayList<>();
        mOptions3Items = new ArrayList<>();
        /*for (int i = 0; i < 10; i++) {
            List<String> seconedstrings = new ArrayList<>();
            List<List<String>> thirdString = new ArrayList<>();
            List<List<List<String>>> fourtyString = new ArrayList<>();
            for (int j = 0; j < 9; j++) {
                List<List<String>> s4 = new ArrayList<>();
                List<String> strings = new ArrayList<>();
                for (int k = 0; k < 8; k++) {
                    List<String> st1 = new ArrayList<>();
                    List<String> st2 = new ArrayList<>();
                    strings.add(String.valueOf(k));
                    for (int l = 0; l < 5; l++) {
                        if (l % 2 == 0) {
                            st1.add(String.valueOf(l));
                        } else {
                            st2.add(String.valueOf(l));
                        }
                    }
                    if (k % 2 == 0) {
                        s4.add(st1);
                    } else {
                        s4.add(st2);
                    }

                }
                seconedstrings.add(String.valueOf(j));
                thirdString.add(strings);
                fourtyString.add(s4);
            }
            options1Items.add(String.valueOf(i));
            options2Items.add(seconedstrings);
            options3Items.add(thirdString);
            options4Items.add(fourtyString);
        }*/
        //条件选择器

        RxView.clicks(findViewById(R.id.tv_date))
                .throttleLast(1, TimeUnit.SECONDS)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<Void>() {
                    @Override
                    public void call(Void aVoid) {
                        OkGo.<String>get("https://easy-mock.com/mock/5b334ed8b3c5711bec1ff397/sasa/city")
                                .execute(new StringCallback() {
                                    @Override
                                    public void onSuccess(Response<String> response) {
                                        Gson gson = new Gson();
                                        BaseDataBean baseDataBean = gson.fromJson(response.body(), BaseDataBean.class);

                                        for (BaseDataBean.DataBean dataBean : baseDataBean.getData()) {
                                            List<String> cityLists = new ArrayList<>();//城市名字
                                            List<List<String>> sanji = new ArrayList<>();
                                            List<List<List<String>>> siji = new ArrayList<>();
                                            if (dataBean.getCity() != null) {
                                                for (BaseDataBean.DataBean.CityBean cityBean : dataBean.getCity()) {
                                                    cityLists.add(cityBean.getName());

                                                    List<String> areaLists = new ArrayList<>();//地区名字
                                                    List<List<String>> lists = new ArrayList<>();
                                                    if (cityBean.getArea() != null) {
                                                        for (BaseDataBean.DataBean.CityBean.AreaBean areaBean : cityBean.getArea()) {
                                                            areaLists.add(areaBean.getName());
                                                            List<String> townLists = new ArrayList<>();//城镇名字
                                                            if (areaBean.getTown() != null) {
                                                                for (String townName : areaBean.getTown()) {
                                                                    townLists.add(townName);
                                                                }
                                                            }
                                                            lists.add(townLists);
                                                        }
                                                    }
                                                    sanji.add(areaLists);
                                                    siji.add(lists);
                                                }
                                            }

                                            mOptions2Items.add(cityLists);
                                            mOptions1Items.add(dataBean.getName());
                                            mOptions3Items.add(sanji);
                                            mOptions4Items.add(siji);
                                        }

                                        mPvOptions.setPicker(mOptions1Items, mOptions2Items, mOptions3Items, mOptions4Items);
                                        mPvOptions.show();
                                    }
                                });
                    }
                });
    }
}
