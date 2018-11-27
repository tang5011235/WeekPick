package com.example.tang5.weekpick;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class BaseDataBean {

    @SerializedName("data")
    private List<DataBean> data;

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * name : 北京市
         * city : [{"name":"北京市","area":[{"name":"东城区","town":["东华门街道","景山街道","交道口街道","永定门街道","建国门街道"]},{"name":"西城区","town":[]},{"name":"崇文区","town":["前门街道","崇文门外街道","龙潭街道","体育馆路街道","天坛街道","永定门外街道"]},{"name":"宣武区","town":["前门街道","崇文门外街道","龙潭街道","体育馆路街道","天坛街道","永定门外街道"]},{"name":"朝阳区","town":[]},{"name":"丰台区","town":[]}]}]
         */

        @SerializedName("name")
        private String name;
        @SerializedName("city")
        private List<CityBean> city;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public List<CityBean> getCity() {
            return city;
        }

        public void setCity(List<CityBean> city) {
            this.city = city;
        }

        public static class CityBean {
            /**
             * name : 北京市
             * area : [{"name":"东城区","town":["东华门街道","景山街道","交道口街道","永定门街道","建国门街道"]},{"name":"西城区","town":[]},{"name":"崇文区","town":["前门街道","崇文门外街道","龙潭街道","体育馆路街道","天坛街道","永定门外街道"]},{"name":"宣武区","town":["前门街道","崇文门外街道","龙潭街道","体育馆路街道","天坛街道","永定门外街道"]},{"name":"朝阳区","town":[]},{"name":"丰台区","town":[]}]
             */

            @SerializedName("name")
            private String name;
            @SerializedName("area")
            private List<AreaBean> area;

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public List<AreaBean> getArea() {
                return area;
            }

            public void setArea(List<AreaBean> area) {
                this.area = area;
            }

            public static class AreaBean {
                /**
                 * name : 东城区
                 * town : ["东华门街道","景山街道","交道口街道","永定门街道","建国门街道"]
                 */

                @SerializedName("name")
                private String name;
                @SerializedName("town")
                private List<String> town;

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public List<String> getTown() {
                    return town;
                }

                public void setTown(List<String> town) {
                    this.town = town;
                }
            }
        }
    }
}
