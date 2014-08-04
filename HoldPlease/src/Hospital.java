import java.util.Iterator;


public class Hospital implements QueueableService{

	PriorityQueue<Client> waitingRoomPatients;
	Client[] treatingPatients;
	public Hospital(int numberOfDoctors){
		treatingPatients = new Client[numberOfDoctors];
		waitingRoomPatients = new PriorityQueue<Client>();
	}
	
	@Override
	public double getAverageClientWaitTime() {
		int people = 0;
		int totalTime = 0;
		int result = 0;
		Iterator<Client> iter = waitingRoomPatients.iterator();
		totalTime += waitingRoomPatients.firstItem.value.getExpectedServiceTime();
		for(int i = 1; i < waitingRoomPatients.length(); i++){
			totalTime += iter.next().getExpectedServiceTime();
		}
		return 0;
	}

	@Override
	public double getClientWaitTime(Client client) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean addClient(Client client) {
		waitingRoomPatients.offer(client);
		return true;
	}

	@Override
	public void advanceMinute() {
		
	}

}
