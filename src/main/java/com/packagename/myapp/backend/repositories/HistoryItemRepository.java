package com.packagename.myapp.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.packagename.myapp.backend.data.entity.HistoryItem;

public interface HistoryItemRepository extends JpaRepository<HistoryItem, Long> {
}
