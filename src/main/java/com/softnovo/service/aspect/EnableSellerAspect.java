package com.softnovo.service.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclareParents;
import org.springframework.stereotype.Service;

import com.softnovo.service.Seller;
import com.softnovo.service.impl.SmartSeller;

@Aspect
@Service
public class EnableSellerAspect {
	@DeclareParents(value = "com.softnovo.service.impl.NaiveWaiter", defaultImpl = SmartSeller.class)
	public Seller seller;
}
