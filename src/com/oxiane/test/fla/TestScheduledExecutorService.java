package com.oxiane.test.fla;

import static java.util.concurrent.TimeUnit.SECONDS;

import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;

public class TestScheduledExecutorService {

  public static void main(String[] args) {
    final ScheduledExecutorService executor = Executors.newScheduledThreadPool(2);

    final Runnable maTache = new Runnable() {
      public void run() {
        System.out.println("Ma tache (" + Thread.currentThread().getName() + ") " + new Date());
      }
    };

    final ScheduledFuture<?> maTacheFuture = executor.scheduleAtFixedRate(maTache, 10, 10, SECONDS);
    final ScheduledFuture<?> maTacheFuture2 = executor.scheduleAtFixedRate(maTache, 5, 10, SECONDS);

//    Runtime.getRuntime().addShutdownHook(new Thread() {
//      public void run() {
//        executor.shutdown();
//      }
//    });
  }
}
