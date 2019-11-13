package com.example.todomvvm;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import com.example.todomvvm.database.AppDatabase;
import com.example.todomvvm.database.Todo;
import com.example.todomvvm.database.TodoDao;

import java.util.List;

public class TodoRepository {

    private TodoDao todoDao;
    private LiveData<List<Todo>> mAllTodos;

    TodoRepository(Application application) {
        AppDatabase db = AppDatabase.getInstance(application);
        todoDao = db.todoDao();
        mAllTodos = todoDao.getAllTodos();
    }

    LiveData<List<Todo>> getAllWords() {
        return mAllTodos;
    }

    public void insert(final Todo todo) {
        AppExecutors.getInstance().diskIO().execute(new Runnable() {
            @Override
            public void run() {
                todoDao.insertTodo(todo);
            }
        });
    }

    public void delete(final Todo todo) {
        AppExecutors.getInstance().diskIO().execute(new Runnable() {
            @Override
            public void run() {
                todoDao.deleteTodo(todo);
            }
        });
    }

    public void update(final Todo todo) {
        AppExecutors.getInstance().diskIO().execute(new Runnable() {
            @Override
            public void run() {
                todoDao.update(todo);
            }
        });
    }

    public void deleteAll() {
        new deleteAllWordsAsyncTask(todoDao).execute();
    }

    private static class deleteAllWordsAsyncTask extends AsyncTask<Void, Void, Void> {
        private TodoDao mAsyncTaskDao;

        deleteAllWordsAsyncTask(TodoDao dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            mAsyncTaskDao.deleteAll();
            return null;
        }


    }
}
