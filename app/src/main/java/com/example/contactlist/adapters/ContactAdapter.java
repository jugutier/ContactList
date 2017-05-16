package com.example.contactlist.adapters;

import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.contactlist.DetailActivity;
import com.example.contactlist.R;
import com.example.contactlist.model.Contact;
import com.example.contactlist.network.images.NetworkImage;

@SuppressWarnings({"WeakerAccess" , "unused"})
public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.ViewHolder> {
  private List<Contact> values;
  private Context context;
  private NetworkImage networkImage;

  public class ViewHolder extends RecyclerView.ViewHolder {
    private TextView firstLine;
    private TextView secondLine;
    private ImageView contactImage;
    public View layout;

    public ViewHolder(View v) {
      super(v);
      layout = v;
      firstLine = (TextView) v.findViewById(R.id.firstLine);
      secondLine = (TextView) v.findViewById(R.id.secondLine);
      contactImage = (ImageView) v.findViewById(R.id.contactImage);
    }
  }

  public void add(int position, Contact contact) {
    values.add(position, contact);
    notifyItemInserted(position);
  }

  public void remove(int position) {
    values.remove(position);
    notifyItemRemoved(position);
  }

  public ContactAdapter(List<Contact> dataSource, Context ctx) {
    values = dataSource;
    context = ctx;
    networkImage = new NetworkImage(context);
  }

  @Override
  public ContactAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                 int viewType) {
    LayoutInflater inflater = LayoutInflater.from(
        parent.getContext());
    View v =
        inflater.inflate(R.layout.row_layout, parent, false);
    return new ViewHolder(v);
  }

  @Override
  public void onBindViewHolder(ViewHolder holder, int position) {
    final Contact contact = values.get(position);
    holder.firstLine.setText(contact.getName());
    holder.firstLine.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        final Intent intent = new Intent(context , DetailActivity.class);
        intent.putExtra(Contact.KEY, contact.getId());
        context.startActivity(intent);
        ((Activity) context).overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
      }
    });

    holder.secondLine.setText(contact.getPosition());

    networkImage.getImageAsync(contact.getImage_url() , holder.contactImage);

  }

  @Override
  public int getItemCount() {
    return values.size();
  }

}
