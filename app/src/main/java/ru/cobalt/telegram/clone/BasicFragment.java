package ru.cobalt.telegram.clone;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public abstract class BasicFragment extends Fragment {

    private final int layout;

    public BasicFragment(int layoutId) {
        layout = layoutId;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(layout, container, false);
    }

    protected void changeFragment(Fragment newFragment) {
        FragmentManager fragmentManager = getFragmentManager();
        if (fragmentManager != null) {
            FragmentTransaction transaction = fragmentManager.beginTransaction()
                    .replace(R.id.main_container, newFragment)
                    .addToBackStack(null);
            transaction.commit();
        }
    }

    protected void showKeyboard(@NonNull View fragmentView, View editTextView) {
        editTextView.requestFocus();

        InputMethodManager imm = (InputMethodManager) fragmentView.getContext()
                .getSystemService(Context.INPUT_METHOD_SERVICE);
        if (imm != null) {
            imm.showSoftInput(editTextView, InputMethodManager.SHOW_IMPLICIT);
        }
    }
}
