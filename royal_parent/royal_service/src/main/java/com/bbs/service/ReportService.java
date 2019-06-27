package com.bbs.service;

import com.bbs.domain.Report;

import java.util.List;

/**
 * 举报信息的service
 */
public interface ReportService {
    /**
     * 查询所有举报信息
     * @return
     */
    List<Report> findByPage(int page,int size);

    /**
     * 处理举报信息
     * @param id
     * @param reportStatus
     */
    void processing(Integer id, Integer reportStatus);
}
