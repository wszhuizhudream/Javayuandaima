package com.wschase.lock;

import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**AQS模板例子——自己实现一个锁
 * Author:WSChase
 * Created:2019/1/10
 */

class Mutex implements Lock {

    private Sync sync=new Sync();
    //自定义同步器
    static class Sync extends AbstractQueuedSynchronizer{


        @Override
        protected boolean tryAcquire(int arg) {
            if(arg!=1){
                throw new RuntimeException("arg参数不为1");
            }
            //获取锁：从0变成1
            if(compareAndSetState(0,1)){
                //此时线程成功获取同步状态
                setExclusiveOwnerThread(Thread.currentThread());
                return true;
            }
            return false;
        }

        @Override
        protected boolean tryRelease(int arg) {
            //释放锁：从1变成0
            if(getState()==0){
                throw new IllegalMonitorStateException();
            }
            setExclusiveOwnerThread(null);
            setState(0);
            return true;
        }

        @Override
        protected boolean isHeldExclusively() {
            return getState()==1;//为1表示持有线程
        }
    }
    //---------------------------------------------------------------
    @Override
    public void lock() {

        sync.acquire(1);//调用acquire来上锁
    }

    @Override
    public void lockInterruptibly() throws InterruptedException {

        sync.acquireInterruptibly(1);
    }

    @Override
    public boolean tryLock() {
        return sync.tryAcquire(1);
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return sync.tryAcquireNanos(1,time);
    }

    @Override
    public void unlock() {

         sync.release(1);
    }

    @Override
    public Condition newCondition() {
        return null;
    }
    //----------------------------------------------------------------
}


public class TestAQSmoban {
    public static void main(String[] args) {
        Lock lock=new Mutex();
        for(int i=0;i<10;i++){
            Thread thread=new Thread(()-> {
                try{
                lock.lock();
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } finally{
                lock.unlock();
            }
            });
            thread.start();
        }
    }
}

