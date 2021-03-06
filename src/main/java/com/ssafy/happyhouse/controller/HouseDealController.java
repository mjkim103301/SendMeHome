package com.ssafy.happyhouse.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.ssafy.happyhouse.dto.HouseDealDto;
import com.ssafy.happyhouse.service.HouseDealService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@CrossOrigin("*")
@RequestMapping(path="/housedeal")
@Api(value="HappyHouse" , description="HappyHouse Resources Management 2021")
public class HouseDealController {
	@Autowired
	private HouseDealService houseDealService;
	
	private List<HouseDealDto> list;
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@ApiOperation(value = "실거래가 리스트")
	@PostMapping(path="/search")
	public ResponseEntity<List<HouseDealDto>> houseDealSearch(@RequestBody List<Map<String,Object>> params) {
		
		System.out.println("houseDealSearch params "+params);
		List<HouseDealDto> houseDealDtoList=new ArrayList<>();
		
		for(Map<String, Object> p:params) {
			String dongcode=(String) p.get("dongcode");
			System.out.println("dongcode "+dongcode);
			if(dongcode==null||dongcode.length()==0) {
				System.out.println("dongocde is null");
				continue;
			}
			
			String guguncode=dongcode.substring(0, 5);
			
			houseDealDtoList.add(new HouseDealDto((String)p.get("dong"), Long.parseLong(dongcode), Long.parseLong(guguncode)));
		}
		System.out.println("houseDealDtoList size "+houseDealDtoList.size());
		if(houseDealDtoList.size()>0) {
			list=houseDealService.houseDealList(houseDealDtoList);
		}else {
			System.out.println("controller houseDealSearch AptName "+params.get(0));
			System.out.println("controller houseDealSearch AptName "+(String) params.get(0).get("keyword"));
			list=houseDealService.houseDealList((String) params.get(0).get("keyword"));
		}
		
		return new ResponseEntity<List<HouseDealDto>> (list, HttpStatus.OK);
	}
	
	@ApiOperation(value = "실거래가 리스트")
	@GetMapping(path="/search")
	public ResponseEntity<List<HouseDealDto>> allHouseDealSearch() {
		List<HouseDealDto> list=houseDealService.allHouseDealList();
		
		return new ResponseEntity<List<HouseDealDto>> (list, HttpStatus.OK);
	}	
}
