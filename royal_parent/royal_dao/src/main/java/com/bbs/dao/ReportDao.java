package com.bbs.dao;

import com.bbs.domain.Report;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * 举报所有信息dao
 * @author
 */
public interface ReportDao {
    /**
     * 查询所有举报信息
     * @return
     */
    @Select("select * from bbs_report_table")
    List<Report> findByPage();

    /**
     * 处理举报信息
     * @param id
     * @param reportStatus
     */
    @Update("update bbs_report_table set reportStatus=#{reportStatus} where reportId = #{id}")
    void processing(@Param("id") Integer id, @Param("reportStatus") Integer reportStatus);
}
