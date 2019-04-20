package com.example.demo.entity.json;

import lombok.Data;

@Data
public class LevelJson {
    private int voteNumTotal;
    private int level;
    private int levelUpNeed;

   public LevelJson(){}
   public LevelJson(int voteNumTotal ,int level,int levelUpNeed){
       this.level = level;
       this.voteNumTotal = voteNumTotal;
       this.levelUpNeed = levelUpNeed;
   }
}
