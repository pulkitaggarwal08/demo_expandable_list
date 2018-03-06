package com.demo_expandable_list.pulkit.adapters;

import android.content.Context;
import android.graphics.Typeface;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.demo_expandable_list.pulkit.R;
import com.demo_expandable_list.pulkit.animation.AnimatedExpandableListView;

import java.util.HashMap;
import java.util.List;

/**
 * Created by pulkit on 10/1/18.
 */

public class CustomAnimatedExpandableListAdapter extends AnimatedExpandableListView.AnimatedExpandableListAdapter {

    private final String TAG = CustomExpandableListAdapter.class.getName();

    private Context context;
    private List<String> groupListTitle;
    private HashMap<String, List<String>> groupListDetail;

    private TextView tvGroupTitle, tvChildTitle;
    private ImageView ivArrowRight;

    public CustomAnimatedExpandableListAdapter(Context context, List<String> groupListTitle,
                                       HashMap<String, List<String>> groupListDetail) {
        this.context = context;
        this.groupListTitle = groupListTitle;
        this.groupListDetail = groupListDetail;
    }

    @Override
    public int getGroupCount() {

        Log.i(TAG, "getGroupCount: " + groupListDetail.size());

        return groupListDetail.size();
    }

//    @Override
//    public int getChildrenCount(int groupPosition) {
//
//        Log.i(TAG, "getChildrenCount: " + groupListDetail.get(groupListTitle.get(groupPosition)).size());
//
//        return groupListDetail.get(groupListTitle.get(groupPosition)).size();
//    }

    @Override
    public Object getGroup(int groupPosition) {

        Log.i(TAG, "getGroup: " + groupListTitle.get(groupPosition));
        return groupListTitle.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {

        Log.i(TAG, "getChild: " + groupListDetail.get(groupListTitle.get(groupPosition)).get(childPosition));

        return groupListDetail.get(groupListTitle.get(groupPosition)).get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {

        Log.i(TAG, "getGroupId: " + groupPosition);

        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {

        Log.i(TAG, "getGroupId: " + groupPosition + ", " + childPosition);

        return childPosition;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {

        String groupList = (String) getGroup(groupPosition);

        if (convertView == null) {
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.list_group, null, false);
        }

        /*Find Group Items Ids*/
        findGroupIds(convertView);

        tvGroupTitle.setTypeface(null, Typeface.BOLD);
        tvGroupTitle.setText(groupList);

        if (isExpanded) {
            ivArrowRight.setImageResource(R.drawable.ic_arrow_down);

        }
        else {
            ivArrowRight.setImageResource(R.drawable.ic_arrow_right);

        }

        return convertView;
    }

    @Override
    public View getRealChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        String childList = (String) getChild(groupPosition, childPosition);

        if (convertView == null) {
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.list_child, null, false);

        }

        /*Find Child Items Ids*/
        findChildIds(convertView);
        tvChildTitle.setText(childList);


        return convertView;
    }

    @Override
    public int getRealChildrenCount(int groupPosition) {

        Log.i(TAG, "getChildrenCount: " + groupListDetail.get(groupListTitle.get(groupPosition)).size());

        return groupListDetail.get(groupListTitle.get(groupPosition)).size();

    }

//    @Override
//    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
//
//        String childList = (String) getChild(groupPosition, childPosition);
//
//        if (convertView == null) {
//            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//            convertView = layoutInflater.inflate(R.layout.list_child, null, false);
//
//        }
//
//        /*Find Child Items Ids*/
//        findChildIds(convertView);
//        tvChildTitle.setText(childList);
//
//
//        return convertView;
//    }

    private void findGroupIds(View convertView) {

        tvGroupTitle = (TextView) convertView.findViewById(R.id.group_title);
        ivArrowRight = (ImageView) convertView.findViewById(R.id.iv_arrow_right);

    }

    private void findChildIds(View convertView) {

        tvChildTitle = (TextView) convertView.findViewById(R.id.child_title);
    }

    @Override
    public boolean hasStableIds() {

        return false;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {

        return false;
    }


}
