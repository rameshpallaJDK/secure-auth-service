package com.miniproj.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.miniproj.entity.PasswordHistory;
import com.miniproj.entity.User;

public interface PasswordHistoryRepository extends JpaRepository<PasswordHistory, Long> {

	List<PasswordHistory> findTop3ByUserOrderByChangedAtDesc(User user);

}
