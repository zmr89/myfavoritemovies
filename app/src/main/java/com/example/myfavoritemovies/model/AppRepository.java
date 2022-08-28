package com.example.myfavoritemovies.model;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.List;

public class AppRepository {

    private GenreDAO genreDAO;
    private MovieDAO movieDAO;

    private LiveData<List<Genre>> genres;
    private LiveData<List<Movie>> movies;

    public AppRepository(Application application) {
        MoviesDatabase database = MoviesDatabase.getInstance(application);
        genreDAO = database.getGenreDAO();
        movieDAO = database.getMovieDAO();
    }

    public LiveData<List<Genre>> getGenres(){
        return genreDAO.getAllGenres();
    }

    public LiveData<List<Movie>> getGenreMovies(int genreId){
        return movieDAO.getAllMovies(genreId);
    }

    public void insertGenre(Genre genre){
        new InsertGenreAsyncTask(genreDAO).execute(genre);
    }

    private static class InsertGenreAsyncTask extends AsyncTask<Genre, Void, Void>{

        private GenreDAO genreDAO;

        public InsertGenreAsyncTask(GenreDAO genreDAO) {
            this.genreDAO = genreDAO;
        }

        @Override
        protected Void doInBackground(Genre... genres) {
            genreDAO.insert(genres[0]);
            return null;
        }
    }

    public void insertMovie(Movie movie){
        new InsertMovieAsyncTask(movieDAO).execute(movie);
    }

    private static class InsertMovieAsyncTask extends AsyncTask<Movie, Void, Void> {

        private MovieDAO movieDAO;

        public InsertMovieAsyncTask(MovieDAO movieDAO) {
            this.movieDAO = movieDAO;
        }

        @Override
        protected Void doInBackground(Movie... movies) {
            movieDAO.insert(movies[0]);
            return null;
        }
    }



    public void updateGenre(Genre genre){
        new UpdateGenreAsyncTask(genreDAO).execute(genre);
    }

    private static class UpdateGenreAsyncTask extends AsyncTask<Genre, Void, Void>{

        private GenreDAO genreDAO;

        public UpdateGenreAsyncTask(GenreDAO genreDAO) {
            this.genreDAO = genreDAO;
        }

        @Override
        protected Void doInBackground(Genre... genres) {
            genreDAO.update(genres[0]);
            return null;
        }
    }

    public void updateMovie(Movie movie){
        new UpdateMovieAsyncTask(movieDAO).execute(movie);
    }

    private static class UpdateMovieAsyncTask extends AsyncTask<Movie, Void, Void> {

        private MovieDAO movieDAO;

        public UpdateMovieAsyncTask(MovieDAO movieDAO) {
            this.movieDAO = movieDAO;
        }

        @Override
        protected Void doInBackground(Movie... movies) {
            movieDAO.update(movies[0]);
            return null;
        }
    }



    public void deleteGenre(Genre genre){
        new DeleteGenreAsyncTask(genreDAO).execute(genre);
    }

    private static class DeleteGenreAsyncTask extends AsyncTask<Genre, Void, Void>{

        private GenreDAO genreDAO;

        public DeleteGenreAsyncTask(GenreDAO genreDAO) {
            this.genreDAO = genreDAO;
        }

        @Override
        protected Void doInBackground(Genre... genres) {
            genreDAO.delete(genres[0]);
            return null;
        }
    }

    public void deleteMovie(Movie movie){
        new DeleteMovieAsyncTask(movieDAO).execute(movie);
    }

    private static class DeleteMovieAsyncTask extends AsyncTask<Movie, Void, Void> {

        private MovieDAO movieDAO;

        public DeleteMovieAsyncTask(MovieDAO movieDAO) {
            this.movieDAO = movieDAO;
        }

        @Override
        protected Void doInBackground(Movie... movies) {
            movieDAO.delete(movies[0]);
            return null;
        }
    }
}
