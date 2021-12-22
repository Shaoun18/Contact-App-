package com.seip.android.contactappb1.adapters;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.seip.android.contactappb1.R;
import com.seip.android.contactappb1.models.MyContact;

import java.util.List;

public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.MyContactViewHolder> {
    private List<MyContact> contacts;

    public ContactAdapter(List<MyContact> contacts) {
        this.contacts = contacts;
    }

    @NonNull
    @Override
    public MyContactViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyContactViewHolder(
                LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.contact_row, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyContactViewHolder holder, int position) {
        holder.bind(contacts.get(position));
    }

    @Override
    public int getItemCount() {
        return contacts.size();
    }

    class MyContactViewHolder extends RecyclerView.ViewHolder {
        TextView nameTV;
        ImageView callBtn, smsBtn, emailBtn, infoBtn, mapBtn;
        public MyContactViewHolder(@NonNull View itemView) {
            super(itemView);
            nameTV = itemView.findViewById(R.id.rowContactName);
            callBtn = itemView.findViewById(R.id.rowCallBtn);
            smsBtn = itemView.findViewById(R.id.rowSmsBtn);
            emailBtn = itemView.findViewById(R.id.rowEmailBtn);
            infoBtn = itemView.findViewById(R.id.rowInfoBtn);
            mapBtn = itemView.findViewById(R.id.rowMapBtn);


            mapBtn.setOnClickListener(v -> {
                final int pos = getAdapterPosition();
                Toast.makeText(v.getContext(), contacts.get(pos).getMobile(), Toast.LENGTH_SHORT).show();
                final Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("geo:0,0?q="+contacts.get(pos).getAddress()));
                Intent chooser = Intent.createChooser(intent, "Which app do you want to open?");
                try{
                    v.getContext().startActivity(chooser);
                }catch (ActivityNotFoundException e) {
                    Toast.makeText(v.getContext(), e.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                }
            });

            callBtn.setOnClickListener(v -> {
                final int pos = getAdapterPosition();
                //Toast.makeText(v.getContext(), contacts.get(pos).getMobile(), Toast.LENGTH_SHORT).show();
                final Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:"+contacts.get(pos).getMobile()));
                Intent chooser = Intent.createChooser(intent, "Which app do you want to open?");
                try{
                    v.getContext().startActivity(chooser);
                }catch (ActivityNotFoundException e) {
                    Toast.makeText(v.getContext(), e.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                }
            });

            smsBtn.setOnClickListener(v -> {
                final int pos = getAdapterPosition();
                //Toast.makeText(v.getContext(), contacts.get(pos).getMobile(), Toast.LENGTH_SHORT).show();
                final Intent intent = new Intent(Intent.ACTION_SENDTO);
                intent.setData(Uri.parse("smsto:"+contacts.get(pos).getMobile()));
                intent.putExtra("sms_body", "hello brother");
                Intent chooser = Intent.createChooser(intent,
                        "Which app do you want to open?");

                try{
                    v.getContext().startActivity(chooser);
                }catch (ActivityNotFoundException e) {
                    Toast.makeText(v.getContext(), e.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                }
            });

            emailBtn.setOnClickListener(v -> {
                final int pos = getAdapterPosition();
                //Toast.makeText(v.getContext(), contacts.get(pos).getEmail(), Toast.LENGTH_SHORT).show();
                final Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("*/*");
                intent.putExtra(Intent.EXTRA_EMAIL,
                        new String[]{contacts.get(pos).getEmail()});
                intent.putExtra(Intent.EXTRA_SUBJECT, "test");
                Intent chooser = Intent.createChooser(intent,
                        "Which app do you want to open?");
                try{
                    v.getContext().startActivity(chooser);
                }catch (ActivityNotFoundException e) {
                    Toast.makeText(v.getContext(), e.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                }
            });

            infoBtn.setOnClickListener(v -> {
                final int pos = getAdapterPosition();

            });
        }

        public void bind(MyContact contact) {
            nameTV.setText(contact.getName());
        }
    }
}
