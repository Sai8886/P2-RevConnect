package com.example.revconnect.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.revconnect.entity.Connection;
import com.example.revconnect.entity.NotificationType;
import com.example.revconnect.entity.User;
import com.example.revconnect.repository.ConnectionRepository;
import com.example.revconnect.repository.UserRepository;

@Service
public class ConnectionService {

    @Autowired
    private ConnectionRepository connectionRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private NotificationService notificationService;

    public Connection sendRequest(Long senderId, Long receiverId) {

        User sender = userRepository.findById(senderId).orElseThrow();
        User receiver = userRepository.findById(receiverId).orElseThrow();

        Connection connection = new Connection();
        connection.setSender(sender);
        connection.setReceiver(receiver);
        connection.setStatus("PENDING");

        Connection saved = connectionRepository.save(connection);

        notificationService.createNotification(
                sender,
                receiver,
                NotificationType.CONNECTION_REQUEST,
                sender.getUserName() + " sent you a connection request"
        );

        return saved;
    }

    public Connection acceptRequest(Long connectionId) {

        Connection connection = connectionRepository.findById(connectionId).orElseThrow();
        connection.setStatus("ACCEPTED");

        Connection saved = connectionRepository.save(connection);

        notificationService.createNotification(
                connection.getReceiver(),
                connection.getSender(),
                NotificationType.CONNECTION_ACCEPTED,
                connection.getReceiver().getUserName() + " accepted your connection request"
        );

        return saved;
    }

    public Connection rejectRequest(Long connectionId) {
        Connection connection = connectionRepository.findById(connectionId).orElseThrow();
        connection.setStatus("REJECTED");
        return connectionRepository.save(connection);
    }

    public List<Connection> getConnections(Long userId) {
        User user = userRepository.findById(userId).orElseThrow();
        return connectionRepository.findByReceiverAndStatus(user, "ACCEPTED");
    }

    public List<Connection> getPendingRequests(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
        return connectionRepository.findByReceiverAndStatus(user, "PENDING");
    }

    public String removeConnection(Long userId, Long connectionUserId) {
        Connection connection = connectionRepository
                .findBySenderUserIdAndReceiverUserIdOrSenderUserIdAndReceiverUserId(
                        userId, connectionUserId,
                        connectionUserId, userId
                );

        if (connection == null || !connection.getStatus().equals("ACCEPTED")) {
            throw new RuntimeException("Connection not found");
        }

        connectionRepository.delete(connection);
        return "Connection removed successfully";
    }

    public List<Connection> getSentRequests(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        return connectionRepository.findBySender(user)
                .stream()
                .filter(c -> c.getStatus().equals("PENDING"))
                .toList();
    }
}