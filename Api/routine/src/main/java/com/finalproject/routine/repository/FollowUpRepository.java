package com.finalproject.routine.repository;
import com.finalproject.routine.model.FollowUp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FollowUpRepository extends JpaRepository<FollowUp,String> {
}
