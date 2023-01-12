package com.finalproject.routine.service.interfaces;

import com.finalproject.routine.model.Block;

import java.util.List;

public interface IBlockService {
    Block getBlock(Integer id);
    List<Block> getAllBlocks();
    void createBlock(Block block);
}
