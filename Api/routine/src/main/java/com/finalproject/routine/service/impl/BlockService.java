package com.finalproject.routine.service.impl;

import com.finalproject.routine.model.Block;
import com.finalproject.routine.repository.BlockRepository;
import com.finalproject.routine.service.interfaces.IBlockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlockService implements IBlockService {
    @Autowired
    BlockRepository blockRepository;


    public Block getBlock(Integer id) {
        if(blockRepository.findById(id).isEmpty())throw new IllegalArgumentException("Block does not exist.");
        return blockRepository.findById(id).get();
    }


    public List<Block> getAllBlocks() {
        if(blockRepository.findAll().toArray().length == 0) throw new IllegalArgumentException("No blocks saved.");
        return blockRepository.findAll();
    }


    public void createBlock(Block block) {
      blockRepository.save(block);
    }
}
