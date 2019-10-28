package com.softnovo.base;

import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

public class Test {
	public static void main(String[] args) throws Exception {
	    ThreadPoolTaskExecutor executorService = new ThreadPoolTaskExecutor();
	    executorService.setCorePoolSize(20);
	    executorService.setMaxPoolSize(20);
	    executorService.setKeepAliveSeconds(60);
	    executorService.setQueueCapacity(Integer.MAX_VALUE);
	    executorService.initialize();
	    
	    AtomicInteger atomicInteger = new AtomicInteger(0);
	    for (int i = 0; i < 10; i++) {
	    	executorService.submitListenable(
		    		new Callable<Integer>() {
						@Override
						public Integer call() throws Exception {
							Thread.sleep(5000);
							return 2;
						}
					}).addCallback(new ListenableFutureCallbackImpl(atomicInteger));
	    	System.out.println(i);
	    } 
	    
	    System.out.println("_+_+_+_+" + atomicInteger.get());
	    
	    Thread.sleep(10000);
	    System.out.println("_+_+_+_+" + atomicInteger.get());
	    
//	    		).addCallback(
//	   new SuccessCallback() {
//
//		@Override
//		public void onSuccess(Object result) {
//			result
//		}
//		   
//	},
//	    ex -> System.out.println("**异常信息**：" ));//ExceptionUtils.getExceptionMsg(ex)));
//	}
}
}
