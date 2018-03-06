package com.demo_expandable_list.pulkit.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.Toast;

import com.demo_expandable_list.pulkit.R;
import com.demo_expandable_list.pulkit.adapters.CustomAnimatedExpandableListAdapter;
import com.demo_expandable_list.pulkit.adapters.CustomExpandableListAdapter;
import com.demo_expandable_list.pulkit.animation.AnimatedExpandableListView;
import com.demo_expandable_list.pulkit.data.ExpandableListDataPump;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

    /*In this Example, I am not using any kind of library*/

public class AnimatedExpandableListViewActivity extends AppCompatActivity {

    private AnimatedExpandableListView animElvItems;

    private CustomAnimatedExpandableListAdapter customAnimatedExpandableListAdapter;

    private HashMap<String, List<String>> groupListDetail;
    private List<String> groupListTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animated_expandable_list_view);

        findIds();
        init();
        setListners();
    }

    private void findIds() {

        animElvItems = (AnimatedExpandableListView) findViewById(R.id.anim_elv_items);
    }

    private void init() {

        groupListDetail = ExpandableListDataPump.getData();

        groupListTitle = new ArrayList<>(groupListDetail.keySet());

        customAnimatedExpandableListAdapter = new CustomAnimatedExpandableListAdapter(getApplicationContext(),
                groupListTitle, groupListDetail);

        animElvItems.setAdapter(customAnimatedExpandableListAdapter);

    }

    private void setListners() {

        // In order to show animations, we need to use a custom click handler
        // for our ExpandableListView.
        animElvItems.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
            @Override
            public boolean onGroupClick(ExpandableListView parent, View v, int groupPosition, long id) {
                // We call collapseGroupWithAnimation(int) and
                // expandGroupWithAnimation(int) to animate group
                // expansion/collapse.

                if (animElvItems.isGroupExpanded(groupPosition)) {

                    animElvItems.collapseGroupWithAnimation(groupPosition);
                } else {
                    animElvItems.expandGroupWithAnimation(groupPosition);

                }

                return true;
            }
        });

        animElvItems.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {
            @Override
            public void onGroupExpand(int groupPosition) {

                Toast.makeText(getApplicationContext(), groupListTitle.get(groupPosition) + " List Expanded.",
                        Toast.LENGTH_SHORT).show();

            }
        });

        animElvItems.setOnGroupCollapseListener(new ExpandableListView.OnGroupCollapseListener() {
            @Override
            public void onGroupCollapse(int groupPosition) {

                Toast.makeText(getApplicationContext(), groupListTitle.get(groupPosition) + " List Collapsed.",
                        Toast.LENGTH_SHORT).show();

            }
        });

        animElvItems.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
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
