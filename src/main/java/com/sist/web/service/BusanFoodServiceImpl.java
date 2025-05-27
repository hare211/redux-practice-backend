package com.sist.web.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.sist.web.dao.BusanFoodRepository;
import com.sist.web.dao.BusanInfoRepository;
import com.sist.web.entity.BusanInfoEntity;
import com.sist.web.vo.BusanFoodVO;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BusanFoodServiceImpl implements BusanFoodService {
	
	private final BusanFoodRepository bDao;
	private final BusanInfoRepository iDao;
	
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
	
	@Override
	public List<BusanInfoEntity> busanInfoMainData() {
		List<BusanInfoEntity> list = new ArrayList<>();
		try {
			list = iDao.busanInfoMainData();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return list;
	}
	
	@Override
	public int busanFoodTotalPage() {
		Integer totalPage = null;
		try {
			totalPage = bDao.busanFoodTotalPage();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		return totalPage;
	}
	
	@Override
	public List<BusanFoodVO> busanListData(int start) {
		List<BusanFoodVO> list = new ArrayList<>();
		try {
			list = bDao.busanListData(start);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return list;
	}
}
