package com.example.test.mvvmsampleapp.view.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.test.mvvmsampleapp.R;
import com.example.test.mvvmsampleapp.databinding.FragmentComicsBinding;
import com.example.test.mvvmsampleapp.databinding.FragmentProjectListBinding;
import com.example.test.mvvmsampleapp.di.Injectable;
import com.example.test.mvvmsampleapp.service.model.Comics;
import com.example.test.mvvmsampleapp.service.model.Project;
import com.example.test.mvvmsampleapp.view.adapter.ProjectAdapter;
import com.example.test.mvvmsampleapp.view.callback.ProjectClickCallback;
import com.example.test.mvvmsampleapp.viewmodel.ComicsViewModel;
import com.example.test.mvvmsampleapp.viewmodel.ProjectListViewModel;

import java.util.List;

import javax.inject.Inject;

import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

public class ComicsFragment extends Fragment implements Injectable {
    public static final String TAG = "ComicsFragment";

    // XML View to bind with
    private FragmentComicsBinding binding;

    @Inject
    ViewModelProvider.Factory viewModelFactory;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_comics,
                container, false);

        Comics comics = new Comics("Marvel Comics");
        binding.setComics(comics);

        return (View) binding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        final ComicsViewModel viewModel = ViewModelProviders.of(this,
                viewModelFactory).get(ComicsViewModel.class);

        observeViewModel(viewModel);
    }

    private void observeViewModel(ComicsViewModel viewModel) {
        // Update the list when the data changes
        viewModel.getObservable().observe(this, new Observer<Comics>() {
            @Override
            public void onChanged(Comics comics) {
                binding.setComics(comics);
            }
        });
    }

}
