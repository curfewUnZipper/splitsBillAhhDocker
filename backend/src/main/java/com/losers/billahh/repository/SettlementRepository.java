package com.losers.billahh.repository;

import com.losers.billahh.model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface SettlementRepository extends JpaRepository<Settlement, Long> {
    List<Settlement> findByGroup(Group group);
}