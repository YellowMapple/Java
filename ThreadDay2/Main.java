package ThreadDay2;

public class Main {
    public static void main(String[] args) {
        //创建五个线程
        MyThread t1 = new MyThread();
        MyThread t2 = new MyThread();
        MyThread t3 = new MyThread();
        MyThread t4 = new MyThread();
        MyThread t5 = new MyThread();

        //起名字
        t1.setName("小明");
        t2.setName("小红");
        t3.setName("小丁");
        t4.setName("小强");
        t5.setName("小王");

        //启动！
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
    }
}
