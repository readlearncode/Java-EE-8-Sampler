package com.readlearncode.devWorks.part1.arraysandcollections;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Source code github.com/readlearncode
 *
 * @author Alex Theedom www.readlearncode.com
 * @version 1.0
 */
public class ArraysAndCollections {

    private Map<String, Integer> map;

    private List<String> list;

    private Set<String> set;

    private int[] ints = new int[5];

    private int[][] ints2d = new int[5][];


    public Map<String, Integer> getMap() {
        return map;
    }

    public void setMap(Map<String, Integer> map) {
        this.map = map;
    }

    public List<String> getList() {
        return list;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    public Set<String> getSet() {
        return set;
    }

    public void setSet(Set<String> set) {
        this.set = set;
    }

    public int[] getInts() {
        return ints;
    }

    public void setInts(int[] ints) {
        this.ints = ints;
    }

    public int[][] getInts2d() {
        return ints2d;
    }

    public void setInts2d(int[][] ints2d) {
        this.ints2d = ints2d;
    }
}