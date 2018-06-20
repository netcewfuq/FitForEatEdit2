package fitforeat.fitforeat_2;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;


public class ReportList_1 extends BaseAdapter {

    //Explicit
    private Context objContext;
    private String[] nameCalStrings, dateStrings, numCalString, CalString;
    private int[] iconInts;


    public ReportList_1(Context objContext, String[] nameCalStrings, String[] dateStrings, String[] numCalString, String[] CalString) {
        this.objContext = objContext;
        this.nameCalStrings = nameCalStrings;
        this.dateStrings = dateStrings;
        this.numCalString = numCalString;
        this.CalString = CalString;


    }   // Constructor

    @Override
    public int getCount() {
        return nameCalStrings.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        LayoutInflater objLayoutInflater = (LayoutInflater) objContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View objView1 = objLayoutInflater.inflate(R.layout.report_list_1, viewGroup, false);

        //Setup Title
        TextView nameTextView = (TextView) objView1.findViewById(R.id.namelist);
        nameTextView.setText(nameCalStrings[i]);

        //Setup Detail
        TextView dateTextView = (TextView) objView1.findViewById(R.id.idlist);
        dateTextView.setText(dateStrings[i]);

        TextView numTextView = (TextView) objView1.findViewById(R.id.numlist);
        numTextView.setText(numCalString[i]);

        TextView calTextView = (TextView) objView1.findViewById(R.id.callist);
        calTextView.setText(CalString[i]);


        return objView1;
    }
}   // Main Class
