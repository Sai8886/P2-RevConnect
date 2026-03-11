package com.example.revconnect.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.revconnect.entity.Follow;
import com.example.revconnect.entity.User;

public interface FollowRepository extends JpaRepository<Follow, Long> {

    Optional<Follow> findByFollowerAndFollowing(User follower, User following);

    boolean existsByFollowerUserIdAndFollowingUserId(Long followerId, Long followingId);
    Optional<Follow> findByFollowerUserIdAndFollowingUserId(Long followerId, Long followingId);
    List<Follow> findByFollower(User follower);
    List<Follow> findByFollowing(User following);

    List<Follow> findByFollowerUserId(Long userId);
    

    //  ADD THESE (Missing Before)
    long countByFollower(User follower);
    long countByFollowing(User following);
    
    long countByFollowingUserId(Long userId);

    long countByFollowerUserId(Long userId);
    
    @Query("""
    		SELECT f.follower.accountType, COUNT(f)
    		FROM Follow f
    		WHERE f.following.userId = :userId
    		GROUP BY f.follower.accountType
    		""")
    		List<Object[]> getFollowerDemographics(Long userId);
    
}
