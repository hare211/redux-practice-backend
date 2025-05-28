package com.sist.web.service;

import java.util.List;


import com.sist.web.entity.BusanFoodEntity;
import com.sist.web.entity.BusanInfoEntity;
import com.sist.web.vo.BusanFoodVO;

public interface BusanFoodService {
	List<BusanFoodVO> busanMainData();
	List<BusanInfoEntity> busanInfoMainData();
	public List<BusanFoodVO> busanListData(int start);
	public int busanFoodTotalPage();
	public BusanFoodEntity busanDetailData(int fno);
	public List<BusanInfoEntity> busanInfoListData(int cno, int page, int size);
	public int busanInfoTotalPage(Integer cno);
	public List<BusanInfoEntity> findByTitleContaining(String title);
}
