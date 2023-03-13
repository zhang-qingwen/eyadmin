package com.enyu.repository;

import com.enyu.domain.EmailConfig;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author
 * @date 2018-12-26
 */
public interface EmailRepository extends JpaRepository<EmailConfig,Long> {
}
