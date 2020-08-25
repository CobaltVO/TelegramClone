package ru.cobalt.telegram.clone.main.nav;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import ru.cobalt.telegram.clone.BasicFragment;
import ru.cobalt.telegram.clone.R;
import ru.cobalt.telegram.clone.main.nav.contacts.ContactListItem;
import ru.cobalt.telegram.clone.main.nav.contacts.ContactsAdapter;

public class ChatsFragment extends BasicFragment {

    public ChatsFragment() {
        super(R.layout.fragment_chats);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());

        RecyclerView recyclerView = view.findViewById(R.id.chats_start_contacts_list);
        recyclerView.setAdapter(new ContactsAdapter(getDummyContacts()));
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(layoutManager);
    }

    private ArrayList<ContactListItem> getDummyContacts() {
        ArrayList<ContactListItem> out = new ArrayList<>();
        out.add(new ContactListItem("Dummy", "online", R.drawable.ic_app));
        out.add(new ContactListItem("Ivan", "last seen recently", R.drawable.ic_app));
        out.add(new ContactListItem("Useless cat", "last seen at 12:00", R.drawable.ic_app));
        return out;
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.chats_menu, menu);
    }
}