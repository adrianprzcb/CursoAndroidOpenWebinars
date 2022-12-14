package com.example.dialogfragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.dialogfragment.databinding.FragmentFirstBinding;

public class FirstFragment extends Fragment  {

    private FragmentFirstBinding binding;
    DialogFragment dialogoNuevaAveria;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentFirstBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.buttonFirst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(FirstFragment.this)
                        .navigate(R.id.action_FirstFragment_to_SecondFragment);
            }
        });
    }

    public void clickado(View view){
        dialogoNuevaAveria = new NuevaAveriaDialogo();
        dialogoNuevaAveria.show(getFragmentManager(),"NuevaAveriaDialogo");

    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}