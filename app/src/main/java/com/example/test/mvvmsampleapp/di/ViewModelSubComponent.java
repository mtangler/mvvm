package com.example.test.mvvmsampleapp.di;

import com.example.test.mvvmsampleapp.ViewModelProviderFactory;
import com.example.test.mvvmsampleapp.view.ui.comics.ComicsViewModel;
import com.example.test.mvvmsampleapp.view.ui.projects.ProjectViewModel;
import com.example.test.mvvmsampleapp.view.ui.projects_list.ProjectListViewModel;

import dagger.Subcomponent;

/**
 * A sub component to create ViewModels. It is called by the
 * {@link ViewModelProviderFactory}.
 */
@Subcomponent
public interface ViewModelSubComponent {
    @Subcomponent.Builder
    interface Builder {
        ViewModelSubComponent build();
    }

    ProjectListViewModel projectListViewModel();

    ProjectViewModel projectViewModel();

    ComicsViewModel comicsViewModel();
}
