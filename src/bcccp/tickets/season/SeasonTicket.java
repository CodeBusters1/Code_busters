package bcccp.tickets.season;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SeasonTicket implements ISeasonTicket {
	
	private List<IUsageRecord> usages;
	private IUsageRecord currentUsage = null;
	
	private String ticketId;
	private String carparkId;
	private long startValidPeriod;
	private long endValidPeriod;
	
	public SeasonTicket (String ticketId, 
			             String carparkId, 
			             long startValidPeriod,
			             long endValidPeriod) {
		//TDO Implement constructor
		this.carparkId=carparkId;
		this.startValidPeriod=startValidPeriod;
		this.endValidPeriod=endValidPeriod;
	}

	@Override
	public String getId() {
	// TODO Auto-generated method stub
		If(ticketId=SeasonTicketId)
		{
		print("Season Ticket Is Inserted.Go Ahead");
		else
		print("Not a Valid Ticket");
		return null;
		}
	}

	@Override
	public String getCarparkId() {
	// TODO Auto-generated method stub
	If 
		return null;
	}

	@Override
	public long getStartValidPeriod() {
		// TODO Auto-generated method stub
		
		return 0;
	}

	@Override
	public long getEndValidPeriod() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean inUse() {
		// TODO Auto-generated method stub
		If (carparkId = NULL)
 		{
		return true;
		print("Available");
		else
		return false;
		print("Is In Use");
	}

	@Override
	public void recordUsage(IUsageRecord record) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public IUsageRecord getCurrentUsageRecord() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void endUsage(long dateTime) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<IUsageRecord> getUsageRecords() {
		// TODO Auto-generated method stub
		return null;
	}


}
