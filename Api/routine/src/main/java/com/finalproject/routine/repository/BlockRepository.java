package com.finalproject.routine.repository;

import com.finalproject.routine.model.Block;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BlockRepository extends JpaRepository<Block,Integer> {

}
