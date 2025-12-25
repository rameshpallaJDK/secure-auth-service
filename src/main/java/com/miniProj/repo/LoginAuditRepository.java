package com.miniProj.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.miniProj.entity.LoginAudit;

public interface LoginAuditRepository extends JpaRepository<LoginAudit, Long> {

}
