package com.kg.kettik.fragments.toursDetail;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;
import com.kg.kettik.databinding.FragmentDetialsBinding;
import com.kg.kettik.models.ToursDetailModel;
import com.kg.kettik.network.RetrofitBuilder;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class DetailsFragment extends Fragment {

    private FragmentDetialsBinding binding;
    private ScheduleAdapter mAdapter;
    ArrayList<SlideModel> imageList = new ArrayList<>();


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentDetialsBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initAdapter();
        getResults();
    }

    private void initAdapter() {
        mAdapter = new ScheduleAdapter();

        binding.rvScheduleInfo.setLayoutManager(new LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false));
        binding.rvScheduleInfo.setAdapter(mAdapter);
    }

    private void getResults() {
        if (getArguments() != null) {
            RetrofitBuilder.getInstance().getToursById(getArguments().getInt("id"))
                    .enqueue(new Callback<ToursDetailModel>() {
                        @Override
                        public void onResponse(@NonNull Call<ToursDetailModel> call, @NonNull Response<ToursDetailModel> response) {
                            Log.e("TAG", "onResponse: " + response.body().getTitle());
                            setResults(response.body());

                        }

                        @Override
                        public void onFailure(@NonNull Call<ToursDetailModel> call, @NonNull Throwable t) {
                            Log.e("TAG", "onFailure: " + t);

                        }
                    });
        }
    }

    private void setResults(ToursDetailModel body) {

        imageList.add(0, new SlideModel(body.getImage(), ScaleTypes.FIT));
        imageList.add(1, new SlideModel(body.getImage2(), ScaleTypes.FIT));
        imageList.add(2, new SlideModel(body.getImage3(), ScaleTypes.FIT));
        imageList.add(3, new SlideModel(body.getImage4(), ScaleTypes.FIT));

        binding.ivDetail.setImageList(imageList, ScaleTypes.CENTER_CROP);

        mAdapter.addSchedule(body.getBringCharacteristics());


        binding.toolbar.tvBack.setText(body.getTitle());

        binding.tvTitleImageDetail.setText(body.getPrice());
        binding.tvTitleDetail.setText(body.getMiniTitle());
        binding.tvDescDetail.setText(body.getFullDescription());

        binding.toolbar.ivBack.setOnClickListener(v -> {
            NavController navController = new NavController(requireContext());
            if (!navController.popBackStack()) {
                requireActivity().onBackPressed();
            }
        });

        binding.btnOrder.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_DIAL);
            intent.setData(Uri.parse("tel:+996500023120"));
            startActivity(intent);
        });

    }
}