package ru.cobalt.telegram.clone.frw;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentActivity;

import ru.cobalt.telegram.clone.BasicFragment;
import ru.cobalt.telegram.clone.R;

public class EnterPhoneFragment extends BasicFragment implements View.OnClickListener {

    private AppCompatEditText inputPhoneNumber;

    public EnterPhoneFragment() {
        super(R.layout.fragment_enter_phone);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        inputPhoneNumber = view.findViewById(R.id.frw_input_phone_number);

        showKeyboard(view, inputPhoneNumber);

        Toolbar toolbar = view.findViewById(R.id.toolbar);
        AppCompatTextView title = view.findViewById(R.id.toolbar_title);
        title.setText(getString(R.string.frw_enter_phone_toolbar_title));

        FragmentActivity activity = getActivity();
        if (activity != null) {
            ((AppCompatActivity) activity).setSupportActionBar(toolbar);
        }

        view.findViewById(R.id.frw_button_next).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.frw_button_next:
                changeFragment(new ConfirmPhoneFragment());
                break;
        }
    }
}
