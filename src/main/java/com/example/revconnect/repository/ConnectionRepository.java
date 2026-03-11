package com.example.revconnect.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.revconnect.entity.Connection;
import com.example.revconnect.entity.User;

@Repository
public interface ConnectionRepository extends JpaRepository<Connection, Long> {
	Connection findBySenderUserIdAndReceiverUserId(Long senderId, Long receiverId);

	Connection findBySenderUserIdAndReceiverUserIdOrSenderUserIdAndReceiverUserId(
	        Long sender1, Long receiver1,
	        Long sender2, Long receiver2);

    List<Connection> findByReceiverAndStatus(User receiver, String status);

    List<Connection> findBySender(User sender);
}