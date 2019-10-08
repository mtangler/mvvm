package com.example.test.mvvmsampleapp.view.ui.projects_list;

import android.app.Application;

import com.example.test.mvvmsampleapp.data.model.Project;
import com.example.test.mvvmsampleapp.data.remote.repo.ProjectRepository;

import java.util.List;

import javax.inject.Inject;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

public class ProjectListViewModel extends AndroidViewModel {
    private final LiveData<List<Project>> projectListObservable;

    @Inject
    public ProjectListViewModel(@NonNull ProjectRepository projectRepository, @NonNull Application application) {
        super(application);

        // If any transformation is needed, this can be simply done by Transformations class ...
        projectListObservable = projectRepository.getProjectList("Google");
    }

    /**
     * Expose the LiveData Projects query so the UI can observe it.
     */
    public LiveData<List<Project>> getProjectListObservable() {
        return projectListObservable;
    }
}
