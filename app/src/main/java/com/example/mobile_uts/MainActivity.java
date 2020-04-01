package com.example.mobile_uts;

import android.content.Intent;
import android.os.Bundle;

import com.example.mobile_uts.Adapters.FightAdapter;
import com.example.mobile_uts.Models.Account;
import com.example.mobile_uts.Models.Fight;
import com.example.mobile_uts.Models.Session;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Handler;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements FightAdapter.OnItemFightListener{
    private static final String FIGHT = "fights";
    public static final String INDEX_KEY = "INDEX";
    public static final int INSERT_REQUEST = 1;
    public static final int UPDATE_REQUEST = 2;

    private FightAdapter adapter;
    private Account account;
    private RecyclerView fightView;
    private Session session;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //TODO session
        session = Application.getSession();
        if (!session.isLoggedIn()) {
            Intent intent = new Intent(this, LoginActivity.class);
            startActivity(intent);
            finish();
        }


        fightView = findViewById(R.id.recyclerView);

        //TODO event fab
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, IsiDataActivity.class);
                intent.putExtra(FIGHT, new Fight());
                startActivityForResult(intent, INSERT_REQUEST);
            }
        });

        //TODO Set Adapter
        account = Application.getAccount();
        adapter= new FightAdapter(account.getFights(), this);
        fightView.setAdapter(adapter);

        //TODO Set Recycler View
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        fightView.setLayoutManager(layoutManager);

        ItemTouchHelper.SimpleCallback simpleItemTouchCallback = new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                int index = viewHolder.getAdapterPosition();
                account.removeFight(index);
                adapter.notifyDataSetChanged();
            }
        };
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(simpleItemTouchCallback);
        itemTouchHelper.attachToRecyclerView(fightView);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //Logika Settings
        Intent intent = new Intent(this, SettingsActivity.class);
        startActivity(intent);

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }else if (id == R.id.action_logout) {
            session.logout();
            Intent intent2 = new Intent(this, LoginActivity.class);
            startActivity(intent2);
            finish();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onFightClicked(int index, Fight item) {
        Intent intent = new Intent(this, IsiDataActivity.class);
        intent.putExtra(FIGHT, item);
        //diganti index
        intent.putExtra(INDEX_KEY,index);
        startActivityForResult(intent, UPDATE_REQUEST);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK){
            Fight fight = data.getParcelableExtra(FIGHT);
            if (requestCode == INSERT_REQUEST){
                account.addFight(fight);

            }else if (requestCode == UPDATE_REQUEST){
                int index = data.getIntExtra(INDEX_KEY,0);
                account.updateFight(index, fight);
            }
            adapter.notifyDataSetChanged();
        }
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}
