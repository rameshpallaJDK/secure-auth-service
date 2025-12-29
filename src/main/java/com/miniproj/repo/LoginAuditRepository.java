package com.miniproj.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.miniproj.entity.LoginAudit;

public interface LoginAuditRepository extends JpaRepository<LoginAudit, Long> {

}
