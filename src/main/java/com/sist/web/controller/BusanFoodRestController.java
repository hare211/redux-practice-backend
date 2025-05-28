package com.sist.web.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sist.web.entity.BusanFoodEntity;
import com.sist.web.entity.BusanInfoEntity;
import com.sist.web.service.BusanFoodService;
import com.sist.web.vo.BusanFoodVO;

import lombok.RequiredArgsConstructor;

@CrossOrigin(origins = "*")
@RestController
@RequiredArgsConstructor
public class BusanFoodRestController {
	private final BusanFoodService bService;
	
	@GetMapping("/main-react")
	public Map<String, Object> getMainData() {
		Map<String, Object> map = new HashMap<>();
		
		try {
			List<BusanFoodVO> list = bService.busanMainData();
			BusanFoodVO vo = list.get(0);
			List<BusanFoodVO> mList = new ArrayList<>();
			List<BusanFoodVO> lList = new ArrayList<>();
			for (int i = 1; i <= 4; i++) {
				mList.add(list.get(i));
			}
			for (int i = 5; i < list.size(); i++) {
				lList.add(list.get(i));
			}
			
			List<BusanInfoEntity> iList = bService.busanInfoMainData();
			
			map.put("mp", vo);
			map.put("mList", mList);
			map.put("lList", lList);
			map.put("iList", iList);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		return map;
	}
	
	@GetMapping("/food/list-react")
	public Map<String, Object> getFoodList(@RequestParam(name = "page", defaultValue = "1") int page) {
		Map<String, Object> map = new HashMap<>();
		int rowSize = 12;
		//int start = (rowSize * page) - rowSize;
		int start = (page - 1) * rowSize;
		
		try {
			List<BusanFoodVO> list = bService.busanListData(start);
			int totalPage = bService.busanFoodTotalPage();
			
			final int BLOCK = 10;
			int startPage = ((page - 1) / BLOCK * BLOCK) - 1;
			int endPage = ((page - 1) / BLOCK * BLOCK) + BLOCK;
			
			if (endPage > totalPage) {
				endPage = totalPage;
			}
			
			map.put("curPage", page);
			map.put("totalPage", totalPage);
			map.put("startPage", startPage);
			map.put("endPage", endPage);
			map.put("list", list);
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		return map;
	}
	
	@GetMapping("/food/detail-react")
	public BusanFoodEntity food_detail(@RequestParam("fno") int fno) {
		BusanFoodEntity vo = new BusanFoodEntity();
		try {
			vo = bService.busanDetailData(fno);
			System.out.println(vo.toString());
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return vo;
	}
	
	@GetMapping("/info/list-react")
	public Map<String, Object> info_list(@RequestParam("cno") int cno, @RequestParam("page") int page) {
		Map<String, Object> map = new HashMap<>();
		int rowSize = 12;
		
		List<BusanInfoEntity> list = bService.busanInfoListData(cno, page - 1, rowSize);
		
		int totalPage = bService.busanInfoTotalPage(cno);
		
		map.put("curPage", page);
		map.put("totalPage", totalPage);
		map.put("list", list);
		
		return map;
	}
}
