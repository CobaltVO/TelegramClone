package ru.cobalt.telegram.clone.main.nav.contacts;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import ru.cobalt.telegram.clone.R;

public class ContactsAdapter extends RecyclerView.Adapter<ContactViewHolder> {

    private final ArrayList<ContactListItem> listContacts;

    public ContactsAdapter(ArrayList<ContactListItem> listContacts) {
        this.listContacts = listContacts;
    }

    @NonNull
    @Override
    public ContactViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View item = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.contact_list_item, parent, false);
        return new ContactViewHolder(item);
    }

    @Override
    public void onBindViewHolder(@NonNull ContactViewHolder holder, int position) {
        ContactListItem contact = listContacts.get(position);

        holder.getUserName().setText(contact.getUserName());
        holder.getStatus().setText(contact.getStatus());
        holder.getPhoto().setImageResource(contact.getPhotoRes());
    }

    @Override
    public int getItemCount() {
        return listContacts.size();
    }

}
