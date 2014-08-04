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
		for (int j = 0; j < waitingClients.size(); j++) {
			clients++;
			totalWaitTime += waitingClients.get(j).getExpectedServiceTime();
		}
		return totalWaitTime / clients;
	}

	@Override
	public double getClientWaitTime(Client client) {
		int totalWaitTime = 0;
		for (int i = 0; i < tellers; i++) {
			totalWaitTime += waitingClients.get(i).getExpectedServiceTime();
			if (waitingClients.get(i) == client) {
				return totalWaitTime;
			}
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
