package com.example.test.mvvmsampleapp.di;

import android.app.Application;

import com.example.test.mvvmsampleapp.MVVMApplication;
import com.example.test.mvvmsampleapp.di.builder.MainActivityModule;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjectionModule;

@Singleton
@Component(modules = {
        AndroidInjectionModule.class,
        AppModule.class,
        MainActivityModule.class
})
public interface AppComponent {
    @Component.Builder
    interface Builder {
        @BindsInstance
        Builder application(Application application);

        AppComponent build();
    }

    void inject(MVVMApplication mvvmApplication);
}
