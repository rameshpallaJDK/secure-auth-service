package com.miniProj.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.miniProj.entity.PasswordHistory;
import com.miniProj.entity.User;

public interface PasswordHistoryRepository extends JpaRepository<PasswordHistory, Long> {

	List<PasswordHistory> findTop3ByUserOrderByChangedAtDesc(User user);

}
