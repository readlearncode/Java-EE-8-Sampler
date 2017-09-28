package com.readlearncode.devWorks.part1.arraysandcollections;

import java.util.HashMap;
import java.util.Map;

/**
 * Source code github.com/readlearncode
 *
 * @author Alex Theedom www.readlearncode.com
 * @version 1.0
 */
public class ScoreBoard {

    public Map<String, Integer> scores = new HashMap<String, Integer>() {{
        put("John", 12);
        put("Jane", 34);
    }};

}