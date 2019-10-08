package com.example.test.mvvmsampleapp.view.ui.comics;

import android.app.Application;

import com.example.test.mvvmsampleapp.data.model.Comics;

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
