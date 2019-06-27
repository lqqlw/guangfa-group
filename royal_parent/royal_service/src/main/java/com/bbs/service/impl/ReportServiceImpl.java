package com.bbs.service.impl;

import com.bbs.dao.ReportDao;
import com.bbs.domain.Report;
import com.bbs.service.ReportService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(rollbackFor = Exception.class)
public class ReportServiceImpl implements ReportService {
    @Autowired
    private ReportDao reportDao;

    /**
     * 显示所有举报信息，分页状态
     * @param page
     * @param size
     * @return
     */
    @Override
    public List<Report> findByPage(int page,int size) {
        PageHelper.startPage(page,size);
        return reportDao.findByPage();
    }

    /**
     * 操作举报状态
     * @param id
     * @param reportStatus
     */

    @Override
    public void processing(Integer id, Integer reportStatus) {
        reportDao.processing(id,reportStatus);
    }
}
