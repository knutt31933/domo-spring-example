package com.example.demo.controller;

import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.bean.WebboardBean;
import com.example.demo.entity.Webboard;
import com.example.demo.repo.CustomRepo;
import com.example.demo.repo.WebboardRepro;

@RestController
@RequestMapping("/service")
public class AppResController {
	@Autowired WebboardRepro atwwrp;
	@Autowired CustomRepo customrepo;
	
	@RequestMapping(method=RequestMethod.GET,value="/findByTitleAndStory")
	public List<Webboard> findByTitleAndStory(@RequestParam String aTitle,String aStory){
		List<Webboard> wbList=atwwrp.findByTitleAndStory(aTitle, aStory);
        return wbList;

	}
	
	@RequestMapping(method=RequestMethod.POST,value="/addWebboard")
	public void addWebboard(@RequestBody Webboard webboard){
		//webboard.setCreateDate(String.valueOf(new Date().getTime()));
		atwwrp.save(webboard);
	}
	
	@RequestMapping(method=RequestMethod.GET,value="/findAll")
	public List<Webboard> findAll() {
		return customrepo.findAll();
	}
	
	@RequestMapping(method=RequestMethod.GET,value="/findByTitleAndStoryAndAuthor")
	public List<WebboardBean> findByTitleAndStoryAndAuthor(@RequestParam(required=false) String aTitle,@RequestParam(required=false) String aStory,@RequestParam(required=false) String aAuthor){
		List<WebboardBean> wbList=customrepo.findByTitleAndAuthor(aTitle, aStory,aAuthor);
        return wbList;

	}

}