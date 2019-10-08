package com.example.test.mvvmsampleapp;

import com.example.test.mvvmsampleapp.di.ViewModelSubComponent;
import com.example.test.mvvmsampleapp.view.ui.comics.ComicsViewModel;
import com.example.test.mvvmsampleapp.view.ui.projects.ProjectViewModel;
import com.example.test.mvvmsampleapp.view.ui.projects_list.ProjectListViewModel;

import java.util.Map;
import java.util.concurrent.Callable;

import javax.inject.Inject;
import javax.inject.Singleton;

import androidx.collection.ArrayMap;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

@Singleton
public class ViewModelProviderFactory implements ViewModelProvider.Factory {
    private final ArrayMap<Class, Callable<? extends ViewModel>> creators;

    @Inject
    public ViewModelProviderFactory(ViewModelSubComponent viewModelSubComponent) {
        creators = new ArrayMap<>();

        // View models cannot be injected directly because they won't be bound
        // to the owner's view model scope.
        // add your view model classes here

        creators.put(ProjectViewModel.class, () -> viewModelSubComponent.projectViewModel());
        creators.put(ProjectListViewModel.class, () -> viewModelSubComponent.projectListViewModel());
        creators.put(ComicsViewModel.class, () -> viewModelSubComponent.comicsViewModel());
    }

    /*
     ** this method creates view models
     */
    @Override
    public <T extends ViewModel> T create(Class<T> modelClass) {
        Callable<? extends ViewModel> creator = creators.get(modelClass);
        if (creator == null) {
            for (Map.Entry<Class, Callable<? extends ViewModel>> entry : creators.entrySet()) {
                if (modelClass.isAssignableFrom(entry.getKey())) {
                    creator = entry.getValue();
                    break;
                }
            }
        }
        if (creator == null) {
            throw new IllegalArgumentException("Unknown model class " + modelClass);
        }
        try {
            return (T) creator.call();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}