package com.demo.producer;

/**
 * 生产商类
 * @author 徐景洋
 */
public class Producer implements Runnable {

    public GoodsStore store;

    public GoodsStore getStore() {
        return store;
    }

    public void setStore(GoodsStore store) {
        this.store = store;
    }

    @Override
    public void run() {
        for (int i = 0; i < 50; i++) {
            synchronized (store) {
                if(store.getIndex() == store.getMax()){
                    try {
                        store.wait();//商品数量已经大于0啦,消费者要取货咯,自己就开始等待咯
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                  String good = "goodname" + i;
                store.getGoods()[store.getIndex()]=good;
                System.out.println("生产了" + good + ",index=" + store.getIndex());
                store.setIndex(store.getIndex() + 1);
                store.notify();//商品不够啦,自己生产完,然后通知消费者取货咯
            }
        }
    }

}