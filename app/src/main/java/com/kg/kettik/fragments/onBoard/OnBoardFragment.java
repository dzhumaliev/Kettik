package com.kg.kettik.fragments.onBoard;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kg.kettik.R;
import com.kg.kettik.databinding.FragmentOnBoardBinding;
import com.kg.kettik.models.OnBoardModel;

import java.util.ArrayList;

import me.relex.circleindicator.CircleIndicator3;


public class OnBoardFragment extends Fragment {

    private SampleRecyclerAdapter mAdapter;
    ArrayList<OnBoardModel> list;
    private FragmentOnBoardBinding binding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentOnBoardBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        mAdapter = new SampleRecyclerAdapter();

        ViewPager2 viewpager = view.findViewById(R.id.viewpager);
        viewpager.setAdapter(mAdapter);

        fakeData();
        // CircleIndicator3 for RecyclerView
        CircleIndicator3 indicator = view.findViewById(R.id.indicator);
        indicator.setViewPager(viewpager);

        // CurrentItem
        viewpager.setCurrentItem(0, false);

        // Observe Data Change
        mAdapter.registerAdapterDataObserver(indicator.getAdapterDataObserver());

        binding.tvSkip.setOnClickListener(v -> {
            Navigation.findNavController(view).navigate(R.id.action_onBoardFragment_to_mainFragment);
        });
    }


    private void fakeData() {
        list = new ArrayList<>();
        list.add(0, new OnBoardModel("Nature of Kyrgyzstan: Uncovering a Mystery", "Kyrgyzstan’s nature and environment is one of the main reasons to visit the country. 94% of Kyrgyzstan is covered by mountains, which means that there are ample opportunities for trekking and hiking, or just for relaxing in nature.", "https://thumb.tildacdn.com/tild3535-6636-4436-b737-623836313539/-/format/webp/236079525_8349339207.jpg"));
        list.add(1, new OnBoardModel("Language", "Kyrgyz language, also spelled Kirgiz, or Kirghiz, member of the Turkic subfamily of Altaic languages. It is spoken in Kyrgyzstan and in the Pamir Mountains on the border between Tajikistan, Afghanistan, and China. ", "https://thumb.tildacdn.com/tild6539-3736-4636-a131-306536323634/-/format/webp/IMG_24454.jpg"));
        list.add(2, new OnBoardModel("Culture", "Kyrgyz culture is closely connected with nomadism in everyday life with holidays, crafts, music and cuisine. The nomadic life and livestock culture are based primarily on the animals and what tending and harvesting from them require during different seasons of the year.", "https://thumb.tildacdn.com/tild3031-6336-4465-a663-303736626636/-/format/webp/217410294_1840045470.jpg"));

        mAdapter.createScreen(list);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}