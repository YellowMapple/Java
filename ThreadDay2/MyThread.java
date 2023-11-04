package ThreadDay2;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Random;

public class MyThread extends Thread {
    static BigDecimal money = BigDecimal.valueOf(100);
    static int count = 3;
    //最小的中奖金额
    static final BigDecimal MIN = BigDecimal.valueOf(0.01);

    @Override
    public void run() {
        synchronized (MyThread.class) {
            if (count == 0) {
                System.out.println("没有抢到红包");
            } else {
                BigDecimal price;
                if (count == 1) { //此时为最后一次不用随机
                    price = money;
                } else {
                    Random r = new Random();
                    double limit = money.subtract(BigDecimal.valueOf(count - 1).multiply(MIN)).doubleValue();
                    price = BigDecimal.valueOf(r.nextDouble(limit));

                }
                price = price.setScale(2, RoundingMode.HALF_UP);
                money = money.subtract(price);
                count--;
                System.out.println(getName() + "本次抢到了" + price + "元");
            }
        }
    }
}
