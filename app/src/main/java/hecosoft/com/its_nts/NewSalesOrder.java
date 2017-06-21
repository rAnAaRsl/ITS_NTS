package hecosoft.com.its_nts;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class NewSalesOrder extends NavigationDrawer {
AutoCompleteTextView name;
    EditText id1;
    Spinner ship;
    String[] country = {"Pakistan", "India", "Uk", "China"};
    ArrayAdapter<String> countryListAdapter;
    ArrayAdapter<String> auto;
    Button net;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LayoutInflater inflater = (LayoutInflater) this.getSystemService(getApplicationContext().LAYOUT_INFLATER_SERVICE);

        //inflate your activity layout here!
        View contentView = inflater.inflate(R.layout.activity_new_sales_order, null, false);
        drawerLayout.addView(contentView, 0);

txt.setVisibility(View.INVISIBLE);
        img.setVisibility(View.INVISIBLE);
        name=(AutoCompleteTextView)findViewById(R.id.nameautocmplete);
        id1=(EditText)findViewById(R.id.showid);
        id1.setText("");
        name.setText("");
        net=(Button)findViewById(R.id.nextbtn);
        ship=(Spinner)findViewById(R.id.spinnershipto);
        //Intent i=getIntent();
        //Bundle b=i.getExtras();
        //String n=b.getString("uname");
        countryListAdapter = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, country);
        auto=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,country);
        name.setAdapter(auto);
        ship.setAdapter(countryListAdapter);
        name.setThreshold(1);
        name.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String s = (String) parent.getItemAtPosition(position);
                id1.setText(s);
            }
        });
        net.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    String a=name.getText().toString();
                if (a.equals("")) {
                    Log.d("Check","In if");

                                     Toast.makeText(getApplicationContext(),"Please specify the Customer Name First",Toast.LENGTH_LONG).show();

                } else {
                      Intent i = new Intent(NewSalesOrder.this, SalesOrder2.class);
                      startActivity(i);
                }
            } });
    }


}
