package com.softnovo.base;

import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.util.concurrent.ListenableFutureCallback;

public class ListenableFutureCallbackImpl implements ListenableFutureCallback<Integer> {
	private AtomicInteger atomicInteger;
	public ListenableFutureCallbackImpl(AtomicInteger atomicInteger) {
		this.atomicInteger = atomicInteger;
	}
	@Override
	public void onFailure(Throwable ex) {
		ex.printStackTrace();
	}

	@Override
	public void onSuccess(Integer result) {
		System.out.println("dsfsdf" + result);
		atomicInteger.addAndGet(result);
	}
}
