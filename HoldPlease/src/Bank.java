public class Bank implements QueueableService {

	int tellers;
	List<Client> waitingClients = new ArrayList<Client>(Client.class, 1);
	List<Client> servingClients = new ArrayList<Client>(Client.class, 1);

	public Bank(int numberOfTellers) {
		this.tellers = numberOfTellers;
	}

	@Override
	public double getAverageClientWaitTime() {
		int clients = 0;
		int totalWaitTime = 0;
		for (int j = 0; j < servingClients.size(); j++) {
			clients++;
			totalWaitTime += servingClients.get(j).getExpectedServiceTime();
		}
		for (int j = 0; j < waitingClients.size(); j++) {
			clients++;
			totalWaitTime += waitingClients.get(j).getExpectedServiceTime();
		}
		return totalWaitTime / clients;
	}

	@Override
	public double getClientWaitTime(Client client) {
		int totalWaitTime = 0;
		int[] times = new int[tellers];
		for (int i = 0; i < tellers; i++) {
			times[i] = servingClients.get(i).getExpectedServiceTime();
		}
		for (int i = 0; i < waitingClients.size(); i++)
		{
			if(client == waitingClients.get(i)){
				return totalWaitTime;
			}
			int smallestLine = 0;
			for(int j = 0; j < servingClients.size(); j++){
				if(times[j] < times[smallestLine])
				{
					smallestLine = j;
				}
			}
			times[smallestLine] += waitingClients.get(i).getExpectedServiceTime();
			
		}
		return 0;
	}

	@Override
	public boolean addClient(Client client) {
		waitingClients.add(client);
		return true;
	}

	@Override
	public void advanceMinute() {
		for (int i = 0; i < tellers; i++) {
			servingClients.get(i).servedMinute();
		}
		for (int i = 0; i < tellers; i++) {
			if (servingClients.get(i).getExpectedServiceTime() <= 0) {
				servingClients.remove(servingClients.get(i));
				if (waitingClients.size() < 0) {
					servingClients.add(waitingClients.get(0));
					waitingClients.remove(waitingClients.get(0));
				}
			}
		}
	}
}
