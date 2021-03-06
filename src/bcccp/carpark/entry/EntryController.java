package bcccp.carpark.entry;

import bcccp.carpark.Carpark;
import bcccp.carpark.ICarSensor;
import bcccp.carpark.ICarSensorResponder;
import bcccp.carpark.ICarpark;
import bcccp.carpark.ICarparkObserver;
import bcccp.carpark.IGate;
import bcccp.tickets.adhoc.IAdhocTicket;

public class EntryController 
		implements ICarSensorResponder,
				   ICarparkObserver,
		           IEntryController {
	private static EntryController instance;
	public static EntryController getInstance(){
		return instance;
	}
	
	
	private IGate entryGate;
	private ICarSensor outsideSensor; 
	private ICarSensor insideSensor;
	private IEntryUI ui;
	
	private ICarpark carpark;
	private IAdhocTicket  adhocTicket = null;
	private long entryTime;
	private String seasonTicketId = null;
	
	
	//Constructor implementation
	public EntryController(Carpark carpark, IGate entryGate, 
			ICarSensor os, 
			ICarSensor is,
			IEntryUI ui) {
		this.carpark=carpark;
		this.entryGate=entryGate;
		this.outsideSensor=os;
		this.insideSensor=is;
		this.ui=ui;
		this.instance=this;
	}



	@Override
	public void buttonPushed() {
		//Check if the carpark is full
		if(this.carpark.isFull()){
		this.ui.display("Car is full");
		}else{
		this.adhocTicket=this.carpark.issueAdhocTicket();//adhoc ticket issue
		this.ui.display("Take Ticket");//display message Take Ticket in user interface
		this.ui.printTicket(this.adhocTicket.getCarparkId(),this.adhocTicket.getTicketNo(),new Date().getTime(),this.adhocTicket.getBarCode());
		this.adhocTicket.enter(new Date().getTime());
		}
		System.out.println("Issuing Adhoc ticket");
	}



	@Override
	public void ticketInserted(String barcode) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void ticketTaken() {
		//adhoc ticket customer takes the ticket for which the barrier should be raised now.
		if(!this.carpark.isFull()){
		this.entryGate.raise();
		this.ui.display("Carpark isnot full");
		this.ui.beep();
		}
		
	}



	@Override
	public void notifyCarparkEvent() {
		// TODO Auto-generated method stub
		
	}


	//Both the outside and inside method call this method when detecting a car
	@Override
	public void carEventDetected(String detectorId, boolean detected) {
	//if the outside sensor detects the car, show push button. else, lower the barrier
		if(detectorId==this.outsideSensor.getId()){
			if(detected){
				//Display push button on the screen
				this.ui.display("PUSH BUTTON");
			}else{
				this.ui.display("");
			}
		}else{
			//If the outside sensor detects the car, lower the barrier and reset the screen
			this.entryGate.lower();
			//Starting to count time
			entryTime=new Date().getTime();
		}
		
		
		
	}

	
	
}
