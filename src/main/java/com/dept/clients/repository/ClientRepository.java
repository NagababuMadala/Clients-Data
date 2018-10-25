package com.dept.clients.repository;

import com.dept.clients.dto.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ClientRepository extends JpaRepository<Client,Long> {

    /*@Query("SELECT userHistory FROM UserHistoryEntity userHistory "
            + "WHERE userHistory.userId = :userId AND "
            + "userHistory.date = :requestDate" )
    List<Client> searchUserHistory(@Param("userId") Long userId, @Param("requestDate") Date requestDate);*/

}
