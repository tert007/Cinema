package controller.commandimpl;

import controller.Command;
import controller.CommandException;
import controller.PageHelper;
import controller.PageName;
import dao.DaoFactory;
import entity.film.Film;
import entity.film.FilmGenre;


import javax.servlet.http.HttpServletRequest;
import java.sql.Date;

/**
 * Created by Alexander on 27.04.2016.
 */
public class AddNewFilm implements Command {
    @Override
    public String execute(HttpServletRequest request) throws CommandException {
        DaoFactory daoFactory = DaoFactory.getDaoFactory();
        try {
            String title = request.getParameter("title");
            String description = request.getParameter("description");
            int genre = Integer.parseInt(request.getParameter("genre"));
            String date = request.getParameter("date");
            String director = request.getParameter("director");
            int ageLimitation = Integer.parseInt(request.getParameter("age_limitation"));
            FilmGenre filmGenre = daoFactory.getFilmGenreDao().findFilmGenreById(genre);


            Film film = new Film();
            film.setTitle(title);
            film.setDescription(description);
            film.setGenre(filmGenre);
            film.setDate(Date.valueOf(date));
            film.setDirector(director);
            film.setAgeLimitationId(ageLimitation);

            daoFactory.getFilmDao().addNewFilm(film);
            PageHelper pageHelper = new PageHelper();
            return pageHelper.getPage(PageName.SUCCESS_UPDATE_PAGE);
        } catch (Exception ex){
            return null;
        }
    }
}
