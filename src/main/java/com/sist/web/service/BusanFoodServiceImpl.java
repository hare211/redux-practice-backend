package com.sist.web.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.sist.web.dao.BusanFoodRepository;
import com.sist.web.vo.BusanFoodVO;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BusanFoodServiceImpl implements BusanFoodService {
	
	private final BusanFoodRepository bDao;
	
	@Override
	public List<BusanFoodVO> busanMainData() {
		List<BusanFoodVO> list = new ArrayList<>();
		try {
			list = bDao.busanMainData();
			for (BusanFoodVO vo : list) {
				
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return list;
	}
}
