package com.kg.kettik.fragments.auth;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kg.kettik.R;
import com.kg.kettik.databinding.FragmentAuthBinding;
import com.kg.kettik.databinding.FragmentOnBoardBinding;


public class AuthFragment extends Fragment {

    private FragmentAuthBinding binding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding =  FragmentAuthBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.btnSend.setOnClickListener(v->{
            Navigation.findNavController(view).navigate(R.id.action_authFragment_to_authCodeFragment);
        });

    }
}