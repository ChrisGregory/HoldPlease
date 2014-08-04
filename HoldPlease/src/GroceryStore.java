import java.util.*;

public class GroceryStore implements QueueableService {
	
	List<ArrayList<Client>> lines;
	int cashiers;
	
	public GroceryStore(int numberOfCashiers){
		this.cashiers = numberOfCashiers;
		lines = new LinkedList<LinkedList<Client>>;
		for(int i = 0; i < numberOfCashiers; i++){
			lines.add(new LinkedList<Client>(Client.class, 1));
		}
	}
	
	@Override
	public double getAverageClientWaitTime() {
		int clients = 0;
		int totalWaitTime = 0;
		for(int i = 0; i < cashiers; i++){
			for(int j = 0; j < lines.get(i).size(); j++){
				clients++;
				totalWaitTime += lines.get(i).get(j).getExpectedServiceTime();
			}
		}
		return totalWaitTime/clients;
	}

	@Override
	public double getClientWaitTime(Client client) {
		for(int i = 0; i < cashiers; i++){
			int totalWaitTime = 0;
			for(int j = 0; j < lines.get(i).size(); j++){
				totalWaitTime += lines.get(i).get(j).getExpectedServiceTime();
				if(lines.get(i).get(j) == client){
					return totalWaitTime;
				}
			}
		}
		return 0;
	}

	@Override
	public boolean addClient(Client client) {
		int shortestLineIndex = 0;
		int shortestLineTime = Integer.MAX_VALUE;
		for(int i = 0; i < cashiers; i++){
			int currentLineTime = 0;
			for(int j = 0; j < lines.get(i).size(); j++){
				currentLineTime += lines.get(i).get(j).getExpectedServiceTime();
			}
			if(currentLineTime < shortestLineTime){
				shortestLineTime = currentLineTime;
				shortestLineIndex = i;
			}
		}
		lines.get(shortestLineIndex).add(client);
		return true;
	}

	@Override
	public void advanceMinute() {
		for(int i = 0; i < cashiers; i++){
			int currentLineTime = 0;
			lines.get(i).get(0).servedMinute();
			if(lines.get(i).get(0).getExpectedServiceTime() <= 0){
				lines.get(i).remove(lines.get(i).get(0));
			}
		}
	}
}
