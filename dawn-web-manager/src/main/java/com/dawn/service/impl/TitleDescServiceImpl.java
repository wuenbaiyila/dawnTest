package com.dawn.service.impl;

import com.dawn.dto.TitleDescDto;
import com.dawn.dtomapper.TitleDescDtoMapper;
import com.dawn.service.TitleDescService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TitleDescServiceImpl implements TitleDescService {
	@Autowired
	private TitleDescDtoMapper mapper;
	private static final Logger LOGGER = LoggerFactory.getLogger(TitleDescServiceImpl.class);
	// 根据知识点查询答案

	public TitleDescDto selectByTbtitleId(long tbtitleId) {
		LOGGER.debug("TitleDescServiceImpl selectByTbtitleId方法开始 ");
		return mapper.selectByTbtitleId(tbtitleId);
	}

}
