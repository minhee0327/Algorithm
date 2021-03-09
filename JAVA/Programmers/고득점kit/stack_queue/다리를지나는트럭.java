package programmers.stackQueue;

import java.util.LinkedList;
import java.util.Queue;

public class 다리를지나는트럭 {

	public static void main(String[] args) {
		System.out.println(solution(2, 10, new int[] { 7, 4, 5, 6 })); // 8
		System.out.println(solution(100, 100, new int[] { 10 })); // 101
		System.out.println(solution(100, 100, new int[] { 10, 10, 10, 10, 10, 10, 10, 10, 10, 10 })); // 110
	}

	static Queue<Integer> wait; // truck weights
	static Queue<Truck> running;// count add

	public static int solution(int bridge_length, int weight, int[] truck_weights) {
		wait = new LinkedList<>();
		running = new LinkedList<>();

		int currentWeight = 0;
		int exitTrucks = 0;
		int cnt = 0;

		for (int i = 0; i < truck_weights.length; i++) {
			wait.add(truck_weights[i]);
		}

		while (exitTrucks < truck_weights.length) {
			for (int i = 0; i < running.size(); i++) {
				Truck t = running.poll();
				running.add(new Truck(t.num, t.time + 1));
			}

			for (int i = 0; i < running.size(); i++) {
				Truck t = running.poll();
				if (t.time < bridge_length) {
					running.add(new Truck(t.num, t.time));
				} else {
					exitTrucks++;
					currentWeight -= t.num;
				}
			}
			cnt++;
			if (wait.isEmpty()) {
				continue;
			} else if (running.isEmpty()
					|| (currentWeight + wait.peek() <= weight && running.size() <= bridge_length)) {
				running.add(new Truck(wait.peek(), 0));
				currentWeight += wait.poll();
			}

		}
		return cnt;
	}

}

class Truck {
	int num;
	int time;

	Truck(int num, int time) {
		this.num = num;
		this.time = time;
	}
}