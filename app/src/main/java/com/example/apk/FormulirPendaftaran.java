package com.example.apk;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class FormulirPendaftaran extends Fragment {

    private EditText editTextName, editTextNim, editNomorTelepon;
    private RadioButton radioMale, radioFemale;
    private CheckBox checkBoxProgramming, checkBoxDesign, checkBoxGame;
    private Button buttonSubmit;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.forum_pedaftaran, container, false);

        // Inisialisasi elemen UI
        editTextName = view.findViewById(R.id.editTextName);
        editTextNim = view.findViewById(R.id.editTextNim);
        editNomorTelepon = view.findViewById(R.id.editNomorTelepon);
        radioMale = view.findViewById(R.id.radioMale);
        radioFemale = view.findViewById(R.id.radioFemale);
        checkBoxProgramming = view.findViewById(R.id.checkBoxProgramming);
        checkBoxDesign = view.findViewById(R.id.checkBoxDesign);
        checkBoxGame = view.findViewById(R.id.checkBoxGame);
        buttonSubmit = view.findViewById(R.id.buttonSubmit);

        buttonSubmit.setOnClickListener(v -> showDialog());

        return view;
    }

    private void showDialog() {
        String name = editTextName.getText().toString().trim();
        String nim = editTextNim.getText().toString().trim();
        String noTelepon = editNomorTelepon.getText().toString().trim();

        // Validasi input
        if (name.isEmpty() || nim.isEmpty() || noTelepon.isEmpty()) {
            AlertDialog.Builder builder = new AlertDialog.Builder(requireActivity());
            builder.setTitle("Error")
                    .setMessage("Silakan isi semua kolom.")
                    .setPositiveButton("OK", null)
                    .show();
            return;
        }

        String gender = radioMale.isChecked() ? "Laki-laki" : (radioFemale.isChecked() ? "Perempuan" : "Tidak ditentukan");
        StringBuilder skills = new StringBuilder();
        if (checkBoxProgramming.isChecked()) {
            skills.append("Pemrograman ");
        }
        if (checkBoxDesign.isChecked()) {
            skills.append("Desain ");
        }
        if (checkBoxGame.isChecked()) {
            skills.append("Game ");
        }

        // Menghapus spasi di akhir
        String skillsText = skills.toString().trim();

        AlertDialog.Builder builder = new AlertDialog.Builder(requireActivity());
        builder.setTitle("Data Masuk")
                .setMessage("Nama: " + name + "\nNIM: " + nim + "\nNo Telepon: " + noTelepon + "\nJenis Kelamin: " + gender + "\nKeahlian: " + skillsText)
                .setPositiveButton("OK", null)
                .show();
    }
}
