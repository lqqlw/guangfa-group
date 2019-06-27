package com.bbs.service;

import com.bbs.domain.Word;

import java.util.List;

/**
 * 敏感词汇的service
 */
public interface WordsService {
    /**
     * 查询所有敏感词汇
     * @return
     */
    List<Word> findByPage(int page,int size);

    /**
     * 处理敏感词汇
     * @param id
     * @param status
     */
    void processing(Integer id, Integer status);

    /**
     * 增加敏感词
     * @param words
     */
    void save(Word words);
}
