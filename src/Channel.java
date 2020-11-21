import java.util.*;

public class Channel implements Subject {

	private ArrayList<Observer> observers = new ArrayList<Observer>();
	private String channelName;
	private String status;

	public Channel(String channelName, String status) {
		this.channelName = channelName;
		this.status = status;
	}

	public String getChannelName() {
		return channelName;
	}

	public void setChannelName(String channelName) {
		this.channelName = channelName;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
		notifyObservers();
	}

	@Override
	public void notifyObservers() {
		for (Observer obs : observers) {
			obs.update(this.status);
		}
	}

	@Override
	public void registerObserver(Observer obs) {
		observers.add(obs);
	}

	@Override
	public void removeObserver(Observer obs) {
		observers.remove(obs);
	}

}
