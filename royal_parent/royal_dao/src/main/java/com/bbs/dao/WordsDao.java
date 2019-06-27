package com.bbs.dao;

import com.bbs.domain.Word;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * 敏感词汇的dao
 */
public interface WordsDao {
    /**
     * 查询所有敏感词汇
     * @return
     */
    @Select("select * from bbs_word_table")
    List<Word> findByPage();

    /**
     * 处理敏感字符
     * @param id
     * @param status
     */
    @Update("update bbs_word_table set status=#{status} where wordId = #{id}")
    void processing(@Param("id") Integer id,@Param("status") Integer status);

    /**
     * 增加敏感词
     * @param word
     */
    @Insert("insert into bbs_word_table (word) values (#{word})")
    void save(Word word);
}
