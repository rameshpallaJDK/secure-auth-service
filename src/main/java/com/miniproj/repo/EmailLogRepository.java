package com.miniproj.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.miniproj.entity.EmailLog;

public interface EmailLogRepository extends JpaRepository<EmailLog, Long> {

}
