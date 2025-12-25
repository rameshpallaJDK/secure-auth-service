package com.miniProj.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.miniProj.entity.EmailLog;

public interface EmailLogRepository extends JpaRepository<EmailLog, Long> {

}
