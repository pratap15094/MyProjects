package com.user.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.user.entity.Subscription;
import com.user.entity.User;
import com.user.repository.ISubscriptionRepository;
import com.user.repository.UserRepository;

@Service
public class SubscriptionServiceImpl implements ISubscriptionService{

	@Autowired
	ISubscriptionRepository subscriptionRepo;
	
	@Autowired
	UserRepository userRepository ;
	
	@Autowired
	SendEmail sendEmail;
	
	@Autowired
	RestTemplate restTemplate;
	
	@Override
	public int createSubcription(int userId, int bookId) {
		Subscription subscribe = new Subscription();
		subscribe.setUserId(userId);
		subscribe.setBookId(bookId);
		LocalDateTime date = LocalDateTime.now();
		subscribe.setDate(String.valueOf(date));
		subscriptionRepo.save(subscribe);
		Optional<User> user = userRepository.findById((long) userId);
		String info=" "+user.get().getUsername()+" You are Subscribed to "+bookId+",Your Subscription Id is "+subscribe.getSubscriptionId();
		sendEmail.mailer(user.get().getEmail(), info);
		return subscribe.getSubscriptionId();
	}

	@Override
	public String deleteSubscripton(int subscriptionId) {
		Optional<Subscription> subscribe = null;
		subscribe = subscriptionRepo.findById(subscriptionId);
		Subscription subsObj = subscribe.get();
		LocalDateTime date = LocalDateTime.parse(String.valueOf(LocalDateTime.now()));
		LocalDateTime dbTime = LocalDateTime.parse(String.valueOf(subsObj.getDate()));
	    long timeDiff = java.time.Duration.between(date,dbTime).toHours();
	    Optional<Subscription> subs = subscriptionRepo.findById(subscriptionId);
	    Optional<User> user = userRepository.findById((long) subs.get().getUserId());
	    String info=null;
	    if(Math.abs(timeDiff) < 24) {
	    
		subscriptionRepo.deleteById(subscriptionId);
		info = "Subscription Id"+subscriptionId+" Cancelled!";
		sendEmail.mailer(user.get().getEmail(), info);
		return "Subscription cancelled!";
	    }
	    else
	    {
	    	info = "Subscription cannot be cancelled post 24 hours. kindly check Support!";
	    	sendEmail.mailer(user.get().getEmail(), info);
	    	return "Subscription cannot be cancelled post 24 hours";
	    }
		
	}

	@Override
	public int getSubscriptionIdbyUserIdBookId(int userId, int bookId) {
		try {
		List<Subscription> subscriber = subscriptionRepo.findByUserIdAndBookId(userId, bookId);
		Subscription subscriberObj = subscriber.get(0);
		return subscriberObj.getSubscriptionId();
		}
		catch(Exception ex) {
			System.out.println("Not subscribed");
			return 0;
		}
		
	}

	@Override
	public List<Subscription> getAllBookIdBySubscriptionId(int userId) {
		List<Subscription> bookIds = subscriptionRepo.findByUserId(userId);
		return bookIds;
	}
	

}
