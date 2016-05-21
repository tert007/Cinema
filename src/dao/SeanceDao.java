package dao;

import entity.seance.Seance;

import java.util.Date;
import java.util.List;

/**
 * Created by Alexander on 30.04.2016.
 */
public interface SeanceDao {
    Seance findSeanceById(int id) throws DaoException;
    List<Seance> getTodaySeances() throws DaoException;
    List<Seance> findSeancesByDate(Date startDate, Date finishDate) throws DaoException;

    boolean addNewSeance(Seance seance) throws DaoException;
    boolean removeSeanceById(int id) throws DaoException;
    boolean updateSeance(Seance newSeance) throws DaoException;
}
