package com.example.administrator.catemenu.modle;

import java.util.List;

/**
 * Created by Administrator on 2016/12/8.
 */
public class FoodDinner {

    /**
     * status : 1
     * message : 获取成功
     * result : [{"foodname":"晚餐","recommendedname":"今日推荐","name":"姜爆鸭子","id":"2"},{"foodname":"晚餐","recommendedname":"今日推荐","name":"糖醋排骨","id":"3"},{"foodname":"晚餐","recommendedname":"今日推荐","name":"回锅肉","id":"4"}]
     */

    private int status;
    private String message;
    private List<ResultBean> result;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<ResultBean> getResult() {
        return result;
    }

    public void setResult(List<ResultBean> result) {
        this.result = result;
    }

    public static class ResultBean {
        /**
         * foodname : 晚餐
         * recommendedname : 今日推荐
         * name : 姜爆鸭子
         * id : 2
         */

        private String foodname;
        private String recommendedname;
        private String name;
        private String id;

        public String getFoodname() {
            return foodname;
        }

        public void setFoodname(String foodname) {
            this.foodname = foodname;
        }

        public String getRecommendedname() {
            return recommendedname;
        }

        public void setRecommendedname(String recommendedname) {
            this.recommendedname = recommendedname;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }
    }
}
