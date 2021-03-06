package com.test.projectv3;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.test.projectv3.LotteryActivities.LotteryDecember_16_2560;
import com.test.projectv3.LotteryActivities.LotteryDecember_1_2560;
import com.test.projectv3.LotteryActivities.LotteryDecember_30_2560;


public class LotteriesActivity extends AppCompatActivity {

    //Navigator
    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle toggle;


    //ListView
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lotteries);

        //Toggle
        drawerLayout = (DrawerLayout)findViewById(R.id.des);
        toggle = new ActionBarDrawerToggle(this,drawerLayout,R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        NavigationView navigationView = (NavigationView)findViewById(R.id.nv);

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case(R.id.nav_checkLotto):
                        Intent n1 = new Intent(getApplicationContext(), LotteriesActivity.class);
                        startActivity(n1);
                        break;

                    case(R.id.nav_mode1):
                        Intent n2 = new Intent(getApplicationContext(), ModeSimulatePurchaseActivity.class);
                        startActivity(n2);
                        break;

                    case(R.id.nav_mode2):
                        Intent n3 = new Intent(getApplicationContext(), ModePurchase.class);
                        startActivity(n3);
                        break;

                    case(R.id.nav_static1):
                        Intent n4 = new Intent(getApplicationContext(), StaticSimulatePurchase.class);
                        startActivity(n4);
                        break;

                    case(R.id.nav_static2):
                        Intent n5 = new Intent(getApplicationContext(), StaticPurchase.class);
                        startActivity(n5);
                        break;

                }
                return true;
            }
        });


        //ListView
        listView = (ListView) findViewById(R.id.listView);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(LotteriesActivity.this,
                android.R.layout.simple_list_item_1,
                getResources().getStringArray(R.array.lotteries));

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                switch (position){
                    case 0:
                        Intent i0 = new Intent(LotteriesActivity.this, LotteryDecember_30_2560.class);
                        startActivity(i0);
                        break;

                    case 1:
                        Intent i1 = new Intent(LotteriesActivity.this , LotteryDecember_16_2560.class);
                        startActivity(i1);
                        break;

                    case 2:
                        Intent i2 = new Intent(LotteriesActivity.this , LotteryDecember_1_2560.class);
                        startActivity(i2);
                        break;
                }
            }
        });
        listView.setAdapter(adapter);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.check,menu);
        return super.onCreateOptionsMenu(menu);
    }

    //Toggle
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(toggle.onOptionsItemSelected(item)){
            return true;
        } switch (item.getItemId()){
            case R.id.nav_checkLotto:
                Intent b = new Intent(this,CheckLotteryActivity.class);
                startActivity(b);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    //Menu
    /*@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.check,menu);
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.nav_checkLotto:
                Intent b = new Intent(this,CheckLotteryActivity.class);
                startActivity(b);
                break;
        }
        return super.onOptionsItemSelected(item);
    }*/
}
