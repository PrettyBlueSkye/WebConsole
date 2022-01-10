package es.mesacarlos.webconsole.auth;

import java.net.InetSocketAddress;
import java.util.ArrayList;

public class LoginManager {
	private ArrayList<ConnectedUser> loggedInUsers = new ArrayList<>();
	private static LoginManager instance;
	
	private LoginManager() {}
	
	public static LoginManager getInstance() {
		if(instance == null)
			instance = new LoginManager();
		return instance;
	}
	
	/**
	 * Logs user in
	 * @param user User to login
	 */
	public void logIn(ConnectedUser user) {
		loggedInUsers.add(user);
	}
	
	/**
	 * Logs user out
	 * @param address User to logout
	 */
	public void logOut(String address) {
		loggedInUsers.removeIf(user -> user.getAddress().equals(address));
	}
	
	/**
	 * Get user object by socket
	 * @param address socket of the user
	 * @return User object, null if no user logged in from that address
	 */
	public ConnectedUser getUser(String address) {
		for(ConnectedUser user : loggedInUsers)
			if(user.getAddress().equals(address))
				return user;
		return null;
	}
	
	/**
	 * Check if user is logged in. It checks that both the socket adress and the user token corresponds to a logged in user.
	 * @param address User to check
	 * @return true if user is logged in, false otherwise
	 */
	public boolean isLoggedIn(String address, String token) {
		for(ConnectedUser user : loggedInUsers)
			if(user.getAddress().equals(address) && user.getToken().equals(token))
				return true;
		return false;
	}
	
	/**
	 * Check if an user is logged in from a given socket address
	 * @param address User to check
	 * @return true if user is logged in, false otherwise
	 */
	public boolean isAddressConnected(String address) {
		for(ConnectedUser user : loggedInUsers)
			if(user.getAddress().equals(address))
				return true;
		return false;
	}
	
	/**
	 * Retrieve the full logged-in user list
	 * @return list of logged in users
	 */
	public ArrayList<ConnectedUser> getLoggedInUsers() {
		return loggedInUsers;
	}
	
}