package com.example.test.mvvmsampleapp.di.builder;

import com.example.test.mvvmsampleapp.view.ui.comics.ComicsFragment;
import com.example.test.mvvmsampleapp.view.ui.projects.ProjectFragment;
import com.example.test.mvvmsampleapp.view.ui.projects_list.ProjectListFragment;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class FragmentBuildersModule {
    @ContributesAndroidInjector
    abstract ProjectFragment contributeProjectFragment();

    @ContributesAndroidInjector
    abstract ProjectListFragment contributeProjectListFragment();

    @ContributesAndroidInjector
    abstract ComicsFragment contributeComicsFragment();
}
