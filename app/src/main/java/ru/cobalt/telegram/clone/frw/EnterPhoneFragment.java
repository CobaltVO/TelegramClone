package ru.cobalt.telegram.clone.frw;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentActivity;

import ru.cobalt.telegram.clone.BasicFragment;
import ru.cobalt.telegram.clone.R;

public class EnterPhoneFragment extends BasicFragment {

    public EnterPhoneFragment() {
        super(R.layout.fragment_enter_phone);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        EditText inputPhoneNumber = view.findViewById(R.id.frw_input_phone_number);
        inputPhoneNumber.requestFocus();

        InputMethodManager imm = (InputMethodManager) view.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
        if (imm != null) {
            imm.showSoftInput(inputPhoneNumber, InputMethodManager.SHOW_IMPLICIT);
        }

        Toolbar toolbar = view.findViewById(R.id.toolbar);
        TextView title = view.findViewById(R.id.toolbar_title);
        title.setText("Your phone");

        FragmentActivity activity = getActivity();
        if (activity != null) {
            ((AppCompatActivity) activity).setSupportActionBar(toolbar);
        }
    }
}
