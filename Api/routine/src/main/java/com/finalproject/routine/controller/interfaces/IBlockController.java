package com.finalproject.routine.controller.interfaces;

import com.finalproject.routine.model.Block;

import java.util.List;

public interface IBlockController {
    Block getBlock(Integer id);
    List<Block> getAllBlocks();
    void createBlock(Block block);
}
