package sonatasomething.thesecond;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import java.util.HashMap;
import java.util.List;

public class Skills_Adapter1 extends BaseExpandableListAdapter {
    private Context ctx;
    private HashMap<String,List<String>> Skills_Category;
    private List<String> Skills_List;
   private int arg0;

    public Skills_Adapter1(Context ctx1, HashMap<String, List<String>> Skills_Category1, List<String> Skills_List1)
    {
        ctx=ctx1;
        Skills_Category= Skills_Category1;
        Skills_List=Skills_List1;
    }

    @Override
    public int getGroupCount() {
        return Skills_List.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        int[] arg;
        return Skills_Category.get(Skills_List.get(groupPosition)).size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        //int[] arg;
        return Skills_List.get(groupPosition);
    }

    @Override
    public Object getChild(int parent, int child) {
        return Skills_Category.get(Skills_List.get(parent)).get(child);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int parent, int child) {
        return child;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int parent, boolean isExpanded, View convertview, ViewGroup parentview) {
        String group_title = (String)getGroup(parent);
        if(convertview==null)
        {
            LayoutInflater inflator = (LayoutInflater)ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertview=inflator.inflate(R.layout.parent_layout,parentview,false);
        }
        TextView parent_textview= (TextView) convertview.findViewById(R.id.parent_textView);
        parent_textview.setTypeface(null, Typeface.BOLD);
        parent_textview.setText(group_title);
        return convertview;

    }

    @Override
    public View getChildView(int parent, int child, boolean lastChild, View convertview, ViewGroup parentview) {
        String child_title = (String)getChild(parent,child);
        if(convertview==null)
        {
            LayoutInflater inflator = (LayoutInflater)ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertview=inflator.inflate(R.layout.child_layout,parentview,false);
        }
        TextView child_textview= (TextView) convertview.findViewById(R.id.child_textView);
        child_textview.setText(child_title);

        return convertview;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return false;
    }
}
