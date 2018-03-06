package com.demo_expandable_list.pulkit.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.Toast;

import com.demo_expandable_list.pulkit.R;
import com.demo_expandable_list.pulkit.adapters.CustomExpandableListAdapter;
import com.demo_expandable_list.pulkit.data.ExpandableListDataPump;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

    /*In this Example, I am not using any kind of library*/

public class ExpandableListViewActivity extends AppCompatActivity {

    private ExpandableListView elvItems;

    private ExpandableListAdapter customExpandableListAdapter;

    private HashMap<String, List<String>> groupListDetail;
    private List<String> groupListTitle;

    private boolean isExpand;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expandable_list_view);

        findIds();
        init();
        setListners();
    }

    private void findIds() {

        elvItems = (ExpandableListView) findViewById(R.id.elv_items);
    }

    private void init() {

        groupListDetail = ExpandableListDataPump.getData();

        groupListTitle = new ArrayList<>(groupListDetail.keySet());

        customExpandableListAdapter = new CustomExpandableListAdapter(getApplicationContext(), groupListTitle, groupListDetail);

        elvItems.setAdapter(customExpandableListAdapter);

    }

    private void setListners() {

        elvItems.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {
            @Override
            public void onGroupExpand(int groupPosition) {

                Toast.makeText(getApplicationContext(), groupListTitle.get(groupPosition) + " List Expanded.",
                        Toast.LENGTH_SHORT).show();

            }
        });

        elvItems.setOnGroupCollapseListener(new ExpandableListView.OnGroupCollapseListener() {
            @Override
            public void onGroupCollapse(int groupPosition) {

                Toast.makeText(getApplicationContext(), groupListTitle.get(groupPosition) + " List Collapsed.",
                        Toast.LENGTH_SHORT).show();

            }
        });

        elvItems.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {

                Toast.makeText(getApplicationContext(), groupListTitle.get(groupPosition)
                                + " -> "
                                + groupListDetail.get(groupListTitle.get(groupPosition)).get(childPosition),
                        Toast.LENGTH_SHORT).show();

                return false;
            }
        });

    }

}
