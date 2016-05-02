package controller.commandimpl;

import controller.Command;
import controller.CommandException;
import controller.PageHelper;
import controller.PageName;
import dao.DaoException;
import dao.DaoFactory;
import entity.film.Film;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by Vadim on 04.04.2016.
 */
public class FindFilmById implements Command {
    @Override
    public String execute(HttpServletRequest request) throws CommandException {

        int filmId = Integer.valueOf(request.getParameter("film_id"));

        DaoFactory daoFactory = DaoFactory.getDaoFactory();
        try {
            Film film = daoFactory.getFilmDao().findFilmById(filmId);
            request.setAttribute("film", film);

            return PageHelper.getPage(PageName.FILM_BY_ID_PAGE);
        } catch (DaoException e){
            throw new CommandException(e);
        }
    }
}
