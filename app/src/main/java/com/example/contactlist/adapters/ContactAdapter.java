package com.example.contactlist.adapters;

import java.util.List;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.contactlist.R;

@SuppressWarnings("WeakerAccess")
public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.ViewHolder> {
  private List<String> values;

  public class ViewHolder extends RecyclerView.ViewHolder {
    private TextView firstLine;
    private TextView secondLine;
    public View layout;

    public ViewHolder(View v) {
      super(v);
      layout = v;
      firstLine = (TextView) v.findViewById(R.id.firstLine);
      secondLine = (TextView) v.findViewById(R.id.secondLine);
    }
  }

  public void add(int position, String item) {
    values.add(position, item);
    notifyItemInserted(position);
  }

  public void remove(int position) {
    values.remove(position);
    notifyItemRemoved(position);
  }

  public ContactAdapter(List<String> dataSource) {
    values = dataSource;
  }

  @Override
  public ContactAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                 int viewType) {
    LayoutInflater inflater = LayoutInflater.from(
        parent.getContext());
    View v =
        inflater.inflate(R.layout.row_layout, parent, false);
    ViewHolder vh = new ViewHolder(v);
    return vh;
  }

  @Override
  public void onBindViewHolder(ViewHolder holder, final int position) {
    final String name = values.get(position);
    holder.firstLine.setText(name);
    holder.firstLine.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        remove(position);
      }
    });

    holder.secondLine.setText("Footer: " + name);
  }

  @Override
  public int getItemCount() {
    return values.size();
  }

}
