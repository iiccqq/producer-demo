package com.demo.producer;

public class Main {

    public static void main(String[] args) {
        GoodsStore store = new GoodsStore();

        //生产者生产商品
        Producer p=new Producer();
        p.setStore(store);

        //消费者取走商品
        Customer c=new Customer();
        c.setStore(store);

        new Thread(p).start();
        new Thread(c).start();
    }
}
