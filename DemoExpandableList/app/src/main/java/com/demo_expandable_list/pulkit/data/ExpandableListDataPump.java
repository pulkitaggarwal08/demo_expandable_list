package com.demo_expandable_list.pulkit.data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by pulkit on 10/1/18.
 */

public class ExpandableListDataPump {

    public static HashMap<String, List<String>> getData() {

        HashMap<String, List<String>> groupListDetail = new HashMap<>();

        List<String> cricket = new ArrayList<String>();
        cricket.add("India");
        cricket.add("Pakistan");
        cricket.add("Australia");
        cricket.add("England");
        cricket.add("South Africa");

        List<String> football = new ArrayList<String>();
        football.add("Brazil");
        football.add("Spain");
        football.add("Netherlands");
        football.add("Italy");

        List<String> basketball = new ArrayList<String>();
        basketball.add("United States");
        basketball.add("France");
        basketball.add("Russia");


        groupListDetail.put("CRICKET TEAMS", cricket);
        groupListDetail.put("FOOTBALL TEAMS", football);
        groupListDetail.put("BASKETBALL TEAMS", basketball);

        return groupListDetail;
    }

}
