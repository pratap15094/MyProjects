package com.cafe.service;

import java.util.Map;

import org.springframework.http.ResponseEntity;

public interface DashBoardService {

	ResponseEntity<Map<String, Object>> getCount();

}
