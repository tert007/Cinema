package dao;

import entity.film.Film;
import entity.seance.Seance;
import entity.ticket.Ticket;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Alexander on 30.04.2016.
 */
public interface SeanceDao {
    Seance findSeanceById(int id) throws DaoException;
    List<Seance> getTodaySeances() throws DaoException;
    List<Seance> findSeancesByDate(Date startDate, Date finishDate) throws DaoException;
    List<Seance> findSeancesByFilm(Film film) throws DaoException;
    List<Integer> getBusyPlaces(int seanceId)throws DaoException;

    boolean addNewSeance(Seance seance) throws DaoException;
    boolean removeSeanceById(int id) throws DaoException;
    boolean updateSeance(Seance newSeance) throws DaoException;
}
