package com.sist.web.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sist.web.entity.BusanFoodEntity;
import com.sist.web.vo.BusanFoodVO;

public interface BusanFoodRepository extends JpaRepository<BusanFoodEntity, Integer>{
	@Query("SELECT no, poster, name, hit, jjimcount, likecount, score, type "
		 + "FROM busan_food ORDER BY no ASC "
		 + "LIMIT 0, 9")
	public List<BusanFoodVO> busanMainData();
}
