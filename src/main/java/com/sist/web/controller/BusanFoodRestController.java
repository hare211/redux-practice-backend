package com.sist.web.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

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
			map.put("mp", vo);
			map.put("mList", mList);
			map.put("lList", lList);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		return map;
	}
}
