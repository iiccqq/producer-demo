package com.demo.producer;

/**
 * 消费者类
 * @author 徐景洋
 */
public class Customer implements Runnable {

    private GoodsStore store;

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
                if(store.getIndex() <5){
                    try {//如果商品生产的数量小于0,则开始等待.只有有货才能购物嘛
                        store.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                String []goods = store.getGoods();
                for(int j=0;j<5;j++)
                System.out.println("取走了"  +  goods[j]);
                store.setIndex(0);
                store.notify();//取走之后通知生产商继续生产商品(唤醒在对象锁等待池中的线程继续执行)
            }
        }
    }

}