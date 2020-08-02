package ru.cobalt.telegram.clone.frw;

import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatEditText;

import ru.cobalt.telegram.clone.BasicFragment;
import ru.cobalt.telegram.clone.R;

public class EnterPhoneFragment extends BasicFragment implements View.OnClickListener {

    private AppCompatEditText inputCountryCode;
    private AppCompatEditText inputPhoneNumber;

    public EnterPhoneFragment() {
        super(R.layout.fragment_enter_phone);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        inputCountryCode = view.findViewById(R.id.frw_input_country_code);
        inputPhoneNumber = view.findViewById(R.id.frw_input_phone_number);
        showKeyboard(view, inputPhoneNumber);
        setToolbarName(view, getString(R.string.frw_enter_phone_toolbar_title));
        view.findViewById(R.id.frw_button_next).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.frw_button_next:
                String phone = getUserPhone();
                if (phone != null) {
                    changeFragment(new ConfirmPhoneFragment(phone), null);
                } else {
                    Toast.makeText(
                            getActivity(),
                            "To continue you should enter valid phone",
                            Toast.LENGTH_SHORT
                    ).show();
                }
                break;
        }
    }

    @Nullable
    public String getUserPhone() {
        String code, phone;

        Editable t = inputCountryCode.getText();
        if (t == null) return null;
        code = t.toString();
        if (code.equals("")) return null;

        t = inputPhoneNumber.getText();
        if (t == null) return null;
        phone = t.toString();
        if (phone.equals("")) return null;

        return code + phone;
    }
}
