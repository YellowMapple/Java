package threadDay1;

public class Foodie extends Thread{
    @Override
    public void run() {
        while (true) {
            synchronized (Desk.lock) {
                if (Desk.count == 0) {
                    break;
                } else {
                    //判断桌上是否有面条
                    if (Desk.foodFlag == 0) {
                        try {
                            Desk.lock.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    } else {
                        //吃
                        Desk.count --;
                        System.out.println("吃货正在吃第"+ Desk.count +"碗面");
                        Desk.lock.notifyAll();
                        Desk.foodFlag = 0;
                    }

                }
            }

        }
    }
}
