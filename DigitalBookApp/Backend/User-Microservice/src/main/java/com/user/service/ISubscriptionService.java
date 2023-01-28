package com.user.service;

import java.util.List;

import com.user.entity.Subscription;

public interface ISubscriptionService {
	
	public int createSubcription(int userId,int bookId);
	
	public String deleteSubscripton(int subscriptionId);
	 
	public int getSubscriptionIdbyUserIdBookId(int userId,int bookId);
	
	public List<Subscription> getAllBookIdBySubscriptionId(int userId);
	
}