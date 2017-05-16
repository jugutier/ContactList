package com.example.contactlist.network.api;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;


import com.example.contactlist.model.Contact;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.InputStreamReader;
import java.util.List;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

@RunWith(AndroidJUnit4.class)
public class DatasourceInstrumentedTest {

  private Context appContext;

  @Before
  public void createAppContext() {
    appContext = InstrumentationRegistry.getTargetContext();
  }

  @Test
  public void datasource_usesAppContext() throws Exception {
    assertEquals("com.example.contactlist", appContext.getPackageName());
  }

  @Test
  public void datasource_canAccessLocalJson() throws Exception {
    Datasource ds = new Datasource(appContext);
    InputStreamReader isr = ds.getRawReader();
    assertThat(isr, is(notNullValue()));
  }

  @Test
  public void datasource_canParseWithGson() throws Exception {
    Datasource ds = new Datasource(appContext);
    ContactRepository contactRepository = new ContactRepository(ds);
    List<Contact> contacts = contactRepository.getAllContacts();
    assertThat(contacts.size(), is(14));
  }
}
