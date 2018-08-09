package com.demo.producer;

/**
 * 商品类
 * @author 徐景洋
 */
public class GoodsStore {
    private String[] goods = new String[5];
    private Integer max = 5;
    private Integer index = 0;
    public Integer getMax() {
        return max;
    }

    public void setMax(Integer max) {
        this.max = max;
    }


    public String[] getGoods() {
        return goods;
    }

    public void setGoods(String[] goods) {
        this.goods = goods;
    }

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }
}