package com.stockagent.service;

import java.util.List;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stockagent.model.Direction;
import com.stockagent.repository.DirectionRepository;
@Service
public class DirectionServiceImpl implements DirectionService {
	private final Logger log = LoggerFactory.getLogger(DirectionServiceImpl.class);
	@Autowired
	private DirectionRepository directionRepository;
	
	@Override
	public Direction save(Direction direction) {
		 log.debug("Request to save Direction : {}", direction);
	     return directionRepository.save(direction);
	}

	@Override
	public List<Direction> findAll() {
		log.debug("Request to get all Directions");
        return directionRepository.findAll();
	}

	@Override
	public Optional<Direction> findOne(Long id) {
		log.debug("Request to get Direction : {}", id);
        return directionRepository.findById(id);
	}

	@Override
	public void delete(Long id) {
        log.debug("Request to delete Direction : {}", id);
        directionRepository.deleteById(id);
	}
	
}
