package com.sist.web.dao;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.sist.web.entity.BusanInfoEntity;

@Repository
public interface BusanInfoRepository extends JpaRepository<BusanInfoEntity, Integer>{
	@Query(value = "SELECT * FROM busan_info ORDER BY no ASC LIMIT 0, 5", nativeQuery = true)
	public List<BusanInfoEntity> busanInfoMainData();
	
	@Query(value = "SELECT * FROM busan_info WHERE cno = :cno ORDER BY no ASC", nativeQuery = true)
	public List<BusanInfoEntity> busanInfoListData(@Param("cno") Integer cno, Pageable pageable);
	
	@Query(value = "SELECT CEIL(COUNT(*) / 12.0) FROM busan_info WHERE cno = :cno", nativeQuery = true)
	public int busanInfoTotalPage(@Param("cno") Integer cno);
	
	//@Query(value = "SELECT * FROM busan_info WHERE title LIKE CONCAT('%', :title, '%')", nativeQuery = true)
	//public List<BusanInfoEntity> busanFindData(@Param("title") String title);
	
	public List<BusanInfoEntity> findByTitleContaining(@Param("title") String title);
	
}
