package ru.cobalt.telegram.clone.frw;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.AppCompatTextView;

import java.util.Objects;

import ru.cobalt.telegram.clone.BasicFragment;
import ru.cobalt.telegram.clone.R;
import ru.cobalt.telegram.clone.main.MainActivity;

public class ConfirmPhoneFragment extends BasicFragment
        implements CodeInputCompletedListener, View.OnKeyListener {

    private final String KEY_USER_PHONE = "keyUserPhone";

    private int[] listNumbersId = {
            R.id.frw_confirm_phone_input_code_first_number,
            R.id.frw_confirm_phone_input_code_second_number,
            R.id.frw_confirm_phone_input_code_third_number,
            R.id.frw_confirm_phone_input_code_fourth_number,
            R.id.frw_confirm_phone_input_code_fifth_number
    };
    private AppCompatEditText[] listEditTexts = new AppCompatEditText[listNumbersId.length];

    private AppCompatTextView textViewPhoneNumber;
    private String userPhone;

    public ConfirmPhoneFragment() {
        super(R.layout.fragment_confirm_phone);
    }

    public ConfirmPhoneFragment(String phone) {
        super(R.layout.fragment_confirm_phone);
        userPhone = phone;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        textViewPhoneNumber = view.findViewById(R.id.frw_confirm_phone_number);
        if (savedInstanceState != null) {
            userPhone = savedInstanceState.getString(KEY_USER_PHONE);
        }
        if (userPhone != null) {
            textViewPhoneNumber.setText(userPhone);
        }

        for (int i = 0; i < listNumbersId.length; i++) {
            listEditTexts[i] = view.findViewById(listNumbersId[i]);
            listEditTexts[i].setOnKeyListener(this);
        }

        for (int i = 0; i < listNumbersId.length; i++) {
            if (i != listNumbersId.length - 1) {
                listEditTexts[i].addTextChangedListener(
                        new CodeInputWatcher(listEditTexts[i + 1], this));
            } else {
                listEditTexts[i].addTextChangedListener(
                        new CodeInputWatcher(null, this));
            }
        }

        showKeyboard(view, listEditTexts[0]);
        setToolbarName(view, getString(R.string.frw_confirm_phone_toolbar_title));
        addBackButtonToToolbar(view).setNavigationOnClickListener(v -> goToPreviousFragment());
    }

    @Override
    public void onCodeInputCompleted() {
        String[] numbers = new String[listEditTexts.length];
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < listEditTexts.length; i++) {
            numbers[i] = Objects.requireNonNull(listEditTexts[i].getText()).toString();
        }

        for (String s : numbers) {
            if (s.equals("")) return;
            sb.append(s);
        }

        int code = Integer.parseInt(sb.toString());
        if (code == 12345) {
            Activity activity = getActivity();
            if (activity != null) activity.finish();
            startActivity(new Intent(getActivity(), MainActivity.class));
        }
    }

    @Override
    public boolean onKey(View v, int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_DEL && event.getAction() == KeyEvent.ACTION_DOWN) {
            for (int i = 0; i < listEditTexts.length; i++) {
                if (listEditTexts[i].length() == 0) {
                    if (i > 0) {
                        listEditTexts[i - 1].setText("");
                        listEditTexts[i - 1].requestFocus();
                    }
                    break;
                }
            }
        }
        return false;
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        outState.putString(KEY_USER_PHONE, userPhone);
        super.onSaveInstanceState(outState);
    }
}
