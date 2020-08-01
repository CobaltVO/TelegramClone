package ru.cobalt.telegram.clone.frw;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatEditText;

import ru.cobalt.telegram.clone.BasicFragment;
import ru.cobalt.telegram.clone.R;

public class ConfirmPhoneFragment extends BasicFragment {

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

        num1.addTextChangedListener(new CodeWatcher(num2));
        num2.addTextChangedListener(new CodeWatcher(num3));
        num3.addTextChangedListener(new CodeWatcher(num4));
        num4.addTextChangedListener(new CodeWatcher(num5));
        num5.addTextChangedListener(new CodeWatcher(null));

        showKeyboard(view, num1);
    }
}
