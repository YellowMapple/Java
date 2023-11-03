# Java
```ruby
package threadDay1;

public class MyRunnable implements Runnable {
    int ticket = 0;

    public MyRunnable() {
    }

    @Override
    public void run() {
        while (true) {
            if (method()) break;
        }
    }

    private synchronized boolean method() {
        synchronized (MyRunnable.class) {
            if (ticket == 100) {
                return true;
            } else {
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                ticket++;
                System.out.println(Thread.currentThread().getName() + "在卖第" + ticket + "张票");
            }
        }
        return false;
    }
}

```
