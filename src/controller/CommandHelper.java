package controller;

import controller.commandimpl.*;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Alexander on 23.02.2016.
 */
public class CommandHelper {
    private Map<CommandName, Command> commands = new HashMap<CommandName, Command>();

    public CommandHelper(){
        commands.put(CommandName.FIND_FILM_BY_ID, new FindFilmById());
        commands.put(CommandName.FIND_FILM_BY_TITLE, new FindFilmByTitle());
        commands.put(CommandName.GET_FILMS_COLLECTION, new GetFilmsCollection());
        commands.put(CommandName.GET_USERS_COLLECTION, new GetUsersCollection());
        commands.put(CommandName.ADD_NEW_FILM, new AddNewFilm());
        commands.put(CommandName.GET_USER_BY_ID, new FindUserById());
        commands.put(CommandName.REG_USER,new RegUser());
        commands.put(CommandName.UPDATE_USER, new UpdateUser());
        commands.put(CommandName.REMOVE_USER, new RemoveUser());
        commands.put(CommandName.UPDATE_FILM, new UpdateFilm());
        commands.put(CommandName.FIND_FILM_BY_DATE, new FindFilmsByDate());
        commands.put(CommandName.REMOVE_FILM, new RemoveFilm());
        commands.put(CommandName.GET_SEANCES_COLLECTION, new GetSeansesCollection());
        commands.put(CommandName.GET_SEANCES_BY_DATE, new GetSeancesByDate());
        commands.put(CommandName.GET_SEANCE_BY_ID, new GetSeanceById());
        commands.put(CommandName.UPDATE_SEANCE, new UpdateSeance());
        commands.put(CommandName.ADD_NEW_SEANCE,new AddNewSeance());
        commands.put(CommandName.ADD_SEANCE_FORM, new AddNewSeanceForm());
        commands.put(CommandName.REMOVE_SEANCE, new RemoveSeance());
        commands.put(CommandName.GET_TICKETS_COLLECTION, new GetTicketsCollection());
        commands.put(CommandName.REMOVE_TICKET, new RemoveTicket());
        commands.put(CommandName.FIND_TICKET_BY_ID, new FindTicketById());
    }

    public Command getCommand(CommandName commandName){
        return commands.get(commandName);
    }
}
