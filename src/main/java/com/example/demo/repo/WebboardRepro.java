package com.example.demo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Webboard;

public interface WebboardRepro extends JpaRepository<Webboard, Integer> {
	public List<Webboard> findByTitleAndStory(String title,String story);
}
