import java.util.*;

class MaxTrains {
	static int solution(int[] arrival, int[] departure) {
		int i=0; int j=0;
		int maxPlatforms = 0;
		Queue<int[]> queue = new LinkedList<int[]>();

		while(i<arrival.length || j<departure.length) {
			if(i<arrival.length) {
				if(arrival[i]<=departure[j]) {
					queue.add(new int[]{arrival[i], 0});
					i++;
				} else {
					queue.add(new int[]{departure[j], 1});
					j++;
				}
			}
			else {
				queue.add(new int[]{departure[j], 1});
				j++;
			}
		}

		int currentPlatforms = 0;
		while(!queue.isEmpty()) {
			int[] temp = queue.remove();
			if(temp[1]==0) {
				currentPlatforms++;
			} else {
				currentPlatforms--;
			}
			if(currentPlatforms>maxPlatforms) {
				maxPlatforms = currentPlatforms;
			}
		}
		return maxPlatforms;
	}

	public static void main(String[] arg) {
		int[] arrivals = {100, 200, 250, 300};
		int[] departures = {130, 280, 300 , 400};
		System.out.println(solution(arrivals, departures));
	}
}