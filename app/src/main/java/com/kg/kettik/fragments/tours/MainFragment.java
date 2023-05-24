package com.kg.kettik.fragments.tours;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kg.kettik.R;
import com.kg.kettik.databinding.FragmentMainBinding;
import com.kg.kettik.models.StaffsModel;
import com.kg.kettik.models.ToursModel;
import com.kg.kettik.network.RetrofitBuilder;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MainFragment extends Fragment implements OnItemClickListener {

    private FragmentMainBinding binding;
    private StaffsAdapter mAdapter;
    private ToursAdapter tAdapter;
    ArrayList<StaffsModel> list;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentMainBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        initToursAdapter();
        initStaffAdapter();
        listeners();
    }

    private void initToursAdapter() {
        tAdapter = new ToursAdapter(this);
        getResults();
        binding.rvTours.setLayoutManager(new LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false));
        binding.rvTours.setAdapter(tAdapter);
    }

    private void initStaffAdapter() {
        mAdapter = new StaffsAdapter();

        fakeData();

        binding.rvStaffs.setLayoutManager(new LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false));
        binding.rvStaffs.setAdapter(mAdapter);
    }

    private void getResults() {
        RetrofitBuilder.getInstance().getTours()
                .enqueue(new Callback<List<ToursModel>>() {
                    @Override
                    public void onResponse(@NonNull Call<List<ToursModel>> call, @NonNull Response<List<ToursModel>> response) {
                        Log.e("TAG", "onResponse: " + response.body());

                        tAdapter.addTours((ArrayList<ToursModel>) response.body());
                    }

                    @Override
                    public void onFailure(@NonNull Call<List<ToursModel>> call, @NonNull Throwable t) {
                        Log.e("TAG", "onFailure: " + t);

                    }
                });
    }

    private void fakeData() {
        list = new ArrayList<>();
        list.add(0, new StaffsModel("https://static.tildacdn.com/tild3064-3530-4330-a139-343566346235/noroot.png", "Aman"));
        list.add(1, new StaffsModel("https://static.tildacdn.com/tild6163-6636-4133-a361-346461383130/198240168_7784309463.jpg", "Tilek"));
        list.add(2, new StaffsModel("https://static.tildacdn.com/tild3431-3337-4636-b037-626264336566/304061638_309992377_.jpg", "Viktoriya"));

        mAdapter.addStaff(list);
    }

    @Override
    public void onItemClick(ToursModel model) {
        Bundle bundle = new Bundle();
        bundle.putInt("id", model.getId());
        Navigation.findNavController(requireView()).navigate(R.id.action_mainFragment_to_detailsFragment, bundle);
    }

    private void listeners() {
        binding.facebook.setOnClickListener(v -> {
            if (isAppInstalled(requireContext(), "com.facebook.orca") || isAppInstalled(requireContext(), "com.facebook.katana")
                    || isAppInstalled(requireContext(), "com.example.facebook") || isAppInstalled(requireContext(), "com.facebook.android")) {

                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("fb://profile/177722994355419")));
            } else {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/kettik.kg/")));
            }
        });

        binding.instagram.setOnClickListener(v -> {
            try {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("https://www.instagram.com/kettik.kg/"));
                intent.setPackage("com.instagram.android");
                startActivity(intent);
            } catch (ActivityNotFoundException anfe) {
                startActivity(new Intent(Intent.ACTION_VIEW,
                        Uri.parse("https://www.instagram.com/kettik.kg/")));
            }
        });

        binding.twitter.setOnClickListener(v -> {
            try {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("https://twitter.com/kettikco"));
                intent.setPackage("com.twitter.android");
                startActivity(intent);
            } catch (ActivityNotFoundException anfe) {
                startActivity(new Intent(Intent.ACTION_VIEW,
                        Uri.parse("https://twitter.com/kettikco")));
            }
        });

    }

    public static boolean isAppInstalled(Context context, String packageName) {
        try {
            context.getPackageManager().getApplicationInfo(packageName, 0);
            return true;
        } catch (PackageManager.NameNotFoundException e) {
            return false;
        }
    }
}