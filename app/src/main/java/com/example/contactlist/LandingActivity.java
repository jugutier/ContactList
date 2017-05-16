package com.example.contactlist;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.example.contactlist.adapters.ContactAdapter;
import com.example.contactlist.model.Contact;
import com.example.contactlist.network.api.ContactRepository;
import com.example.contactlist.network.api.Datasource;

import java.util.ArrayList;
import java.util.List;

public class LandingActivity extends AppCompatActivity {
  private RecyclerView recyclerView;
  private ContactAdapter adapter;
  private RecyclerView.LayoutManager layoutManager;
  private static ContactRepository repository;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_landing);
    Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
    setSupportActionBar(toolbar);

    repository = new ContactRepository(new Datasource(this));
    recyclerView = (RecyclerView) findViewById(R.id.contacts_recycler_view);
    recyclerView.setHasFixedSize(true);
    layoutManager = new LinearLayoutManager(this);
    recyclerView.setLayoutManager(layoutManager);
    recyclerView.setItemAnimator(new DefaultItemAnimator());
    RecyclerView.ItemDecoration itemDecoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
    recyclerView.addItemDecoration(itemDecoration);

    adapter = new ContactAdapter(stubbedValues(), this);
    recyclerView.setAdapter(adapter);
  }

  private List<Contact> stubbedValues() {
    return repository.getAllContacts();
  }

  public static ContactRepository getContactRepository() {
    return repository;
  }

  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    getMenuInflater().inflate(R.menu.menu_landing, menu);
    return true;
  }

  @Override
  public boolean onOptionsItemSelected(MenuItem item) {
    int id = item.getItemId();
    return (id == R.id.action_settings) || super.onOptionsItemSelected(item);
  }
}
