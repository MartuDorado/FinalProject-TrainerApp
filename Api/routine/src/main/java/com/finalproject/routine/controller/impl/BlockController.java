package com.finalproject.routine.controller.impl;

import com.finalproject.routine.controller.interfaces.IBlockController;
import com.finalproject.routine.model.Block;
import com.finalproject.routine.service.interfaces.IBlockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
public class BlockController implements IBlockController {
    @Autowired
    IBlockService iBlockService;

    @GetMapping("/blocks/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Block getBlock(@PathVariable Integer id) {
        try{
            return iBlockService.getBlock(id);
        }catch (IllegalArgumentException i){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/blocks")
    @ResponseStatus(HttpStatus.OK)
    public List<Block> getAllBlocks() {
        try{
            return iBlockService.getAllBlocks();
        }catch (IllegalArgumentException i){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/blocks")
    @ResponseStatus(HttpStatus.CREATED)
    public void createBlock(Block block) {
      try{
          iBlockService.createBlock(block);
      }catch (IllegalArgumentException i){
          throw new ResponseStatusException(HttpStatus.CONFLICT);
      }
    }
}
