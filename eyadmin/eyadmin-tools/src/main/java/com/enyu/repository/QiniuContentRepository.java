package com.enyu.repository;

import com.enyu.domain.QiniuContent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @author 
 * @date 2018-12-31
 */
public interface QiniuContentRepository extends JpaRepository<QiniuContent,Long>, JpaSpecificationExecutor<QiniuContent> {

    /**
     * 根据key查询
     * @param key 文件名
     * @return QiniuContent
     */
    QiniuContent findByKey(String key);
}
