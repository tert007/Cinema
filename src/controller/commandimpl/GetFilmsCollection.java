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
 * Created by Alexander on 02.04.2016.
 */
public class GetFilmsCollection implements Command {
    @Override
    public String execute(HttpServletRequest request) throws CommandException {
        DaoFactory daoFactory = DaoFactory.getDaoFactory();
        try {
            List<Film> films = daoFactory.getFilmDao().getFilmsCollection();
            request.setAttribute("films", films);

            return PageHelper.getPage(PageName.FILMS_PAGE);
        } catch (DaoException e){
            throw new CommandException(e);
        }
    }
}
