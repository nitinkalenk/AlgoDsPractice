package com.practice.array.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// https://leetcode.com/problems/insert-delete-getrandom-o1
public class RandomizedSet {

  java.util.Random random;
  List<Integer> list;
  Map<Integer, Integer> numToIndexMap;

  public RandomizedSet() {
    random = new java.util.Random();
    list = new ArrayList();
    numToIndexMap = new HashMap();
  }

  public boolean insert(int val) {
    if(numToIndexMap.containsKey(val)) {
      return false;
    }
    numToIndexMap.put(val, list.size());
    list.add(val);
    return true;
  }

  public boolean remove(int val) {
    if(!numToIndexMap.containsKey(val)) {
      return false;
    }
    int loc = numToIndexMap.get(val);
    if(loc != list.size() - 1) {
      int lastEle = list.get(list.size() - 1);
      list.set(loc, lastEle);
      numToIndexMap.put(lastEle, loc);
    }
    list.remove(list.size() -1);
    numToIndexMap.remove(val);
    return true;
  }

  public int getRandom() {
    return list.get(random.nextInt(list.size()));
  }


}
