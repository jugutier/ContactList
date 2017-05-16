package com.example.contactlist;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.contactlist.model.Contact;
import com.example.contactlist.network.api.ContactRepository;
import com.example.contactlist.network.images.NetworkImage;

public class DetailActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.contact_detail);
    Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
    setSupportActionBar(toolbar);
    String contactId = getIntent().getStringExtra(Contact.KEY);
    Contact contact = new ContactRepository(this).getContactById(contactId);
    Log.d("DetailActivity", "Retrieved contact id is = " + contact);

    TextView line1 = (TextView) findViewById(R.id.firstLine);
    line1.setText(contact.getName());
    TextView line2 = (TextView) findViewById(R.id.secondLine);
    line2.setText(contact.getPosition());

    ImageView imageView = (ImageView) findViewById(R.id.contactImage);
    new NetworkImage(this).getImageAsync(contact.getImage_url(), imageView);

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
