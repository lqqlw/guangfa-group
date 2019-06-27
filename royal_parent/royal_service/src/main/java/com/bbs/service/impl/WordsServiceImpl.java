package com.bbs.service.impl;

import com.bbs.dao.WordsDao;
import com.bbs.domain.Word;
import com.bbs.service.WordsService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WordsServiceImpl implements WordsService {
    @Autowired
    private WordsDao wordsDao;

    /**
     * 查找所有敏感词
     * @param page
     * @param size
     * @return
     */
    @Override
    public List<Word> findByPage(int page,int size) {
        PageHelper.startPage(page,size);
        return wordsDao.findByPage();
    }

    /**
     * 修改敏感词状态
     * @param id
     * @param status
     */
    @Override
    public void processing(Integer id, Integer status) {
        wordsDao.processing(id,status);
    }

    /**
     * 增加敏感词
     * @param words
     */
    @Override
    public void save(Word words) {
        wordsDao.save(words);
    }
}
