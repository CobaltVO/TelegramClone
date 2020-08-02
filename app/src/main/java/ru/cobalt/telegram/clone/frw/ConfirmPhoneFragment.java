package ru.cobalt.telegram.clone.frw;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatEditText;

import java.util.Objects;

import ru.cobalt.telegram.clone.BasicFragment;
import ru.cobalt.telegram.clone.R;
import ru.cobalt.telegram.clone.main.MainFragment;

public class ConfirmPhoneFragment extends BasicFragment implements CodeInputCompletedListener {

    private AppCompatEditText num1, num2, num3, num4, num5;

    public ConfirmPhoneFragment() {
        super(R.layout.fragment_confirm_phone);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        num1 = view.findViewById(R.id.frw_confirm_phone_input_code_first_number);
        num2 = view.findViewById(R.id.frw_confirm_phone_input_code_second_number);
        num3 = view.findViewById(R.id.frw_confirm_phone_input_code_third_number);
        num4 = view.findViewById(R.id.frw_confirm_phone_input_code_fourth_number);
        num5 = view.findViewById(R.id.frw_confirm_phone_input_code_fifth_number);

        num1.addTextChangedListener(new CodeInputWatcher(num2, this));
        num2.addTextChangedListener(new CodeInputWatcher(num3, this));
        num3.addTextChangedListener(new CodeInputWatcher(num4, this));
        num4.addTextChangedListener(new CodeInputWatcher(num5, this));
        num5.addTextChangedListener(new CodeInputWatcher(null, this));

        showKeyboard(view, num1);
        setToolbarName(view, getString(R.string.frw_confirm_phone_toolbar_title));
        addBackButtonToToolbar(view).setNavigationOnClickListener(v -> goToPreviousFragment());
    }

    @Override
    public void onCodeInputCompleted() {
        String s1 = Objects.requireNonNull(num1.getText()).toString();
        String s2 = Objects.requireNonNull(num2.getText()).toString();
        String s3 = Objects.requireNonNull(num3.getText()).toString();
        String s4 = Objects.requireNonNull(num4.getText()).toString();
        String s5 = Objects.requireNonNull(num5.getText()).toString();

        if (!s1.equals("") || !s2.equals("") || !s3.equals("") || !s4.equals("") || !s5.equals("")) {
            int code = Integer.parseInt(s1 + s2 + s3 + s4 + s5);
            if (code == 12345) {
                changeFragment(new MainFragment());
            }
        }
    }


}
