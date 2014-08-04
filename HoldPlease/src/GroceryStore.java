import java.util.*;

public class GroceryStore implements QueueableService {
	
	List<Client>[] lines;
	int cashiers;
	
	public GroceryStore(int numberOfCashiers){
		this.cashiers = numberOfCashiers;
		lines = new List[cashiers];
		for(int i = 0; i < numberOfCashiers; i++){
			lines[i] = new ArrayList<Client>(Client.class, 1);
		}
	}
	
	//theta(n^2)
	@Override
	public double getAverageClientWaitTime() {
		int clients = 0;
		int totalWaitTime = 0;
		for(int i = 0; i < cashiers; i++){
			for(int j = 0; j < lines[i].size(); j++){
				clients++;
				totalWaitTime += lines[i].get(j).getExpectedServiceTime();
			}
		}
		return totalWaitTime/clients;
	}

	//theta(n^2)
	@Override
	public double getClientWaitTime(Client client) {
		for(int i = 0; i < cashiers; i++){
			for(int j = 0; j < lines[i].size(); j++){
				int totalWaitTime += lines[i].get(j).getExpectedServiceTime();
				if(lines[i].get(j) == client){
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
			for(int j = 0; j < lines[i].size(); j++){
				currentLineTime += lines[i].get(j).getExpectedServiceTime();
			}
			if(currentLineTime < shortestLineTime){
				shortestLineTime = currentLineTime;
				shortestLineIndex = i;
			}
		}
		lines[shortestLineIndex].add(client);
		return true;
	}

	@Override
	public void advanceMinute() {
		for(int i = 0; i < cashiers; i++){
			lines[i].get(0).servedMinute();
			if(lines[i].get(0).getExpectedServiceTime() <= 0){
				lines[i].remove(lines[i].get(0));
			}
		}
	}
}
