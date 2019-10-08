package com.example.test.mvvmsampleapp.viewmodel;

import android.app.Application;

import com.example.test.mvvmsampleapp.service.model.Comics;
import com.example.test.mvvmsampleapp.service.model.Project;
import com.example.test.mvvmsampleapp.service.repository.ProjectRepository;

import java.util.List;

import javax.inject.Inject;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

public class ComicsViewModel extends AndroidViewModel {
    private final LiveData<Comics> comicsLiveData;

    @Inject
    public ComicsViewModel(@NonNull Application application) {
        super(application);

        final MutableLiveData<Comics> data = new MutableLiveData<>();
        data.setValue(new Comics("Marvel DC Comics"));
        comicsLiveData = data;
    }

    /**
     * Expose the LiveData query so the UI can observe it.
     */
    public LiveData<Comics> getObservable() {
        return comicsLiveData;
    }
}
