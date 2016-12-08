package com.example.administrator.catemenu.modle;

import java.util.List;

/**
 * Created by abc on 2016/11/27.
 */
public class TodayRecommendItem {

    /**
     * status : 1
     * message : 获取成功
     * result : [{"id":"1","name":"糖醋排骨","imageurl_small":null,"imageurl_big":null,"introduce":null,"ingredientid":"1","stepsid":null,"functionid":null,"commentsid":null,"food_classificationid":null,"regional_snacksid":null,"userid":null,"praiseid":null,"collectionid":null,"recommendation_detailsid":"1","lengthid":null,"difficultyid":null,"amount":"haoping"}]
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
         * id : 1
         * name : 糖醋排骨
         * imageurl_small : null
         * imageurl_big : null
         * introduce : null
         * ingredientid : 1
         * stepsid : null
         * functionid : null
         * commentsid : null
         * food_classificationid : null
         * regional_snacksid : null
         * userid : null
         * praiseid : null
         * collectionid : null
         * recommendation_detailsid : 1
         * lengthid : null
         * difficultyid : null
         * amount : haoping
         */

        private String id;
        private String name;
        private Object imageurl_small;
        private Object imageurl_big;
        private Object introduce;
        private String ingredientid;
        private Object stepsid;
        private Object functionid;
        private Object commentsid;
        private Object food_classificationid;
        private Object regional_snacksid;
        private Object userid;
        private Object praiseid;
        private Object collectionid;
        private String recommendation_detailsid;
        private Object lengthid;
        private Object difficultyid;
        private String amount;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Object getImageurl_small() {
            return imageurl_small;
        }

        public void setImageurl_small(Object imageurl_small) {
            this.imageurl_small = imageurl_small;
        }

        public Object getImageurl_big() {
            return imageurl_big;
        }

        public void setImageurl_big(Object imageurl_big) {
            this.imageurl_big = imageurl_big;
        }

        public Object getIntroduce() {
            return introduce;
        }

        public void setIntroduce(Object introduce) {
            this.introduce = introduce;
        }

        public String getIngredientid() {
            return ingredientid;
        }

        public void setIngredientid(String ingredientid) {
            this.ingredientid = ingredientid;
        }

        public Object getStepsid() {
            return stepsid;
        }

        public void setStepsid(Object stepsid) {
            this.stepsid = stepsid;
        }

        public Object getFunctionid() {
            return functionid;
        }

        public void setFunctionid(Object functionid) {
            this.functionid = functionid;
        }

        public Object getCommentsid() {
            return commentsid;
        }

        public void setCommentsid(Object commentsid) {
            this.commentsid = commentsid;
        }

        public Object getFood_classificationid() {
            return food_classificationid;
        }

        public void setFood_classificationid(Object food_classificationid) {
            this.food_classificationid = food_classificationid;
        }

        public Object getRegional_snacksid() {
            return regional_snacksid;
        }

        public void setRegional_snacksid(Object regional_snacksid) {
            this.regional_snacksid = regional_snacksid;
        }

        public Object getUserid() {
            return userid;
        }

        public void setUserid(Object userid) {
            this.userid = userid;
        }

        public Object getPraiseid() {
            return praiseid;
        }

        public void setPraiseid(Object praiseid) {
            this.praiseid = praiseid;
        }

        public Object getCollectionid() {
            return collectionid;
        }

        public void setCollectionid(Object collectionid) {
            this.collectionid = collectionid;
        }

        public String getRecommendation_detailsid() {
            return recommendation_detailsid;
        }

        public void setRecommendation_detailsid(String recommendation_detailsid) {
            this.recommendation_detailsid = recommendation_detailsid;
        }

        public Object getLengthid() {
            return lengthid;
        }

        public void setLengthid(Object lengthid) {
            this.lengthid = lengthid;
        }

        public Object getDifficultyid() {
            return difficultyid;
        }

        public void setDifficultyid(Object difficultyid) {
            this.difficultyid = difficultyid;
        }

        public String getAmount() {
            return amount;
        }

        public void setAmount(String amount) {
            this.amount = amount;
        }
    }
}
