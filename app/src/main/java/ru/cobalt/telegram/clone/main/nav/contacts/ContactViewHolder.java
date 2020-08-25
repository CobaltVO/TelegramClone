package ru.cobalt.telegram.clone.main.nav.contacts;

import android.view.View;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;

import ru.cobalt.telegram.clone.R;

class ContactViewHolder extends RecyclerView.ViewHolder {

    private AppCompatTextView userName, status;
    private ImageView photo;

    public ContactViewHolder(@NonNull View itemView) {
        super(itemView);

        userName = itemView.findViewById(R.id.contact_list_item_user_name);
        status = itemView.findViewById(R.id.contact_list_item_user_status);
        photo = itemView.findViewById(R.id.contact_list_item_user_photo);
    }

    public AppCompatTextView getUserName() {
        return userName;
    }

    public AppCompatTextView getStatus() {
        return status;
    }

    public ImageView getPhoto() {
        return photo;
    }

}
