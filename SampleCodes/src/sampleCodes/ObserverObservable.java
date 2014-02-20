package sampleCodes;

import java.util.Observable;
import java.util.Observer;

class Event extends Observable{
	String type;
	
	public void setType(String type)
	{
		this.type = type;
		setChanged();
		notifyObservers(type);
	}

}

class Athlets implements Observer{

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		System.out.println("Update called"+o.getClass().getName());
	}
	
}

public class ObserverObservable {

	public static void main(String[] args) {
		Event e = new Event();
		e.addObserver(new Athlets());
		e.setType("400");
		
		
	}
}
