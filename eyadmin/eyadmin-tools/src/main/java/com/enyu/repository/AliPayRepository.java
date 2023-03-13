package com.enyu.repository;

import com.enyu.domain.AlipayConfig;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author 
 * @date 2018-12-31
 */
public interface AliPayRepository extends JpaRepository<AlipayConfig,Long> {
}
