package bcccp.tickets.season;

public class UsageRecord implements IUsageRecord {
	
	String ticketId;
	long startDateTime; // start date and time of parking session
	long endDateTime;   // end date and time of parking session
	
	
	
	public UsageRecord(String ticketId, long startDateTime) {
		//TODO Implement constructor
		this.ticketId = ticketId;
		this.startDateTime = startDatetime;
		
	}



	@Override
	public void finalise(long endDateTime) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public long getStartTime() {
		// TODO Auto-generated method stub
		return 0;
	}



	@Override
	public long getEndTime() {
		// TODO Auto-generated method stub
		return 0;
	}



	@Override
	public String getSeasonTicketId() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
}
